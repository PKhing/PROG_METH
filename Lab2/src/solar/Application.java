package solar;

import java.util.ArrayList;

public class Application {
	private static ArrayList<Planet> planets = new ArrayList<Planet>();

	public static String printPlanet(Planet planet) {
		if (planet instanceof Saturn) {
			return "Saturn's Speed is " + ((Saturn) planet).getSpeed();
		}
		if (planet instanceof Earth) {

			return "Earth's Waste Level is " + ((Earth) planet).getWasteLevel();
		}
		return "";
	}

	public static void main(String args[]) {
		Earth earth = new Earth(1, 4);
		Saturn saturn = new Saturn(2, 2);
		planets.add(earth);
		planets.add(saturn);
		for (Planet planet : planets) {
			System.out.println(printPlanet(planet));
		}
	}
}
