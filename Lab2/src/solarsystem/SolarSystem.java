package solarsystem;

import java.util.List;
import java.util.Scanner;

import solar.Earth;
import solar.Planet;
import solar.Saturn;

import java.util.ArrayList;

public class SolarSystem {

	// fill code //
	public static ArrayList<Planet> planets = new ArrayList<Planet>();
	public static final int X_RANGE = 2;
	public static final int Y_RANGE = 2;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to The Virtual Solar System");
		System.out.println("----------------");
		while (true) {
			System.out.print(
					"Available Command:\n" + "V - View the current position of every planet in this Solar System\n"
							+ "E - Add Earth to the Solar System\n" + "S - Add Saturn to the Solar System\n"
							+ "O - Orbit every planet in this Solar System\n" + "Q - Quit from this Solar System\n");
			System.out.println("----------------");
			System.out.print("Input Command : ");
			String command = kb.next();
			System.out.println("----------------");
			switch (command) {
			case "E":
				addPlanet(new Earth());
				System.out.println("----------------");
				break;
			case "S":
				if (!doesPlanetExist(new Saturn())) {
					System.out.print("Input Speed : ");
					int speed = kb.nextInt();
					addPlanet(new Saturn(2, speed));
				}
				System.out.println("----------------");
				break;
			case "O":
				for (Planet p : planets)
					p.orbit();
				printMap();
				System.out.println("----------------");
				break;
			case "V":
				printMap();
				System.out.println("----------------");
				break;
			case "Q":
				System.out.println("Have fun in other galaxies !");
				System.out.println("----------------");
				kb.close();
				System.exit(0);
				break;
			default:
				System.out.println("Unexpected Command !");
				System.out.println("----------------");
				break;
			}
		}
	}

	// fill code //
	public static void addPlanet(Planet planet) {
		if (doesPlanetExist(planet)) {
			return;
		} else {
			planets.add(planet);
			printMap();
		}
	}

	public static boolean doesPlanetExist(Planet planet) {
		for (Planet i : planets) {
			if (i.getClass() == planet.getClass()) {
				System.out.println(planet.getClass().toString().split(" ")[1] + " exists !!!");
				return true;
			}
		}
		return false;
	}

	public static void printMap() {
		for (int i = Y_RANGE * 2; i >= -Y_RANGE * 2; i--) {
			for (int j = -X_RANGE; j <= X_RANGE; j++) {

				// Print Center
				if (j == 0 && i == 0) {
					System.out.print("x-");
					continue;
				}
				boolean found = false;

				// Print Planet by first character
				for (Planet planet : planets) {
					if (j == planet.getCoordinate().getX() && i == planet.getCoordinate().getY() * 2) {
						String name = planet.getClass().toString().split("\\.")[1].substring(0, 1);
						System.out.print(j < X_RANGE ? name + "-" : name);
						found = true;
						break;
					}
				}

				// If no planet found, print other information
				if (!found) {
					if (Math.abs(i % 2) == 0) {
						System.out.print(j < X_RANGE ? "O-" : "O");
					} else {
						System.out.print("| ");
					}
				}
			}
			System.out.println();
		}
	}
}