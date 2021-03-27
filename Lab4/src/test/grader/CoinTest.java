package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Box;
import entity.Coin;
import entity.Player;
import logic.GameController;
import logic.Sprites;
import test.base.GameTest;

class CoinTest extends GameTest {

	Coin test;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		test = new Coin();
		
	}
	
	@Test
	void testGetSymbol() {
		assertEquals(Sprites.COIN,test.getSymbol());
	}
	
	@Test
	void testInteract_Player() {
		//Player can collect coin
		assertEquals(true,test.interact(new Player()));
		//Coin Count has to be increased
		assertEquals(1,GameController.getCoinCount());
	}
	
	@Test
	void testInteract_Box() {
		//Box can collect coin
		assertEquals(true,test.interact(new Box()));
		//Coin Count has to be increased
		assertEquals(1,GameController.getCoinCount());
	}
}
