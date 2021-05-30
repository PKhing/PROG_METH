package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameLogic;
import role.base.NightActable;
import role.derived.Detective;
import role.derived.Mafia;
import role.derived.Mayor;

class MafiaTest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final ByteArrayOutputStream outputStreamCaptor2 = new ByteArrayOutputStream();

	Detective d;
	
	Mayor my;
	
	Mafia mf;
	
	@BeforeEach
	void setUp() throws Exception {
		d = new Detective("Holmes");
		my = new Mayor("Oberon");    		
		mf = new Mafia("Tsunayoshi");
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void testConstructor() {
		assertEquals("Tsunayoshi", mf.getPlayerName());   
		assertEquals(0, mf.getVotedScore());  
		assertTrue(mf.isVotable());           
		
	}
	
	@Test
	void testNightAction() {
		GameLogic gameLogic = GameLogic.getInstance();  
		gameLogic.getPlayerList().add(my);				
		gameLogic.getPlayerList().add(mf);             
		
		NightActable nightTest = mf;
		nightTest.nightAction(d);
		assertEquals("No one will be a dead body when day comes", outputStreamCaptor.toString().trim());
	    System.setOut(standardOut);
	    

		System.setOut(new PrintStream(outputStreamCaptor2));
	    nightTest.nightAction(my);
		assertEquals("Oberon will be a dead body when day comes", outputStreamCaptor2.toString().trim()); 
	    System.setOut(standardOut);
	    
	    assertEquals(9,GameLogic.getInstance().getPlayerList().size());
	}

}
