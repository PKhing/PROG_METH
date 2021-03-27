package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import card.cards.ExodiaPartCard;

public class ForgeExodiaPartCard extends ShopApp {
	public ForgeExodiaPartCard(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging Exodia Part Card");
	}

	public ExodiaPartCard runForge() {
		in.nextLine();
		out.print("Input exodia part name: ");
		String name = in.nextLine() + " of the Forbidden One";

		out.print("Input defense bonus: ");
		int defense = in.nextInt();

		return new ExodiaPartCard(name, defense);
	}

}