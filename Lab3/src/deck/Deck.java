package deck;

import java.util.Arrays;

import card.base.Card;

public class Deck {
	private String name;
	private int deckSize;
	private Card[] deckList;

	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckList = deckList;
		this.deckSize = deckList.length;
	}

	// You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException {
		int count = 0;
		for (Card i : deckList) {
			if (card.isEqual(i))
				count++;
		}
		if (count >= 4)
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		deckSize = deckList.length;
		deckList = Arrays.copyOf(deckList, deckSize + 1);
		deckList[deckSize] = card;
		deckSize++;
		return deckSize;
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Must return new deckSize

	}

	// You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}
		deckSize = deckList.length;
		Card[] newDeckList = Arrays.copyOf(deckList, deckSize - 1);
		Card card = deckList[slotNumber];
		for (int i = 0; i < slotNumber; i++) {
			newDeckList[i] = deckList[i];
		}
		for (int i = slotNumber + 1; i < deckSize; i++) {
			newDeckList[i - 1] = deckList[i];
		}
		deckList = newDeckList;
		deckSize--;
		return card;
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Once card is removed, other card down the list must rearrange to the empty
		// slot
		// Must return card that was removed
	}

	public String getName() {
		return name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public Card[] getDeckList() {
		return deckList;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("{").append(this.getName()).append("}").append("(").append(this.getDeckSize())
				.append(" deck size)").toString();
	}

	/* GETTERS & SETTERS */

}
