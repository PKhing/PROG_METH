package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.ShopApp;

import deck.InsertCardFailedException;
import player.Player;
import card.base.*;
import card.cards.*;

public class InsertCard extends ShopApp {
	private Player player;
	private List<Card> cards;

	public InsertCard(PrintStream out, Scanner in, Player player, List<Card> cards) {
		super(out, in);
		this.player = player;
		this.cards = cards;
	}

	public void run() {
		Card card = getCardChoice(this.cards, () -> this.prompt());
		try {
			int slot = player.getDeck().insertCard(card);
			out.println(
					"Insert " + card.getName() + " to slot " + slot + " of " + player.getDeck().getName() + " deck");
		} catch (InsertCardFailedException e) {
			out.println("Insert card failed, " + e.message);
		}
	}

	public void prompt() {
		out.println("Select card");
		int index = 1;
		for (Card card : cards) {
			out.println(index + ": " + card.toString());
			index += 1;
		}
	}
}