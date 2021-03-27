package card.cards;

import player.Player;
import card.base.ItemCard;

//You CAN modify the first line
public class BasicItemCard extends ItemCard {

	public BasicItemCard(String name, String description, int lpBonus, int attackBonus, int defenseBonus) {
		super(name, description, lpBonus, attackBonus, defenseBonus);
	}

	@Override
	public void equipItem(Player player) {
		player.addInventory(this);
		player.setMaxLifePoint(player.getMaxLifePoint() + lpBonus);
		player.setCurrentLifePoint(player.getCurrentLifePoint() + lpBonus);
		player.setAttack(player.getAttack() + attackBonus);
		player.setDefense(player.getDefense() + defenseBonus);
	}

}