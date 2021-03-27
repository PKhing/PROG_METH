package card.base;

import player.Player;

//You CAN modify the first line
public abstract class CharacterCard extends Card {

	protected int lifePoint;
	protected int attackPoint;
	protected int defensePoint;

	public CharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint) {
		super(name, description);
		this.attackPoint = attackPoint;
		this.lifePoint = lifePoint;
		this.defensePoint = defensePoint;
	}

	public void switchCharacter(Player player) {
		player.setNewCharacterLifePoint(lifePoint);
		player.setAttack(attackPoint);
		player.setDefense(defensePoint);
		player.setAssignedCharacter(this);
		/*
		 * Hint: Use setNewCharacterLifePoint(int) , setAttack(int) , setDefense (int) ,
		 * setAssignedCharacter (CharacterCard) from Player class
		 */
	}

	public abstract int sacrifice(Player player);

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " \t [Char][HP : " + this.lifePoint + " ATK : " + this.attackPoint + " DEF : "
				+ this.defensePoint + "]";
	}
}
