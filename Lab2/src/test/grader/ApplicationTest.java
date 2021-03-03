package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solar.Application;
import solar.Earth;
import solar.Planet;
import solar.Saturn;

class ApplicationTest {

	@Test
	void testPrintEarth() {
		Planet planet = new Earth(1, 3);
		assertEquals("Earth's Waste Level is 3", Application.printPlanet(planet)); 
		
		planet = new Earth(1, 20);
		assertEquals("Earth's Waste Level is 20", Application.printPlanet(planet)); 
		
		planet = new Earth(1, 0);
		assertEquals("Earth's Waste Level is 0", Application.printPlanet(planet));
		
		planet = new Earth(1, -1);
		assertEquals("Earth's Waste Level is 0", Application.printPlanet(planet)); 
		
		planet = new Earth(1, -10);
		assertEquals("Earth's Waste Level is 0", Application.printPlanet(planet)); 
	}
	
	@Test
	void testPrintSaturn() {
		Planet planet = new Saturn(1, 3);
		assertEquals("Saturn's Speed is 3", Application.printPlanet(planet)); 
		
		planet = new Saturn(1, 20);
		assertEquals("Saturn's Speed is 20", Application.printPlanet(planet)); 
		
		planet = new Saturn(1, 0);
		assertEquals("Saturn's Speed is 0", Application.printPlanet(planet));
		
		planet = new Saturn(1, -1);
		assertEquals("Saturn's Speed is 0", Application.printPlanet(planet));
		
		planet = new Saturn(1, -10);
		assertEquals("Saturn's Speed is 0", Application.printPlanet(planet));
	}
	
	@Test
	void testPrintOtherPlanet() {
		Planet planet = new Planet();
		assertEquals("", Application.printPlanet(planet)); 
		
		planet = new Planet(-1);
		assertEquals("", Application.printPlanet(planet)); 
		
		planet = new Planet(1);
		assertEquals("", Application.printPlanet(planet)); 
	}

}
