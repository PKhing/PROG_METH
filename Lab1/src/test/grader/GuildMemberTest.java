package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import logic.*;

public class GuildMemberTest {
	
	@Test
	void constructorsTest() {
		GuildMember ness = new GuildMember("Ness", "Psychic", 50);
		
		assertEquals("Ness", ness.getName());
		assertEquals("Psychic", ness.getJobTitle());
		assertEquals(50, ness.getSalary());
		assertEquals("Unassigned", ness.getMyDepartment());
		
		GuildMember anon = new GuildMember("", "", -600);
		
		assertEquals("Anon", anon.getName());
		assertEquals("Adventurer", anon.getJobTitle());
		assertEquals(0, anon.getSalary());
		assertEquals("Unassigned", anon.getMyDepartment());
	}
	
	@Test
	void setNameTest() {
		GuildMember wright = new GuildMember("Naruhodou Ryuuichi", "Defense Attorney", 70);
		wright.setName("Phoenix Wright");
		
		assertEquals("Phoenix Wright", wright.getName());
		
		wright.setName("");
		
		assertEquals("Anon", wright.getName());
	}
	
	@Test
	void setJobTitleTest() {
		GuildMember mario = new GuildMember("Super Mario", "Plumber", 60);
		mario.setJobTitle("Doctor");
		
		assertEquals("Doctor", mario.getJobTitle());
		
		mario.setJobTitle("");
		
		assertEquals("Adventurer", mario.getJobTitle());
	}
	
	@Test
	void setSalaryTest() {
		GuildMember kiryu = new GuildMember("Kazuma Kiryu", "Dragon", 1000);
		kiryu.setSalary(15000);
		
		assertEquals(15000, kiryu.getSalary());
		
		kiryu.setSalary(-3000);
		
		assertEquals(0, kiryu.getSalary());
		
		kiryu.setSalary(666666666);
		
		assertEquals(100000, kiryu.getSalary());
	}
	
	@Test
	void setDepartmentTest() {
		GuildMember blyeth = new GuildMember("Blyeth", "Professor", 500);
		assertEquals("Unassigned", blyeth.getMyDepartment());
		
		blyeth.setMyDepartment("Black Eagles");
		assertEquals("Black Eagles", blyeth.getMyDepartment());
		
		blyeth.setMyDepartment("Blue Lions");
		assertEquals("Blue Lions", blyeth.getMyDepartment());
		
		blyeth.setMyDepartment("Golden Deer");
		assertEquals("Golden Deer", blyeth.getMyDepartment());
	}
}
