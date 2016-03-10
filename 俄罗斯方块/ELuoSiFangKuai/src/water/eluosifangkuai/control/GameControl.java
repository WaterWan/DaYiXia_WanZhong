package water.eluosifangkuai.control;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import water.eluosifangkuai.config.DataInterfaceConfig;
import water.eluosifangkuai.config.GameConfig;
import water.eluosifangkuai.dao.Data;
import water.eluosifangkuai.dto.GameDto;
import water.eluosifangkuai.dto.Player;
import water.eluosifangkuai.service.GameService;
import water.eluosifangkuai.service.GameTetris;
import water.eluosifangkuai.ui.window.JFrameConfig;
import water.eluosifangkuai.ui.window.JFrameGame;
import water.eluosifangkuai.ui.window.JFrameSavePoint;
import water.eluosifangkuai.ui.window.JPanelGame;
import water.eluosifangkuai.util.GameFunction;

/**
 * ������Ҽ����¼� ���ƻ��� ������Ϸ�߼�
 * 
 */
public class GameControl {

	/**
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;

	/**
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;

	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;

	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;

	/**
	 * ��Ϸ�������ô���
	 */
	private JFrameConfig frameConfig;

	/**
	 * �����������
	 */
	private JFrameSavePoint frameSavePoint;

	/**
	 * ��Ϸ��Ϊ����
	 */
	private Map<Integer, Method> actionList;

	/**
	 * ��Ϸ�߳�
	 */
	private Thread gameThread = null;

	/**
	 * ��Ϸ����Դ
	 */
	private GameDto dto = null;

	public GameControl() {
		// ������Ϸ����Դ
		this.dto = new GameDto();
		// ������Ϸ�߼��飨������Ϸ����Դ��
		this.gameService = new GameTetris(dto);
		// �������ݽӿ�A����
		this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
		// �������ݿ��¼����Ϸ
		this.dto.setDbRecode(dataA.loadData());
		// �����ݽӿ�B��ñ��ش��̼�¼
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		// ���ñ��ش��̼�¼����Ϸ
		this.dto.setDiskRecode(dataB.loadData());
		// ������Ϸ���
		this.panelGame = new JPanelGame(this, dto);
		// ��ȡ�û���������
		this.setControlConfig();
		// ��ʼ���û����ô���
		this.frameConfig = new JFrameConfig(this);
		// ��ʼ�������������
		this.frameSavePoint = new JFrameSavePoint(this);
		// ��ʼ����Ϸ������(��װ��Ϸ���)
		new JFrameGame(this.panelGame);
	}

	/**
	 * ��ȡ�û���������
	 */
	private void setControlConfig() {
		// �����������뷽����������ӳ��
		this.actionList = new HashMap<Integer, Method>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/control.dat"));
			HashMap<Integer, String> cfgSet = (HashMap<Integer, String>) ois.readObject();
			Set<Entry<Integer, String>> entryset = cfgSet.entrySet();
			for (Entry<Integer, String> e : entryset) {
				actionList.put(e.getKey(), this.gameService.getClass().getMethod(e.getValue()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������ݶ���
	 * 
	 * @param cfg
	 * @return
	 */
	private Data createDataObject(DataInterfaceConfig cfg) {
		try {
			// ��������
			Class<?> cls = Class.forName(cfg.getClassName());
			// ��ù�����
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
			// ��������
			return (Data) ctr.newInstance(cfg.getParam());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ������ҿ�����ȷ����Ϊ
	 */
	public void actionByKeyCode(int keyCode) {
		try {
			if (this.actionList.containsKey(keyCode)) {
				this.actionList.get(keyCode).invoke(this.gameService);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.panelGame.repaint();
	}

	/**
	 * ��ʾ��ҿ��ƴ���
	 */
	public void showUserConfig() {
		this.frameConfig.setVisible(true);
	}

	/**
	 * �Ӵ��ڹر��¼�
	 */
	public void setOver() {
		this.panelGame.repaint();
		this.setControlConfig();
	}

	/**
	 * ��ʼ��ť�¼�
	 */
	public void start() {
		// ��尴ť����Ϊ���ɵ��
		this.panelGame.buttonSwitch(false);
		// �رմ���
		this.frameConfig.setVisible(false);
		this.frameSavePoint.setVisible(false);
		
		// ��Ϸ���ݳ�ʼ��
		this.gameService.startGame();
		// �����̶߳���
		this.gameThread = new MainThread();
		// �����߳�
		this.gameThread.start();
		// ˢ�»���
		this.panelGame.repaint();
	}

	/**
	 * �������
	 * 
	 * @param name
	 */
	public void savePoint(String name) {
		Player pla = new Player(name, this.dto.getNowPoint());
		// �����¼�����ݿ�
		this.dataA.saveData(pla);
		// �����¼�����ش���
		this.dataB.saveData(pla);
		// �������ݿ��¼����Ϸ
		this.dto.setDbRecode(dataA.loadData());
		// ���ñ��ش��̼�¼����Ϸ
		this.dto.setDiskRecode(dataB.loadData());
		// ˢ�»���
		this.panelGame.repaint();
	}

	/**
	 * ʧ��֮��Ĵ���
	 */
	private void afterLose() {
		if (!this.dto.isCheat()) {
			// ��ʾ����÷ִ���
			this.frameSavePoint.setVisible(true);
			this.frameSavePoint.showWindow(this.dto.getNowPoint());
		}
		// ʹ��ť���Ե��
		this.panelGame.buttonSwitch(true);
	}

	private class MainThread extends Thread {
		@Override
		public void run() {
			// ˢ�»���
			panelGame.repaint();
			// ��ѭ��
			while (dto.isStart()) {
				try {
					// �߳�˯��
					Thread.sleep(dto.getSleepTime());
					// �����ͣ����ô��ִ������Ϊ
					if (dto.isPause()) {
						continue;
					}
					// ��������
					gameService.mainAction();
					// ˢ�»���
					panelGame.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			afterLose();
		}
	}
}
