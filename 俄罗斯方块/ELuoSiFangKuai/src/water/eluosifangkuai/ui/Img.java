package water.eluosifangkuai.ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import water.eluosifangkuai.config.GameConfig;


public class Img {

	private Img(){}
	
	/*
	 * 个人签名
	 */
	public static Image SIGN = new ImageIcon("graphics/string/sign.png").getImage();
	
	/*
	 * 窗口图片
	 */
	public static Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	
	/*
	 * 数字图片 260 36
	 */
	public static Image NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	
	/*
	 * 矩形值槽
	 */
	public static Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	
	/*
	 * 数据库窗口标题
	 */
	public static Image DB = new ImageIcon("graphics/string/db.png").getImage();
	
	/*
	 * 本地记录窗口标题
	 */
	public static Image DISK = new ImageIcon("graphics/string/disk.png").getImage();
	
	/*
	 * 方块图片
	 */
	public static Image ACT = new ImageIcon("graphics/game/rect.png").getImage();
	
	/*
	 * 等级标题
	 */
	public static Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	
	/*
	 * 窗口标题(分数)
	 */
	public static Image POINT = new ImageIcon("graphics/string/point.png").getImage();

	/*
	 * 窗口标题(消行)
	 */
	public static Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	
	/**
	 * 阴影
	 */
	public static Image SHODOW = new ImageIcon("graphics/game/shadow.png").getImage();
	
	/**
	 * 开始按钮
	 */
	public static ImageIcon BTN_START = new ImageIcon("graphics/string/strat.png");
	
	/**
	 * 设置按钮
	 */
	public static ImageIcon BTN_CONFIG = new ImageIcon("graphics/string/config.png");
	
	/*
	 * 下一个图片数组
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	

	static{
		// 下一个方块图片
		NEXT_ACT=new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i]=new ImageIcon("graphics/game/" + i +".png").getImage();
		}
		
		//背景图片数组 
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<Image>();
		for (File file: files) {
			if (!file.isDirectory()) {
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}


		}
		
	}
}
