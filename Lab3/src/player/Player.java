package player;

import java.util.Arrays;

import card.*;
import card.base.*;

import deck.Deck;
import deck.PremadeDeck;

public class Player {
	// TODO: constructor
	private String name;
	private int maxLifePoint;
	private int currentLifePoint;
	private int level;
	private int attack;
	private int defense;
	private Deck deck;
	private CharacterCard assignedCharacter;
	private ItemCard[] inventory;

	public Player(String name, int lifePoint, int attack, int defense) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.deck = PremadeDeck.premadeDecks[0];
		this.setMaxLifePoint(lifePoint);
		this.setCurrentLifePoint(lifePoint);
		this.inventory = new ItemCard[0];
		// this.CharacterCard =
	}

	public String toString() {
		return new StringBuilder().append("{").append(this.getName()).append(" : ")
				.append(this.getAssignedCharacter() == null ? this.getName() : this.getAssignedCharacter().getName())
				.append("}").append(":[").append("LP:").append(this.getCurrentLifePoint()).append("/")
				.append(this.getMaxLifePoint()).append(" atk:").append(this.getAttack()).append(" def:")
				.append(this.getDefense()).append("] ").append("(Deck Name = ").append(this.getDeck()).append(" )")
				.toString();
	}

	public String toStringShortVer() {
		return new StringBuilder().append("{").append(this.getName()).append(" : ")
				.append(this.getAssignedCharacter() == null ? this.getName() : this.getAssignedCharacter().getName())
				.append("}").append(":[").append("LP:").append(this.getCurrentLifePoint()).append("/")
				.append(this.getMaxLifePoint()).append(" atk:").append(this.getAttack()).append(" def:")
				.append(this.getDefense()).append("] ").toString();
	}

	/* GETTERS & SETTERS */
	public String getName() {
		return name;
	}

	public void setNewCharacterLifePoint(int maxLifePoint) {
		float lpPercent = (float) getCurrentLifePoint() / (float) getMaxLifePoint();
		setMaxLifePoint(maxLifePoint);
		setCurrentLifePoint((int) (maxLifePoint * lpPercent));

	}

	public void healPlayer(int lifePoint) {
		int totalHP = getCurrentLifePoint() + lifePoint;
		setCurrentLifePoint(totalHP > getMaxLifePoint() ? getMaxLifePoint() : totalHP);
	}

	public int getMaxLifePoint() {
		return maxLifePoint;
	}

	public void setMaxLifePoint(int maxLifePoint) {
		this.maxLifePoint = maxLifePoint;
	}

	public int getCurrentLifePoint() {
		return currentLifePoint;
	}

	public void setCurrentLifePoint(int currentLifePoint) {
		this.currentLifePoint = currentLifePoint;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public CharacterCard getAssignedCharacter() {
		return assignedCharacter;
	}

	public void setAssignedCharacter(CharacterCard assignedCharacter) {
		this.assignedCharacter = assignedCharacter;
	}

	public ItemCard[] getInventory() {
		return inventory;
	}

	public void addInventory(ItemCard itemcard) {
		this.inventory = Arrays.copyOf(this.inventory, this.inventory.length + 1);
		this.inventory[this.inventory.length - 1] = itemcard;
	}

	public void removeAllInventory() {
		this.inventory = new ItemCard[0];
	}

}
