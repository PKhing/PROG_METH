package test.student;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.cards.BasicCharacterCard;
import card.cards.MainCharacterCard;
import player.Player;

public class TestMainCharacter {

	Player player;
	MainCharacterCard testMainChar;

	@Before
	public void setUp() {
		player = new Player("testPlayer", 300, 50, 30);
		testMainChar = new MainCharacterCard("Test Main Character", "test maincharacter", 250, 100, 80, 0.2f);
	}

	@Test
	public void testConstructor() {

		assertEquals("Test Main Character [level 0]", testMainChar.getName());
		assertEquals("test maincharacter", testMainChar.getDescription());
		assertEquals(0, testMainChar.getLevel());
	}

	@Test
	public void testSwitchCharacter() {
		player.setCurrentLifePoint(150);
		testMainChar.switchCharacter(player);
		assertEquals(250, player.getMaxLifePoint());
		assertEquals(125, player.getCurrentLifePoint());
		assertEquals(100, player.getAttack());
		assertEquals(80, player.getDefense());
	}

	@Test
	public void testSacrifice() {
		testMainChar.switchCharacter(player);
		player.setCurrentLifePoint(125);
		assertEquals(31, testMainChar.sacrifice(player));
		assertEquals(156, player.getCurrentLifePoint());
	}

	@Test
	public void testLevelUp() {
		testMainChar.switchCharacter(player);
		assertEquals("Test Main Character [level 0]", testMainChar.getName());

		testMainChar.levelUp(player);
		assertEquals("Test Main Character [level 1]", testMainChar.getName());
		assertEquals(300, player.getMaxLifePoint());
		assertEquals(120, player.getAttack());
		assertEquals(96, player.getDefense());

		testMainChar.levelUp(player);
		assertEquals("Test Main Character [level 2]", testMainChar.getName());
		assertEquals(360, player.getMaxLifePoint());
		assertEquals(144, player.getAttack());
		assertEquals(115, player.getDefense());

	}

}