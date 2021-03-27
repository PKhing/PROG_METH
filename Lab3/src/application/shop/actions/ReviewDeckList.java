package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.ShopApp;
import card.base.Card;
import deck.RemoveCardFailedException;
import player.Player;

public class ReviewDeckList extends ShopApp {

	private Player player;
	private List<Card> cards;

	public ReviewDeckList(PrintStream out, Scanner in, Player player, List<Card> cards) {
		super(out, in);
		this.player = player;
		this.cards = cards;
	}

	public void run() {
		out.println("Deck List");

		int index = 1;
		for (Card card : player.getDeck().getDeckList()) {
			if (card != null) {
				out.println(index + ": " + card.toString());
			}
			index += 1;
		}
	}

}