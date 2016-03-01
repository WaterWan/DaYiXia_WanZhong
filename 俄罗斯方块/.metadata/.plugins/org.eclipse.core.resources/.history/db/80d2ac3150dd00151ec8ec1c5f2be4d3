package main;

import water.eluosifangkuai.control.GameControl;
import water.eluosifangkuai.control.PlayerControl;
import water.eluosifangkuai.dto.GameDto;
import water.eluosifangkuai.service.GameTetris;
import water.eluosifangkuai.ui.JFrameGame;
import water.eluosifangkuai.ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		// 创建游戏数据源
		GameDto dto=new GameDto();
		// 创建游戏面板
		JPanelGame panel=new JPanelGame(dto);
		// 创建游戏逻辑块（连接游戏数据源）
		GameTetris service=new GameTetris(dto);
		// 创建游戏控制器（连接游戏面板与游戏逻辑块）
		GameControl gameControl= new GameControl(panel, service);
		// 将游戏控制器对象交给Panel
		panel.setGameControl(gameControl);
		// 创建玩家控制器（连接游戏控制器）
		PlayerControl control=new PlayerControl(gameControl);
		// 安装玩家控制器
		panel.setGameControl(control);
		// 创建游戏窗口，安装游戏面板
		new JFrameGame(panel);
	}

}
