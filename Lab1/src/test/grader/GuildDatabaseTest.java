package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import logic.*;

public class GuildDatabaseTest {
	static GuildDatabase myDatabase;
	
	@BeforeEach
	void setUp() {
		myDatabase = new GuildDatabase(); 
		myDatabase.createDepartment("Actors");
		myDatabase.createDepartment("Idols");
		myDatabase.createDepartment("Musicians");
	}
	
	@Test
	void createDepartmentTest() {
		boolean createSuccess = myDatabase.createDepartment("DJs");
		assertEquals(4, myDatabase.departmentCount());
		assertEquals("DJs", myDatabase.getDepartment(3).getName());
		assertTrue(createSuccess);
		
		createSuccess = myDatabase.createDepartment("Idols");
		assertEquals(4, myDatabase.departmentCount());
		assertFalse(createSuccess);
	}
	
	@Test
	void removeDepartmentTest() {
		myDatabase.createDepartment("Otonokizaka");
		
		GuildMember honk = new GuildMember("Kousaka", "Group Leader", 500);
		GuildMember salt = new GuildMember("Sonoda", "Archer", 400);
		GuildMember birb = new GuildMember("Minami", "Legendary Maid", 400);
		
		myDatabase.getDepartment(3).addMember(honk);
		myDatabase.getDepartment(3).addMember(salt);
		myDatabase.getDepartment(3).addMember(birb);
		
		ArrayList<GuildMember> removed = myDatabase.removeDepartment(3);
		assertEquals(3, myDatabase.departmentCount());
		assertEquals(honk, removed.get(0));
		assertEquals(salt, removed.get(1));
		assertEquals(birb, removed.get(2));
	}
}
