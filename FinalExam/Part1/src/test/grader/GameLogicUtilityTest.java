package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameLogic;
import role.base.Player;

class GameLogicUtilityTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final ByteArrayOutputStream outputStreamCaptor2 = new ByteArrayOutputStream();
	
	private ArrayList<Player> targetPlayer;
	
	@BeforeEach
	void setUp() throws Exception {
		GameLogic.getInstance().initializeGame();
		GameLogic.getInstance().getPlayerList().remove(1);
		GameLogic.getInstance().getPlayerList().remove(1);
		GameLogic.getInstance().getPlayerList().remove(1);
		GameLogic.getInstance().getPlayerList().remove(1);
		GameLogic.getInstance().getPlayerList().remove(1);
		
		targetPlayer = new ArrayList<Player>();
		targetPlayer.add(GameLogic.getInstance().getPlayerList().get(1));
		targetPlayer.add(GameLogic.getInstance().getPlayerList().get(1));
		targetPlayer.add(GameLogic.getInstance().getPlayerList().get(1));
		
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void testDoDayAction() {
		GameLogic.getInstance().doDayAction(targetPlayer);
		assertEquals(false, GameLogic.getInstance().getPlayerList().get(1).isVotable());
		
		assertEquals("Naegi is not the Mayor", outputStreamCaptor.toString().trim());
	    System.setOut(standardOut);
	}
	
	@Test
	void testDoNightAction() {
		GameLogic.getInstance().doNightAction(targetPlayer);
		
		assertEquals(2,GameLogic.getInstance().getPlayerList().size());
		String expected = "Naegi is not the Mafia boss\nNaegi will be a dead body when day comes".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		assertEquals(expected, outputStreamCaptor.toString().trim());
		
	}

}
