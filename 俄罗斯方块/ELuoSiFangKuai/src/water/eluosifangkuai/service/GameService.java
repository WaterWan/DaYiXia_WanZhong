package water.eluosifangkuai.service;

import java.util.List;

import water.eluosifangkuai.dto.Player;

public interface GameService {

	/**
	 * 方向键上
	 */
	public void keyUp();
	
	/**
	 * 方向键下
	 */	
	public void keyDown();
	
	/**
	 * 方向键左
	 */		
	public void keyLeft();
	
	/**
	 * 方向键右
	 */		
	public void keyRight();
	
	/**
	 * 三角
	 */	
	public void keyFunUp();
	
	/**
	 * 大叉
	 */	
	public void keyFunDown();
	
	/**
	 * 方块
	 */	
	public void keyFunLeft();
	
	/**
	 * 圆圈
	 */	
	public void keyFunRight();
	
	/**
	 * 设置数据库数据对象
	 */	
	public void setDbRecode(List<Player> players);
	
	/**
	 * 设置本地磁盘数据对象
	 */	
	public void setDiskRecode(List<Player> players);

	/**
	 * 启动主线程，开始游戏
	 */
	public void startMainThread();

}
