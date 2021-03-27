package test.student;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.base.ItemCard;
import card.cards.BasicCharacterCard;
import card.cards.BasicItemCard;
import card.cards.ExodiaCharacterCard;
import card.cards.ExodiaPartCard;
import player.Player;

public class TestExodiaPartCard {

	Player player;
	ExodiaCharacterCard exodia;

	ExodiaPartCard exodiaP1 = new ExodiaPartCard("Part1", 10);
	ExodiaPartCard exodiaP2 = new ExodiaPartCard("Part2", 20);
	ExodiaPartCard exodiaP3 = new ExodiaPartCard("Part3", 25);
	ExodiaCharacterCard exodiaChar = new ExodiaCharacterCard();

	ItemCard[] inventory1 = { exodiaP1, exodiaP2, exodiaP3, exodiaP1 };;

	@Before
	public void setUp() {
		player = new Player("testPlayer", 100, 50, 30);
		exodia = new ExodiaCharacterCard();
	}

	@Test
	public void testConstructor() {

		assertEquals("Part1", exodiaP1.getName());
		assertEquals("Assemble 4 of Exodia part card to win the game", exodiaP1.getDescription());

	}

	@Test
	public void testEquipItem() {
		exodiaP1.equipItem(player);
		assertEquals(100, player.getMaxLifePoint());
		assertEquals(50, player.getAttack());
		assertEquals(40, player.getDefense());
		exodiaP2.equipItem(player);
		assertEquals(100, player.getMaxLifePoint());
		assertEquals(50, player.getAttack());
		assertEquals(60, player.getDefense());
		exodiaP3.equipItem(player);
		assertEquals(100, player.getMaxLifePoint());
		assertEquals(50, player.getAttack());
		assertEquals(85, player.getDefense());
		exodiaP1.equipItem(player);
		assertEquals(100, player.getMaxLifePoint());
		assertEquals(50, player.getAttack());
		assertEquals(95, player.getDefense());

		for (int i = 0; i < 4; i++) {
			assertEquals(inventory1[i], player.getInventory()[i]);
		}
	}

	@Test
	public void testEquipItemExodiaCase() {
		exodia.switchCharacter(player);
		assertEquals(25, player.getDefense());
		exodiaP1.equipItem(player);
		assertEquals(800, player.getMaxLifePoint());
		assertEquals(0, player.getAttack());
		assertEquals(45, player.getDefense());
		exodiaP2.equipItem(player);
		assertEquals(800, player.getMaxLifePoint());
		assertEquals(0, player.getAttack());
		assertEquals(85, player.getDefense());
		exodiaP3.equipItem(player);
		assertEquals(800, player.getMaxLifePoint());
		assertEquals(0, player.getAttack());
		assertEquals(135, player.getDefense());
	}

}