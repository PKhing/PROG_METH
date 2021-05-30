package logic;

import java.util.ArrayList;

import role.base.DayActable;
import role.base.NightActable;
import role.base.Player;
import role.derived.Detective;
import role.derived.Mafia;
import role.derived.Mayor;

public class GameLogic {

	private static GameLogic instance = null;
	private ArrayList<Player> playerList;
	private boolean isGameEnd;
	private boolean isNightTime;
	
	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public boolean isNightTime() {
		return isNightTime;
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public void setNightTime(boolean isNightTime) {
		this.isNightTime = isNightTime;
	}

	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}
	
	private GameLogic() {
		initializeGame();
	}
	
	public void initializeGame() {
		playerList = new ArrayList<Player>();
		setGameEnd(false);
		setNightTime(false);
		
		Mayor my = new Mayor("Junko");
		
		Detective d1 = new Detective("Aoi");
		Detective d2 = new Detective("Kiyotaka");
		Detective d3 = new Detective("Chihiro");
		Detective d4 = new Detective("Sakura");
		Detective d5 = new Detective("Leon");
		Detective d6 = new Detective("Naegi");
		
		Mafia mf1 = new Mafia("Maizono");
		
		playerList.add(my);
		playerList.add(d1);
		playerList.add(d2);
		playerList.add(d3);
		playerList.add(d4);
		playerList.add(d5);
		playerList.add(d6);
		playerList.add(mf1);
	}
	
	public Player removeVictimPlayer(String targetName) {
		for(int i = 0; i < playerList.size() ; i++) {
			if(playerList.get(i).getPlayerName() == targetName) {
				return playerList.remove(i);
			}
		}
		return new Detective("No one");
	}
	
	public void resetAllVotes() {
		for(int i = 0; i < playerList.size() ; i++) {
			 playerList.get(i).resetVotedScore();
		}
	}
	
	public Player removeVotedPlayer() {
		int removePosition = -1;
		int maxVoteCheck = -1;
		boolean maxVoteDuplicateCheck = false;
		for(int i = 0; i < playerList.size() ; i++) {
			if(playerList.get(i).getVotedScore() > maxVoteCheck) {
				maxVoteCheck = playerList.get(i).getVotedScore();
				removePosition = i;
				maxVoteDuplicateCheck = false;
			}
			if(playerList.get(i).getVotedScore() == maxVoteCheck) {
				maxVoteDuplicateCheck = true;
			}
		}
		
		if(removePosition > -1 && maxVoteDuplicateCheck) 
		{
			return playerList.remove(removePosition);
		}
		
		return new Detective("No one");
	}
	
	public void checkGameEnd() {
		int mafiaCount = 0;
		int nonMafiaCount = 0;
		for(Player player: playerList) {
			if(player instanceof Mafia) {
				mafiaCount++;
			}else {
				nonMafiaCount++;
			}
		}
		
		if(mafiaCount >= nonMafiaCount) {
			setGameEnd(true);
			System.out.println("Mafia win the game");
		}
		else if(mafiaCount == 0) {
			setGameEnd(true);
			System.out.println("Detective and Mayor win the game");
		}
	}
	
	public void voting(ArrayList<Player> targetPlayers) {
		for (int i = 0; i<playerList.size();i++) {
			playerList.get(i).vote(targetPlayers.get(i));
		}
	}
	
	public void doNightAction(ArrayList<Player> targetPlayers) {
		GameLogicUtility.doNightAction(targetPlayers);
	}
	
	public void doDayAction(ArrayList<Player> targetPlayers) {
		GameLogicUtility.doDayAction(targetPlayers);
	}
}
