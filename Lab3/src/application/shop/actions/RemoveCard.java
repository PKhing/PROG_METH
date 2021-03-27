package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.ShopApp;

import deck.RemoveCardFailedException;
import player.Player;
import card.base.*;
import card.cards.*;

public class RemoveCard extends ShopApp {

	private Player player;
	private List<Card> cards;

	public RemoveCard(PrintStream out, Scanner in, Player player, List<Card> cards) {
		super(out, in);
		this.player = player;
		this.cards = cards;
	}

	public void run() {
		int choice = this.getChoice(1, player.getDeck().getDeckSize(), () -> this.prompt());
		try {
			cards.add(player.getDeck().removeCard(choice - 1));
		} catch (RemoveCardFailedException e) {
			out.println("Remove Card failed, " + e.message);
		}
	}

	public void prompt() {
		out.println("Select card to remove");

		int index = 1;
		for (Card card : player.getDeck().getDeckList()) {
			if (card != null) {
				out.println(index + ": " + card.toString());
			}
			index += 1;
		}
	}
}
