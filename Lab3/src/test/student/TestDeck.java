package test.student;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import card.base.Card;
import card.cards.BasicCharacterCard;
import card.cards.BasicItemCard;
import deck.Deck;
import deck.InsertCardFailedException;
import player.Player;
import deck.PremadeDeck;
import deck.RemoveCardFailedException;

public class TestDeck {

	Deck deck1, deck2, deck3;

	BasicCharacterCard BasicCha1 = new BasicCharacterCard("Basic Char 1", "basic char 1", 100, 10, 10);
	BasicCharacterCard BasicCha2 = new BasicCharacterCard("Basic Char 2", "basic char 2", 200, 20, 20);
	BasicItemCard ItemCard1 = new BasicItemCard("Basic Item1", "item1", 10, 0, 0);
	BasicItemCard ItemCard2 = new BasicItemCard("Basic Item2", "item2", 0, 10, 0);

	Card[] cardList1 = {};

	Card[] cardList2 = { BasicCha1, BasicCha1, BasicCha1, BasicCha1, BasicCha2, BasicCha2, BasicCha2, BasicCha2 };

	Card[] cardList3 = { BasicCha1, BasicCha1, BasicCha2, BasicCha2, ItemCard1, ItemCard1, ItemCard2, ItemCard2 };

	@Before
	public void setUp() {

		deck1 = new Deck("Test Deck 1", cardList1);

		deck2 = new Deck("Test Deck 2", cardList2);

		deck3 = new Deck("Test Deck 3", cardList3);

	}

	@Test
	public void testConstructor() {
		assertEquals("Test Deck 1", deck1.getName());
		assertEquals(0, deck1.getDeckSize());
		for (int i = 0; i < deck1.getDeckSize(); i++) {
			assertEquals(cardList1[i], deck1.getDeckList()[i]);
		}

		assertEquals("Test Deck 2", deck2.getName());
		assertEquals(8, deck2.getDeckSize());
		for (int i = 0; i < deck2.getDeckSize(); i++) {
			assertEquals(cardList2[i], deck2.getDeckList()[i]);
		}

		assertEquals("Test Deck 3", deck3.getName());
		assertEquals(8, deck3.getDeckSize());
		for (int i = 0; i < deck3.getDeckSize(); i++) {
			assertEquals(cardList3[i], deck3.getDeckList()[i]);
		}

	}

	@Test
	public void testInsertCard() {
		try {
			deck1.insertCard(ItemCard1);
		} catch (InsertCardFailedException e) {
			fail("InsertCardFailedException deck1 throws error");
		}
		Card[] cardList1New = { ItemCard1 };
		assertEquals(1, deck1.getDeckSize());
		for (int i = 0; i < deck1.getDeckSize(); i++) {
			assertEquals(cardList1New[i], deck1.getDeckList()[i]);
		}

		try {
			deck3.insertCard(ItemCard1);
		} catch (InsertCardFailedException e) {
			fail("InsertCardFailedException deck3 throws error");
		}
		Card[] cardList3New = { BasicCha1, BasicCha1, BasicCha2, BasicCha2, ItemCard1, ItemCard1, ItemCard2, ItemCard2,
				ItemCard1 };
		assertEquals(9, deck3.getDeckSize());
		for (int i = 0; i < deck3.getDeckSize(); i++) {
			assertEquals(cardList3New[i], deck3.getDeckList()[i]);
		}

	}

	@Test
	public void testInsertCardMoreThan4Card() {
		for (int i = 0; i < 4; i++) {
			try {
				deck1.insertCard(ItemCard1);
			} catch (InsertCardFailedException e) {
				fail("You insert too many " + ItemCard1.getName() + " Card)");
			}
		}
		assertThrows(InsertCardFailedException.class, () -> {
			deck1.insertCard(ItemCard1);
		});

	}

	@Test
	public void testRemoveCard() {
		// Case 1
		try {
			assertEquals(deck2.removeCard(5), BasicCha2);
		} catch (RemoveCardFailedException e) {
			fail("RemoveCardFailedException deck2 throws error");
		}

		Card[] cardList2New = { BasicCha1, BasicCha1, BasicCha1, BasicCha1, BasicCha2, BasicCha2, BasicCha2 };
		assertEquals(7, deck2.getDeckSize());
		for (int i = 0; i < deck2.getDeckSize(); i++) {
			assertEquals(cardList2New[i], deck2.getDeckList()[i]);
		}

		// Case 2
		try {
			assertEquals(deck3.removeCard(6), ItemCard2);
		} catch (RemoveCardFailedException e) {
			fail("RemoveCardFailedException deck3 throws error");
		}

		Card[] cardList3New = { BasicCha1, BasicCha1, BasicCha2, BasicCha2, ItemCard1, ItemCard1, ItemCard2 };
		assertEquals(7, deck3.getDeckSize());
		for (int i = 0; i < deck3.getDeckSize(); i++) {
			assertEquals(cardList3New[i], deck3.getDeckList()[i]);
		}

	}

	@Test
	public void textRemoveNonExsistanceCard() {
		try {
			deck1.insertCard(null);
			deck1.insertCard(ItemCard1);
		} catch (InsertCardFailedException e) {
			fail("Insert card fail");
		}
		assertThrows(RemoveCardFailedException.class, () -> {
			deck1.removeCard(0);
		});
	}

}
