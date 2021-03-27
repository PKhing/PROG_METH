package card.cards;

import card.base.CharacterCard;
import card.base.ItemCard;
import player.Player;

//You CAN modify the first line
public class ExodiaCharacterCard extends CharacterCard {

	public ExodiaCharacterCard() {
		super("Exodia the Forbidden One", "With 4 or more Exodia Part Card equiped, you win the game", 800, 0, 25);
//		String name = "Exodia the Forbidden One";
//		String description = "With 4 or more Exodia Part Card equiped, you win the game";
//		int lifePoint = 800;
//		int attackPoint = 0;
//		int defensePoint = 25;
	}

	public boolean winConditionCheck(ItemCard[] inventory) {
		int count = 0;
		for (ItemCard itemCard : inventory) {
			if (itemCard instanceof ExodiaPartCard)
				count++;
		}
		if (count >= 4)
			return true;
		return false;
	}

	@Override
	public int sacrifice(Player player) {
		int healLP = player.getMaxLifePoint() / 10;
		player.healPlayer(healLP);
		return healLP;
	}
}