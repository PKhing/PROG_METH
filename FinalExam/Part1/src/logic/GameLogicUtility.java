package logic;

import java.util.ArrayList;

import role.base.DayActable;
import role.base.NightActable;
import role.base.Player;

public class GameLogicUtility {
	public static void doNightAction(ArrayList<Player> targetPlayers) {
		ArrayList<Player> players = GameLogic.getInstance().getPlayerList();
		for (int i = 0; i < targetPlayers.size(); i++) {
			if (players.get(i) instanceof NightActable) {
				((NightActable) players.get(i)).nightAction(targetPlayers.get(i));
			}
		}
	}

	public static void doDayAction(ArrayList<Player> targetPlayers) {
		ArrayList<Player> players = GameLogic.getInstance().getPlayerList();
		for (int i = 0; i < targetPlayers.size(); i++) {
			if (players.get(i) instanceof DayActable) {
				((DayActable) players.get(i)).dayAction(targetPlayers.get(i));
			}
		}
	}
}
