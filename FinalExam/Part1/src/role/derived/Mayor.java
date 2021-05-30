package role.derived;

import role.base.DayActable;
import role.base.Player;

public class Mayor extends Player implements DayActable {

	public Mayor(String playerName) {
		super(playerName);
	}

	@Override
	public void dayAction(Player targetPlayer) {
		targetPlayer.setVotable(false);
	}

}
