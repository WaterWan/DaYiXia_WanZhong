package water.eluosifangkuai.ui;

import java.awt.Graphics;

public class LayerLevel extends Layer {
	

	
	/*
	 * 标题图片的宽度
	 */
	private static final int IMG_LV_W=Img.LEVEL.getWidth(null);
	

	
	public LayerLevel(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题
		int centerX=this.w-IMG_LV_W>>1;
		g.drawImage(Img.LEVEL, this.x+centerX, this.y+PANDDING, null);
		//显示等级
		this.drawNumberLeftPad(centerX, 64, this.dto.getNowLevel(), 2, g);
		
	}

	/*
	 * 显示数字
	 * 
	 * @param x 左上角x坐标
	 * 
	 * @param y 左上角y坐标
	 * 
	 * @param num 要显示的数字
	 * 
	 * @param maxBit 数字位数
	 * 
	 * @param g 画笔对象
	 * 
	 */
	
}
