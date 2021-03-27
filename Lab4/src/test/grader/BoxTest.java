package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Box;
import entity.Player;
import logic.Direction;
import logic.GameController;
import logic.Sprites;
import test.base.GameTest;

class BoxTest extends GameTest{
	
	Box test;
	
	Player pl;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		test = new Box();
		GameController.getCurrentMap().addEntity(test, 2, 1);
		GameController.getCurrentMap().addEntity(new Box(), 2, 2);
		
		pl = new Player();
		pl.setDirection(Direction.RIGHT);
		
	}
	
	@Test
	void testGetSymbol() {
		assertEquals(Sprites.BOX,test.getSymbol());
	}
	
	@Test
	void testInteract_SingleBox() {
		//Can move down one square
		assertEquals(true,test.interact(pl));
		test.interact(pl);
		
		//This would get struck
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
