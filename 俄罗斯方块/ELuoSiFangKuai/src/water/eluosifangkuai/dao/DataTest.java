package water.eluosifangkuai.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import water.eluosifangkuai.dto.Player;

public class DataTest implements Data {

	public DataTest(HashMap<String, String> param){
		
	}
	
	@Override
	public List<Player> loadData() {
		List<Player> players = new ArrayList<>();
		players.add(new Player("����", 2000));
		players.add(new Player("����", 655));
//		players.add(new Player("����", 545));
//		players.add(new Player("����", 100));
		players.add(new Player("����", 1545));
		return players;
	}

	@Override
	public void saveData(Player players) {

		System.out.println();
	}

}
