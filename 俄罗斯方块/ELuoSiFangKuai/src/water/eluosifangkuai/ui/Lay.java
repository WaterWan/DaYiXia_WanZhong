package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * 绘制窗口
 * @author Lenovo
 *
 */

public class Lay {

	private static final int SIZE =7;
	private static Image WINDOW_IMG=new ImageIcon("graphics/window/Window.png").getImage();
	private static int WINDOW_W=WINDOW_IMG.getWidth(null);
	private static int WINDOW_H=WINDOW_IMG.getHeight(null);
	
	
	/**
	 * 窗口左上角x坐标
	 */
	private int x;
	
	/**
	 * 窗口左上角y坐标
	 */
	private int y;
	
	/**
	 * 窗口宽度
	 */
	private int w;
	
	/**
	 * 窗口高度
	 */
	private int h;
	

	public Lay(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.h=h;
		this.w=w;
		
	}
	
	/**
	 * 绘制窗口
	 */
	public void createWindow(Graphics g){
		g.drawImage(WINDOW_IMG, x, y, x+SIZE,y+SIZE, 0, 0, SIZE, SIZE, null);//左上
		//(参数,显示起点x,显示起点y,显示终点x,显示终点y,切割起点x,切割起点y,切割终点x,切割终点y,null)
		//(a,b,c,d,a1,b1,c1,d1)表示将[从(a1,b1)到(c1,d1)的矩形区域]放大到[从(a,b)到(c,d)的矩形区域]
		//从左上角的坐标到右下角的坐标
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE,y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);//中上
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);//右上
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);//左中
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);//中
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);//右中
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);//左下
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);//中下
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);//右下
	
	}
	
}
