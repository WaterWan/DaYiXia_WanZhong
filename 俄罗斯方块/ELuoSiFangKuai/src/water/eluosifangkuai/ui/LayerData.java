package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import water.eluosifangkuai.config.GameConfig;
import water.eluosifangkuai.dto.Player;

public abstract class LayerData extends Layer{

	/**
	 * 最大数据行
	 */
	private static final int MAX_ROW = GameConfig.getDataConfig().getMaxRow();
	
	/*
	 * 起始y坐标
	 */
	private static int STATR_Y = 0;
	
	/*
	 * 值槽外径
	 */
	private static final int RECT_H = IMG_RECT_H + 4;
	
	
	/*
	 * 间距
	 */
	private static int SPA = 0;
	
	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - RECT_H * 5 - (PANDDING << 1) - Img.DB.getHeight(null))/MAX_ROW;
		STATR_Y = PANDDING + Img.DB.getHeight(null) + SPA;
	}


	
	/*
	 * 绘制该窗口所有值槽
	 * 
	 * @param imgTitle 标题图片
	 * 
	 * @param players 数据源
	 * 
	 * @param g 画笔
	 * 
	 * 
	 */
	public void showData(Image imgTitle,List<Player> players,Graphics g){
		//绘制标题
		g.drawImage(imgTitle, this.x+PANDDING,this.y+PANDDING,null);
		//获得现在分数
		int nowPoint = this.dto.getNowPoint();
		//循环绘制记录
		for (int i = 0; i < MAX_ROW; i++) {
			//获得一条玩家记录
			Player pla = players.get(i);
			//获得该分数
			int recodePoint = pla.getPoint();
			//计算现在分数与记录分数的比值
			double percent = (double)nowPoint/(double)recodePoint;
			//如果已破记录，比例设为100%
			percent = percent > 1 ? 1.0 : percent;
			//绘制单条记录
			String strPoint = recodePoint == 0 ? null : Integer.toString(recodePoint);
			this.drawRect(STATR_Y + i * (RECT_H + SPA), 
					
					pla.getName(), strPoint, 
					percent, g);
		}
	}

	@Override
	abstract public void paint(Graphics g);
	
}
