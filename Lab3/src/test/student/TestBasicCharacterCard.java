package test.student;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import card.cards.BasicCharacterCard;

import player.Player;

public class TestBasicCharacterCard {

	Player player;
	BasicCharacterCard testChar;

	@Before
	public void setUp() {
		player = new Player("testPlayer", 100, 50, 30);
		testChar = new BasicCharacterCard("Test Character", "test character", 150, 80, 60);
	}

	@Test
	public void testConstructor() {

		assertEquals("Test Character", testChar.getName());
		assertEquals("test character", testChar.getDescription());

	}

	@Test
	public void testSwitchCharacter() {

		testChar.switchCharacter(player);
		assertEquals(150, player.getMaxLifePoint());
		assertEquals(80, player.getAttack());
		assertEquals(60, player.getDefense());

		player.setCurrentLifePoint(120);
		BasicCharacterCard testChar2 = new BasicCharacterCard("Test Character 2", "test character 2", 200, 100, 80);
		testChar2.switchCharacter(player);

		assertEquals(200, player.getMaxLifePoint());
		assertEquals(160, player.getCurrentLifePoint());
		assertEquals(100, player.getAttack());
		assertEquals(80, player.getDefense());
	}

	@Test
	public void testSacrifice() {
		player.setCurrentLifePoint(60);
		testChar.sacrifice(player);
		assertEquals(76, player.getCurrentLifePoint());

		BasicCharacterCard testChar3 = new BasicCharacterCard("Test Character 3", "test character 3", 150, 40, 20);
		player.setCurrentLifePoint(50);
		testChar3.sacrifice(player);
		assertEquals(66, player.getCurrentLifePoint());
	}
}
