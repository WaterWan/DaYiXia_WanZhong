package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import water.eluosifangkuai.config.GameConfig;
import water.eluosifangkuai.dto.Player;

public abstract class LayerData extends Layer{

	/**
	 * ���������
	 */
	private static final int MAX_ROW = GameConfig.getDataConfig().getMaxRow();
	
	/*
	 * ��ʼy����
	 */
	private static int STATR_Y = 0;
	
	/*
	 * ֵ���⾶
	 */
	private static final int RECT_H = IMG_RECT_H + 4;
	
	
	/*
	 * ���
	 */
	private static int SPA = 0;
	
	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - RECT_H * 5 - (PANDDING << 1) - Img.DB.getHeight(null))/MAX_ROW;
		STATR_Y = PANDDING + Img.DB.getHeight(null) + SPA;
	}


	
	/*
	 * ���Ƹô�������ֵ��
	 * 
	 * @param imgTitle ����ͼƬ
	 * 
	 * @param players ����Դ
	 * 
	 * @param g ����
	 * 
	 * 
	 */
	public void showData(Image imgTitle,List<Player> players,Graphics g){
		//���Ʊ���
		g.drawImage(imgTitle, this.x+PANDDING,this.y+PANDDING,null);
		//������ڷ���
		int nowPoint = this.dto.getNowPoint();
		//ѭ�����Ƽ�¼
		for (int i = 0; i < MAX_ROW; i++) {
			//���һ����Ҽ�¼
			Player pla = players.get(i);
			//��ø÷���
			int recodePoint = pla.getPoint();
			//�������ڷ������¼�����ı�ֵ
			double percent = (double)nowPoint/(double)recodePoint;
			//������Ƽ�¼��������Ϊ100%
			percent = percent > 1 ? 1.0 : percent;
			//���Ƶ�����¼
			String strPoint = recodePoint == 0 ? null : Integer.toString(recodePoint);
			this.drawRect(STATR_Y + i * (RECT_H + SPA), 
					
					pla.getName(), strPoint, 
					percent, g);
		}
	}

	@Override
	abstract public void paint(Graphics g);
	
}
