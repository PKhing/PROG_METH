package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Box;
import entity.Door;
import entity.Key;
import logic.GameController;
import logic.Sprites;
import test.base.GameTest;

class DoorTest extends GameTest {

	Door test;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		test = new Door();
		
		GameController.getCurrentMap().addEntity(test, 2, 1);
		
	}
	
	@Test
	void testGetSymbol() {
		assertEquals(Sprites.DOOR,test.getSymbol());
	}
	
	@Test
	void testInteract_Key() {
		//Key can pass
		assertEquals(true,test.interact(new Key()));
	}
	
	@Test
	void testInteract_Other() {
		//Other Entity cannot pass
		assertEquals(false,test.interact(new Box()));
	}
	
	@Test
	void testConsume_Key() {
		//Can consume Key
		assertEquals(true,test.consume(new Key()));
		//The door is gone
		assertEquals(true,GameController.getCurrentMap().getMap()[1][2].IsEmpty());
	}
	
	@Test
	void testConsume_Other() {
		//Cannot consume other
		assertEquals(false,test.consume(new Box()));
		//The door stays
		assertEquals(false,GameController.getCurrentMap().getMap()[1][2].IsEmpty());
	}

}
