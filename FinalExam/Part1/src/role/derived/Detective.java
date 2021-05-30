package role.derived;

import role.base.DayActable;
import role.base.NightActable;
import role.base.Player;

public class Detective extends Player implements DayActable, NightActable {

	public Detective(String playerName) {
		super(playerName);
	}

	@Override
	public void nightAction(Player targetPlayer) {
		if (targetPlayer instanceof Mafia) {
			System.out.println(targetPlayer.getPlayerName() + " is the Mafia boss");
		} else {
			System.out.println(targetPlayer.getPlayerName() + " is not the Mafia boss");
		}
	}

	@Override
	public void dayAction(Player targetPlayer) {
		if (targetPlayer instanceof Mayor) {
			System.out.println(targetPlayer.getPlayerName() + " is the Mayor");
		} else {
			System.out.println(targetPlayer.getPlayerName() + " is not the Mayor");
		}

	}

}
