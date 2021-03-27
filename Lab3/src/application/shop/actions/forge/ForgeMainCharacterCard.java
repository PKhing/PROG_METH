package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import card.cards.MainCharacterCard;

public class ForgeMainCharacterCard extends ShopApp {
	public ForgeMainCharacterCard(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging Main Character Card");
	}

	public MainCharacterCard runForge() {
		in.nextLine();
		out.print("Input character name: ");
		String name = in.nextLine();

		out.print("Input character description: ");
		String description = in.nextLine();

		out.print("Input HP: ");
		int hp = in.nextInt();

		out.print("Input attack: ");
		int attack = in.nextInt();

		out.print("Input defense: ");
		int defense = in.nextInt();

		out.print("Input level up bonus: ");
		float levelUpBonus = in.nextFloat();

		return new MainCharacterCard(name, description, hp, attack, defense, levelUpBonus);
	}

}
