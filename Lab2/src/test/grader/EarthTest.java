package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solar.Earth;

class EarthTest {

	@Test
	void testConstructor1() {
		Earth earth = new Earth();
		assertEquals(1, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(1, earth.getOrbitRadius());
		assertEquals(0, earth.getWasteLevel());
	}
	
	@Test
	void testConstructor2() {
		Earth earth = new Earth(5,1);
		assertEquals(5, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(5, earth.getOrbitRadius());
		assertEquals(1, earth.getWasteLevel());
		
		earth = new Earth(0, 1);
		assertEquals(1, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(1, earth.getOrbitRadius());
		assertEquals(1, earth.getWasteLevel());
		
		earth = new Earth(-5, 1);
		assertEquals(1, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(1, earth.getOrbitRadius());
		assertEquals(1, earth.getWasteLevel());
		
		earth = new Earth(1, -5);
		assertEquals(1, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(1, earth.getOrbitRadius());
		assertEquals(0, earth.getWasteLevel());
		
		earth = new Earth(0, -5);
		assertEquals(1, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(1, earth.getOrbitRadius());
		assertEquals(0, earth.getWasteLevel());
		
		earth = new Earth(5, 5);
		assertEquals(5, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		assertEquals(0, earth.getOrbitCenterCoordinate().getX());
		assertEquals(0, earth.getOrbitCenterCoordinate().getY());
		assertEquals(5, earth.getOrbitRadius());
		assertEquals(5, earth.getWasteLevel());
	}
	
	@Test
	void testgetWasteLevel() {
		Earth earth = new Earth();
		assertEquals(0, earth.getWasteLevel());
		
		earth = new Earth(2, 5);
		assertEquals(5, earth.getWasteLevel());
		
		earth = new Earth(2, -5);
		assertEquals(0, earth.getWasteLevel());
	}
	
	@Test
	void testOrbit() {
		
		Earth earth = new Earth();
		assertEquals(1, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(0, earth.getCoordinate().getX());
		assertEquals(-1, earth.getCoordinate().getY());
		
		earth = new Earth(5,1);
		assertEquals(5, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(0, earth.getCoordinate().getX());
		assertEquals(-5, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(-5, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(0, earth.getCoordinate().getX());
		assertEquals(5, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(5, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		earth = new Earth(10,2);
		assertEquals(10, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(0, earth.getCoordinate().getX());
		assertEquals(-10, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(-10, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		earth = new Earth(20,5);
		assertEquals(20, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(0, earth.getCoordinate().getX());
		assertEquals(-20, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(-20, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(0, earth.getCoordinate().getX());
		assertEquals(20, earth.getCoordinate().getY());
		
		assertTrue(earth.orbit());
		assertEquals(20, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		earth = new Earth(30,10);
		assertEquals(30, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
		
		assertFalse(earth.orbit());
		assertEquals(30, earth.getCoordinate().getX());
		assertEquals(0, earth.getCoordinate().getY());
	}

}
