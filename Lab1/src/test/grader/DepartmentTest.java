package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import logic.*;

public class DepartmentTest {
	static Department deptA = new Department("Melee");
	static Department deptB = new Department("Ranged");
	static Department deptC = new Department("Magic");
	static GuildMember a = new GuildMember("Arturia", "Saber", 50);
	static GuildMember b = new GuildMember("Bathory", "Lancer", 40);
	static GuildMember c = new GuildMember("Chulainn", "Lancer" ,40);
	static GuildMember d = new GuildMember("Astolfo", "Rider", 45);
	static GuildMember e = new GuildMember("Emiya", "Archer", 50);
	static GuildMember f  = new GuildMember("Tamamo", "Caster", 40);
	static GuildMember g = new GuildMember("Nursery Rhymes", "Caster", 50);
	static GuildMember h = new GuildMember("Kyrielight", "Shielder", 50);
	static GuildMember i = new GuildMember("MHX", "Assassin", 50);
	static GuildMember j = new GuildMember("Jeanne", "Ruler", 50);
	
	@BeforeEach
	void setUp(){
		deptA.clearDepartment();
		deptB.clearDepartment();
		deptC.clearDepartment();
	}
	
	@Test
	void setNameTest() {
		Department deptD = new Department("Support");
		assertEquals("Support", deptD.getName());
		
		boolean nameChange = deptD.setName("Healer");
		assertEquals("Healer", deptD.getName());
		assertTrue(nameChange);
		
		nameChange = deptD.setName("");
		assertEquals("Healer", deptD.getName());
		assertFalse(nameChange);
	}
	
	@Test
	void addMemberTest(){
		deptA.addMember(a);
		assertEquals(1, deptA.memberCount());
		assertEquals(a, deptA.getMember(0));
		assertEquals("Melee", a.getMyDepartment());
		
		deptA.addMember(b);
		assertEquals(2, deptA.memberCount());
		assertEquals(b, deptA.getMember(1));
		assertEquals("Melee", b.getMyDepartment());
		
		deptB.addMember(e);
		assertEquals(2, deptA.memberCount());
		assertEquals(1, deptB.memberCount());
		assertEquals(e, deptB.getMember(0));
		assertEquals("Ranged", e.getMyDepartment());
		
		deptC.addMember(f);
		assertEquals(2, deptA.memberCount());
		assertEquals(1, deptB.memberCount());
		assertEquals(1, deptC.memberCount());
		assertEquals(f, deptC.getMember(0));
		assertEquals("Magic", f.getMyDepartment());
		
		deptA.addMember(c);
		deptA.addMember(d);
		assertEquals(4, deptA.memberCount());
		assertEquals(c, deptA.getMember(2));
		assertEquals(d, deptA.getMember(3));
		assertEquals("Melee", c.getMyDepartment());
		assertEquals("Melee", d.getMyDepartment());
		
		deptC.addMember(g);
		assertEquals(2, deptC.memberCount());
		assertEquals(g, deptC.getMember(1));
		assertEquals("Magic", g.getMyDepartment());
	}
	
	@Test
	void removeMemberTest() {
		deptA.addMember(a);
		deptA.addMember(b);
		deptA.addMember(c);
		deptA.addMember(d);
		deptB.addMember(e);
		
		deptA.removeMember(0);
		assertEquals(3, deptA.memberCount());
		assertEquals(b, deptA.getMember(0));
		
		deptB.removeMember(0);
		assertEquals(0, deptB.memberCount());
	}
	
	@Test
	void addMultipleMembersTest() {
		deptA.addMember(a);
		deptA.addMember(b);
		deptA.addMember(c);
		deptA.addMember(d);
		
		ArrayList<GuildMember> newArrivals = new ArrayList<GuildMember>();
		newArrivals.add(h);
		newArrivals.add(i);
		newArrivals.add(j);
		
		deptA.addMultipleMembers(newArrivals);
		assertEquals(7, deptA.memberCount());
		assertEquals(h, deptA.getMember(4));
		assertEquals(i, deptA.getMember(5));
		assertEquals(j, deptA.getMember(6));
	}
	
	@Test
	void getAllMembersTest() {
		deptA.addMember(a);
		deptA.addMember(b);
		deptA.addMember(c);
		deptA.addMember(d);
		deptA.addMember(h);
		deptA.addMember(i);
		deptA.addMember(j);
		
		ArrayList<GuildMember> allMelee = deptA.getAllMembers();
		assertEquals(a, allMelee.get(0));
		assertEquals(b, allMelee.get(1));
		assertEquals(c, allMelee.get(2));
		assertEquals(d, allMelee.get(3));
		assertEquals(h, allMelee.get(4));
		assertEquals(i, allMelee.get(5));
		assertEquals(j, allMelee.get(6));
	}
	
}
