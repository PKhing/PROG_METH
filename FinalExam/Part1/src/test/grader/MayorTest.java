package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import role.base.DayActable;
import role.derived.Detective;
import role.derived.Mafia;
import role.derived.Mayor;

class MayorTest {
	
	Detective d;
	
	Mayor my;
	
	Mafia mf;
	
	@BeforeEach
	void setUp() throws Exception {
		d = new Detective("Holmes");
		my = new Mayor("Pruyat");
		mf = new Mafia("Tsunayoshi");
	}

	@Test
	void testConstructor() {
		assertEquals("Pruyat", my.getPlayerName());
		assertEquals(0, my.getVotedScore());
		assertTrue(my.isVotable()); 
	}

	@Test
	void testDayAction() {
		DayActable dayTest = my;
		
		dayTest.dayAction(d);
		assertEquals(false, d.isVotable());
		
		dayTest.dayAction(mf);
		assertEquals(false, mf.isVotable());
	}
	
	
}
