package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.ColorBox;
import entity.Player;
import logic.Direction;
import logic.GameController;
import logic.Sprites;
import test.base.GameTest;

class ColorBoxTest extends GameTest {

	ColorBox test;

	Player pl;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		test = new ColorBox(false);
		
		pl = new Player();
		
		GameController.getCurrentMap().addEntity(test, 2, 1);
		GameController.getCurrentMap().addEntity(new ColorBox(false), 2, 2);
		
		pl.setDirection(Direction.RIGHT);
		
	}
	
	@Test
	void testGetSymbol() {
		assertEquals(Sprites.BOX_BLUE,test.getSymbol());
		test.setActiveBool(true);
		assertEquals(Sprites.BOX_RED,test.getSymbol());
	}
	
	@Test
	void testInteract_SingleBox_ON() {
		//Can move down one square
		assertEquals(true,test.interact(pl));
		test.interact(pl);
		
		//This would get struck
		assertEquals(false,test.interact(pl));
	}
	
	@Test
	void testInteract_SingleBox_OFF() {
		//Flip the game's switch so it's no longer active.
		GameController.setGameSwitchStatus(true);
		//Cannot move
		assertEquals(false,test.interact(pl));
	}
	
	@Test
	void testInteract_MultiBox() {
		//Can move down one square
		pl.setDirection(Direction.DOWN);
		assertEquals(true,test.interact(pl));
		//This would get struck
		assertEquals(false,test.interact(pl));
	}

}
