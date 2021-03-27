package test.student;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.base.ItemCard;
import card.cards.BasicCharacterCard;
import card.cards.BasicItemCard;
import card.cards.ExodiaPartCard;
import player.Player;

public class TestBasicItemCard {

	Player player;

	BasicItemCard item1 = new BasicItemCard("Item1", "item1", 10, 0, 0);
	BasicItemCard item2 = new BasicItemCard("Item2", "item2", 0, 10, 0);
	BasicItemCard item3 = new BasicItemCard("Item3", "item3", 10, 0, 10);
	BasicCharacterCard testChar = new BasicCharacterCard("Test Character", "test character", 150, 80, 60);
	ItemCard[] inventory1 = { item1, item2, item3, item1 };;

	@Before
	public void setUp() {
		player = new Player("testPlayer", 100, 50, 30);
	}

	@Test
	public void testConstructor() {

		assertEquals("Item1", item1.getName());
		assertEquals("item1", item1.getDescription());

	}

	@Test
	public void testEquipItem() {

		item1.equipItem(player);
		assertEquals(110, player.getMaxLifePoint());
		assertEquals(50, player.getAttack());
		assertEquals(30, player.getDefense());
		item2.equipItem(player);
		assertEquals(110, player.getMaxLifePoint());
		assertEquals(60, player.getAttack());
		assertEquals(30, player.getDefense());
		item3.equipItem(player);
		assertEquals(120, player.getMaxLifePoint());
		assertEquals(60, player.getAttack());
		assertEquals(40, player.getDefense());

		player.setCurrentLifePoint(100);
		item1.equipItem(player);
		assertEquals(130, player.getMaxLifePoint());
		assertEquals(110, player.getCurrentLifePoint());
		assertEquals(60, player.getAttack());
		assertEquals(40, player.getDefense());
		for (int i = 0; i < 4; i++) {
			assertEquals(inventory1[i], player.getInventory()[i]);
		}

	}

}