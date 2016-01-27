package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.util.List;

import water.eluosifangkuai.dto.Player;

public class LayerDataBase extends Layer{
	
	//TODO 配置文件
	private static final int MAX_ROW = 5;
	
	/*
	 * 起始y坐标
	 */
	private static int STATR_Y = 0;
	
	private static final int RECT_H = IMG_RECT_H + 4;
	
	/*
	 * 间距
	 */
	private static int SPA = 0;

	public LayerDataBase(int x,int y,int w,int h){
		super(x,y,w,h);
		SPA = (this.h - RECT_H * 5 - (PANDDING << 1) - Img.DB.getHeight(null))/MAX_ROW;
		STATR_Y = PANDDING + Img.DB.getHeight(null) + SPA;
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.DB, this.x+PANDDING,this.y+PANDDING,null);
		List<Player> players = this.dto.getDbRecode();
		int nowPoint = this.dto.getNowPoint();
		for (int i = 0; i < MAX_ROW; i++) {
			Player pla = players.get(i);
			int recodePoint = pla.getPoint();
			double percent = (double)nowPoint/(double)recodePoint;
			percent = percent > 1 ? 1.0 : percent;
			this.drawRect(STATR_Y + i * (RECT_H + SPA), 
					"No data", Integer.toString(recodePoint), 
					percent, g);
		}
		
	}
}
