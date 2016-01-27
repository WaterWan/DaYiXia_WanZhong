package water.eluosifangkuai.dao;

import java.util.List;

import water.eluosifangkuai.dto.Player;

/*
 * 数据持久层接口
 */
public interface Data {

	/*
	 * 读取数据
	 */
	public List<Player> loadData();
	
	/*
	 * 存储数据
	 */
	public void saveData(List<Player> players);
}
