package water.eluosifangkuai.service;

import java.util.List;

import water.eluosifangkuai.dto.Player;

public interface GameService {

	/**
	 * �������
	 */
	public void keyUp();
	
	/**
	 * �������
	 */	
	public void keyDown();
	
	/**
	 * �������
	 */		
	public void keyLeft();
	
	/**
	 * �������
	 */		
	public void keyRight();
	
	/**
	 * ����
	 */	
	public void keyFunUp();
	
	/**
	 * ���
	 */	
	public void keyFunDown();
	
	/**
	 * ����
	 */	
	public void keyFunLeft();
	
	/**
	 * ԲȦ
	 */	
	public void keyFunRight();
	
	/**
	 * �������ݿ����ݶ���
	 */	
	public void setDbRecode(List<Player> players);
	
	/**
	 * ���ñ��ش������ݶ���
	 */	
	public void setDiskRecode(List<Player> players);

	/**
	 * �������̣߳���ʼ��Ϸ
	 */
	public void startMainThread();

}
