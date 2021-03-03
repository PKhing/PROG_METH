package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solar.Saturn;

class SaturnTest {

	@Test
	void testConstructor1() {
		Saturn saturn = new Saturn();
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(1, saturn.getOrbitRadius());
		assertEquals(0, saturn.getSpeed());
	}
	
	@Test
	void testConstructor2() {
		Saturn saturn = new Saturn(5,1);
		assertEquals(5, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(5, saturn.getOrbitRadius());
		assertEquals(1, saturn.getSpeed());
		
		saturn = new Saturn(0, 1);
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(1, saturn.getOrbitRadius());
		assertEquals(1, saturn.getSpeed());
		
		saturn = new Saturn(-5, 1);
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(1, saturn.getOrbitRadius());
		assertEquals(1, saturn.getSpeed());
		
		saturn = new Saturn(1, -5);
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(1, saturn.getOrbitRadius());
		assertEquals(0, saturn.getSpeed());
		
		saturn = new Saturn(0, -5);
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(1, saturn.getOrbitRadius());
		assertEquals(0, saturn.getSpeed());
		
		saturn = new Saturn(5, 5);
		assertEquals(5, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getX());
		assertEquals(0, saturn.getOrbitCenterCoordinate().getY());
		assertEquals(5, saturn.getOrbitRadius());
		assertEquals(5, saturn.getSpeed());
	}
	
	@Test
	void testGetSpeed() {
		Saturn saturn = new Saturn();
		assertEquals(0, saturn.getSpeed());
		
		saturn = new Saturn(2, 5);
		assertEquals(5, saturn.getSpeed());
		
		saturn = new Saturn(2, -5);
		assertEquals(0, saturn.getSpeed());
	}
	
	@Test
	void testOrbit() {
		
		Saturn saturn = new Saturn();
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertFalse(saturn.orbit());
		assertEquals(1, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		saturn = new Saturn(5,1);
		assertEquals(5, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(0, saturn.getCoordinate().getX());
		assertEquals(-5, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(-5, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(0, saturn.getCoordinate().getX());
		assertEquals(5, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(5, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		saturn = new Saturn(10,2);
		assertEquals(10, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(-10, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(10, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		saturn = new Saturn(20,3);
		assertEquals(20, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(0, saturn.getCoordinate().getX());
		assertEquals(20, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(-20, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(0, saturn.getCoordinate().getX());
		assertEquals(-20, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(20, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		saturn = new Saturn(30,4);
		assertEquals(30, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
		
		assertTrue(saturn.orbit());
		assertEquals(30, saturn.getCoordinate().getX());
		assertEquals(0, saturn.getCoordinate().getY());
	}

}
