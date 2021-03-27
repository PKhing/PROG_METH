package application.shop.actions;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import application.shop.actions.forge.*;

import card.base.*;

public class ForgeCard extends ShopApp {

	public ForgeCard(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging new card");
	}

	public Card runForge() {
		int choice = this.getChoice(1, 7, false, () -> this.promptItemType());
		switch (choice) {
		case 1:
			return new ForgeBasicCharacterCard(this.out, this.in).runForge();
		case 2:
			return new ForgeMainCharacterCard(this.out, this.in).runForge();
		case 3:
			return new ForgeBasicItemCard(this.out, this.in).runForge();
		case 4:
			return new ForgeExodiaPartCard(this.out, this.in).runForge();
		case 5:
			return null;
		}
		return null;
	}

	public void promptItemType() {
		out.println("Select action :");
		out.println("1: Basic Character Card");
		out.println("2: Main Character Card");
		out.println("3: Basic Item Card");
		out.println("4: Exodia Part Card");
		out.println("5: Cancel");
	}
}
