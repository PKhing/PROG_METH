package test.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import card.base.ItemCard;
import card.cards.BasicCharacterCard;
import card.cards.BasicItemCard;
import card.cards.ExodiaCharacterCard;
import card.cards.ExodiaPartCard;
import card.cards.MainCharacterCard;
import player.Player;

public class TestExodiaCharacterCard {
	Player player;
	ExodiaCharacterCard testExodia;
	BasicItemCard item1 = new BasicItemCard("Item1", "item1", 10, 0, 0);
	ExodiaPartCard exodiaItem = new ExodiaPartCard("exodiaItem", 10);
	ItemCard[] inventory1 = { item1, item1, item1, item1 };
	ItemCard[] inventory2 = { item1, item1, exodiaItem, exodiaItem };
	ItemCard[] inventory3 = { exodiaItem, exodiaItem, exodiaItem, exodiaItem };

	@Before
	public void setUp() {
		player = new Player("testPlayer", 400, 50, 30);
		testExodia = new ExodiaCharacterCard();

	}

	@Test
	public void testConstructor() {

		assertEquals("Exodia the Forbidden One", testExodia.getName());
		assertEquals("With 4 or more Exodia Part Card equiped, you win the game", testExodia.getDescription());

	}

	@Test
	public void testSwitchCharacter() {
		player.setCurrentLifePoint(200);
		testExodia.switchCharacter(player);
		assertEquals(800, player.getMaxLifePoint());
		assertEquals(400, player.getCurrentLifePoint());
		assertEquals(0, player.getAttack());
		assertEquals(25, player.getDefense());
	}

	@Test
	public void testSacrifice() {
		testExodia.switchCharacter(player);
		player.setCurrentLifePoint(400);
		assertEquals(80, testExodia.sacrifice(player));
		assertEquals(480, player.getCurrentLifePoint());

	}

	@Test
	public void testWinConditionCheck() {
		assertFalse(testExodia.winConditionCheck(inventory1));
		assertFalse(testExodia.winConditionCheck(inventory2));
		assertTrue(testExodia.winConditionCheck(inventory3));
	}
	// Fill Code Here!!!
	// 1.testSwitchCharacter
	// 2.testSacrifice
	// 3.testWinConditionCheck

}