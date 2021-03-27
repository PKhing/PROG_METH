package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Box;
import entity.Player;
import entity.Switch;
import logic.GameController;
import logic.Sprites;
import test.base.GameTest;

class SwitchTest extends GameTest {

	Switch test;
	Switch test2;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		test = new Switch();
		test2 = new Switch();
	}
	
	@Test
	void testGetSymbol() {
		assertEquals(Sprites.SWITCH_OFF,test.getSymbol());
		test.setActive(true);
		assertEquals(Sprites.SWITCH_ON,test.getSymbol());
	}
	
	@Test
	void testInteract_Player() {
		//Player can interact with switch
		assertEquals(false,test.interact(new Player()));
		//The switch turns on
		assertEquals(true,GameController.getGameSwitchStatus());
		test.interact(new Player());
		//The switch turns off
		assertEquals(false,GameController.getGameSwitchStatus());
	}
	
	@Test
	void testInteract_Other() {
		//Other Entity cannot interact with switch
		assertEquals(false,test.interact(new Box()));
		//The switch is still off
		assertEquals(false,GameController.getGameSwitchStatus());
	}
	
	@Test
	void testUpdate() {
		//Flip a switch one time, another switch should turns on too after update
		test.interact(new Player());
		test2.update();
		assertEquals(true,test2.isActive());
	}
}
