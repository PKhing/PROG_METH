package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Box;
import entity.Key;
import entity.TrashCompactor;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;
import test.base.GameTest;

class TrashCompactorTest extends GameTest {

	TrashCompactor test;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		test = new TrashCompactor();
		
		GameController.getCurrentMap().addEntity(test, 2, 1);
		
	}
	
	@Test
	void testGetSymbol() {
		assertEquals(Sprites.COMPACTOR_ON,test.getSymbol());
		test.setCooldown(1);
		assertEquals(Sprites.COMPACTOR_OFF,test.getSymbol());
	}
	
	@Test
	void testInteract_Box_ON() {
		//Box can pass
		assertEquals(true,test.interact(new Box()));
	}
	
	@Test
	void testInteract_Box_OFF() {
		//Box cannot pass if cooldown
		test.setCooldown(1);
		assertEquals(false,test.interact(new Box()));
	}
	
	@Test
	void testInteract_Other() {
		//Other Entity cannot pass
		assertEquals(false,test.interact(new Key()));
	}
	
	@Test
	void testConsume_Box_ON() {
		//Can consume Box if not cooldown
		assertEquals(true,test.consume(new Box()));
		assertEquals(11,test.getCooldown());
	}
	
	@Test
	void testConsume_Box_OFF() {
		//Cannot consume Box if cooldown
		test.setCooldown(1);
		assertEquals(false,test.consume(new Box()));
		assertEquals(1,test.getCooldown());
	}
	
	@Test
	void testConsume_Other() {
		//Cannot consume other
		assertEquals(false,test.consume(new Key()));
	}
	
	@Test
	void testUpdate() {
		//The cooldown must decrease after update
		try {
			test.setCooldown(2);
			test.update();
			assertEquals(1,test.getCooldown());
			test.update();
			test.update();
			assertEquals(0,test.getCooldown());
		}catch(IllegalValueException e) {
			fail("Exception Encountered.");
		}
	}

}
