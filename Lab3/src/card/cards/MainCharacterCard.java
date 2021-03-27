package card.cards;

import card.base.CharacterCard;
import player.Player;

//You CAN modify the first line
public class MainCharacterCard extends CharacterCard {

	private int level;
	private float levelUpBonus;

	public MainCharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint,
			float levelUpBonus) {
		super(name, description, lifePoint, attackPoint, defensePoint);
		this.levelUpBonus = levelUpBonus;
	}

	public float levelUp(Player player) {
		player.setNewCharacterLifePoint((int) ((1 + levelUpBonus) * player.getMaxLifePoint()));
		player.setAttack((int) ((1 + levelUpBonus) * player.getAttack()));
		player.setDefense((int) ((1 + levelUpBonus) * player.getDefense()));
		setLevel(getLevel() + 1);
		return levelUpBonus;
	};

	@Override
	public String getName() {
		return super.getName() + " [level " + this.getLevel() + "]";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int sacrifice(Player player) {
		int healLP = player.getMaxLifePoint() / 8;
		player.healPlayer(healLP);
		return healLP;
	}

}
