package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import card.cards.BasicItemCard;

public class ForgeBasicItemCard extends ShopApp {
	public ForgeBasicItemCard(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging Basic Item Card");
	}

	public BasicItemCard runForge() {
		in.nextLine();
		out.print("Input character name: ");
		String name = in.nextLine();

		out.print("Input character description: ");
		String description = in.nextLine();

		out.print("Input HP bonus: ");
		int hp = in.nextInt();

		out.print("Input attack bonus: ");
		int attack = in.nextInt();

		out.print("Input defense bonus: ");
		int defense = in.nextInt();

		return new BasicItemCard(name, description, hp, attack, defense);
	}

}