package card.cards;

import card.base.ItemCard;
import player.Player;

//You CAN modify the first line
public class ExodiaPartCard extends ItemCard {

	public ExodiaPartCard(String name, int defense) {
		super(name, "Assemble 4 of Exodia part card to win the game", 0, 0, defense);
//		String description = "Assemble 4 of Exodia part card to win the game";
//		int lpBonus = 0;
//		int attackBonus = 0;

	}

	@Override
	public void equipItem(Player player) {
		player.addInventory(this);
		if (player.getAssignedCharacter() instanceof ExodiaCharacterCard) {
			player.setMaxLifePoint(player.getMaxLifePoint() + lpBonus * 2);
			player.setCurrentLifePoint(player.getCurrentLifePoint() + lpBonus * 2);
			player.setAttack(player.getAttack() + attackBonus * 2);
			player.setDefense(player.getDefense() + defenseBonus * 2);
		} else {
			player.setMaxLifePoint(player.getMaxLifePoint() + lpBonus);
			player.setCurrentLifePoint(player.getCurrentLifePoint() + lpBonus);
			player.setAttack(player.getAttack() + attackBonus);
			player.setDefense(player.getDefense() + defenseBonus);
		}

	}

}