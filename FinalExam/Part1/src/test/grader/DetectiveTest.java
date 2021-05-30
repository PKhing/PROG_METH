package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import role.base.NightActable;
import role.derived.Detective;
import role.derived.Mafia;
import role.derived.Mayor;

import role.base.*;

class DetectiveTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final ByteArrayOutputStream outputStreamCaptor2 = new ByteArrayOutputStream();
	
	Detective d1;
	Detective d2;
	
	Mayor my;
	
	Mafia mf;
	
	@BeforeEach
	void setUp() throws Exception {
		d1 = new Detective("Holmes");
		d2 = new Detective("Poirot");
		my = new Mayor("Pruyat");
		mf = new Mafia("Tsunayoshi");
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void testConstructor() {
		assertEquals(d1.getPlayerName(), "Holmes");
		assertEquals(0, d1.getVotedScore());
		assertTrue(d1.isVotable()); 
		
		assertEquals(d2.getPlayerName(), "Poirot");
		assertEquals(0, d2.getVotedScore());
		assertTrue(d2.isVotable());
	}

	@Test
	void testDayActionMayor() {
		DayActable dayTest = d1;
		
		dayTest.dayAction(my);
		assertEquals("Pruyat is the Mayor", outputStreamCaptor.toString().trim());
	    System.setOut(standardOut);
	}
	
	@Test
	void testDayActionNonMayor() {
		DayActable dayTest = d1;
		
		dayTest.dayAction(mf);
		assertEquals("Tsunayoshi is not the Mayor", outputStreamCaptor.toString().trim());
	    System.setOut(standardOut);
		
	    System.setOut(new PrintStream(outputStreamCaptor2));
	    dayTest.dayAction(d2);
		assertEquals("Poirot is not the Mayor", outputStreamCaptor2.toString().trim());
	    System.setOut(standardOut);
	}
	
	@Test
	void testNightActionNonMafia() {
		NightActable nightTest = (NightActable) d1;
		
		nightTest.nightAction(my);
	    assertEquals("Pruyat is not the Mafia boss", outputStreamCaptor.toString().trim());
	    System.setOut(standardOut);
	    
	    System.setOut(new PrintStream(outputStreamCaptor2));
	    nightTest.nightAction(d2);
	    assertEquals("Poirot is not the Mafia boss", outputStreamCaptor2.toString().trim());
	    System.setOut(standardOut);
	    
	}
	
	@Test
	void testNightActionMafia() {
		NightActable nightTest = (NightActable) d1;
		nightTest.nightAction(mf);
	    assertEquals("Tsunayoshi is the Mafia boss", outputStreamCaptor.toString().trim());
	    System.setOut(standardOut);
	
	}
	
}
