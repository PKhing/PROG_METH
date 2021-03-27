package logic;


import entity.Player;


public class GameController {

	private static GameMap gameMap;

	private static Player player;
	
	private static int coin_count;
	
	private static boolean is_win;
	
	private static boolean game_switch;
	
	public static final int MAX_COOLDOWN_TIME = 11;
	
	public static void IntializeMap(String[][] map,int px,int py) {
		 player = new Player();
		 
		 setCoinCount(0);
		 setGameWin(false);
		 setGameSwitchStatus(false);
		 
		 gameMap = new GameMap(map);
		 
		 gameMap.addEntity(player, px, py);
	}
	
	public static void printMap() {
		gameMap.printMap();
	}
	
	public static GameMap getCurrentMap() {
		return gameMap;
	}
	
	public static void movePlayer(Direction dir) {
		player.move(dir);
	}

	public static int getCoinCount() {
		return coin_count;
	}

	public static void setCoinCount(int coin_count) {
		GameController.coin_count = coin_count;
	}
	
	public static void addCoinCount(int coin_count) {
		GameController.coin_count += coin_count;
	}

	public static boolean isGameWin() {
		return is_win;
	}

	public static void setGameWin(boolean is_win) {
		GameController.is_win = is_win;
	}

	public static boolean getGameSwitchStatus() {
		return game_switch;
	}

	public static void setGameSwitchStatus(boolean game_switch) {
		GameController.game_switch = game_switch;
	}
	
	
	

}
