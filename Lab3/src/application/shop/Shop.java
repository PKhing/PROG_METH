package application.shop;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import application.shop.actions.PlayTest;
import application.shop.actions.ForgeCard;
import application.shop.actions.InsertCard;
import application.shop.actions.RemoveCard;
import application.shop.actions.ReviewDeckList;
import application.shop.actions.ChangeToPremadeDeck;
import deck.PremadeDeck;

import card.base.Card;

import player.Player;

public class Shop extends ShopApp {
	Player player;
	List<Card> cards;

	public Shop(PrintStream out, Scanner in, Player player) {
		super(out, in);
		this.player = player;
		this.cards = PremadeDeck.initialCardStock;
	}

	public void run() {
		while (true) {
			int choice = this.getChoice(1, 6, false, () -> this.prompt());
			switch (choice) {
			case 1:
				Card toAdd = new ForgeCard(this.out, this.in).runForge();
				if (toAdd != null) {
					cards.add(toAdd);
				}
				break;
			case 2:
				new InsertCard(this.out, this.in, this.player, this.cards).run();
				out.println("Insert Card Done");
				break;
			case 3:
				new RemoveCard(this.out, this.in, this.player, this.cards).run();
				out.println("Remove Card Done");
				break;
			case 4:
				new ReviewDeckList(this.out, this.in, this.player, this.cards).run();
				break;
			case 5:
				new ChangeToPremadeDeck(this.out, this.in, this.player).run();

				break;
			case 6:
				new PlayTest(this.out, this.in, this.player).run();
				return;
			}
		}
	}

	public void prompt() {
		out.println("Select action :");
		out.println("1: Create new Card");
		out.println("2: Insert card to " + player.getDeck().getName() + " deck");
		out.println("3: Remove card from " + player.getDeck().getName() + " deck");
		out.println("4: Review Deck list");
		out.println("5: Change to premade deck");
		out.println("6: Begin the game");
	}
}
