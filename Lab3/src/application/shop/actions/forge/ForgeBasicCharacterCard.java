package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import card.cards.BasicCharacterCard;

public class ForgeBasicCharacterCard extends ShopApp {

	public ForgeBasicCharacterCard(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging Basic Character Card");
	}

	public BasicCharacterCard runForge() {
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
		out.print("Basic Character Card : ");
		return new BasicCharacterCard(name, description, hp, attack, defense);
	}

}
