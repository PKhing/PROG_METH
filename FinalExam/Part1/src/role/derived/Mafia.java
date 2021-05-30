package role.derived;

import logic.GameLogic;
import role.base.NightActable;
import role.base.Player;

public class Mafia extends Player implements NightActable {

	public Mafia(String playerName) {
		super(playerName);
	}

	@Override
	public void nightAction(Player targetPlayer) {
		Player victim = GameLogic.getInstance().removeVictimPlayer(targetPlayer.getPlayerName());
		System.out.println(victim.getPlayerName() + " will be a dead body when day comes");
	}

}
