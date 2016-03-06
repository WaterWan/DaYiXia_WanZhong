package water.eluosifangkuai.ui.window;
import javax.swing.JFrame;

import water.eluosifangkuai.config.FrameConfig;
import water.eluosifangkuai.config.GameConfig;
import water.eluosifangkuai.util.FrameUtil;

public class JFrameGame extends JFrame{

	public JFrameGame(JPanelGame panelGame){
		//�����Ϸ����
		FrameConfig fCfg = GameConfig.getFrameConfig();
		//���ñ���
		this.setTitle(fCfg.getTitle());
		//���Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(fCfg.getWidth(),fCfg.getHeight());
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		//����
		FrameUtil.setFrameCenter(this);
		//����Ĭ��Panel
		this.setContentPane(panelGame);
		//Ĭ�ϸô���Ϊ��ʾ
		this.setVisible(true);
	}
		
}
