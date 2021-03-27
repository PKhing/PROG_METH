package application;

import java.io.PrintStream;
import java.util.Scanner;

import player.Player;
import deck.Deck;
import deck.PremadeDeck;

public class PlayerSelection extends ShopApp {
	public PlayerSelection(PrintStream out, Scanner in) {
		super(out, in);
	}

	Player[] players = { new Player("Yugi Muto", 300, 55, 10), new Player("Sendou Aichi", 400, 35, 15),
			new Player("Joe Kirifuda", 500, 45, 5) };

	public Player runPlayerSelection() {
		int choice;
		out.println("Select player: ");
		choice = this.getChoice(1, this.players.length, () -> this.printPlayers(),
				index -> this.players[index - 1].getName());

		return players[choice - 1];
	}

	public Deck runDeckSelection() {
		int choice;
		out.println("Select starting Deck: ");
		choice = this.getChoice(1, PremadeDeck.premadeDecks.length, () -> this.printDecks(),
				index -> PremadeDeck.premadeDecks[index - 1].getName());

		return PremadeDeck.premadeDecks[choice - 1];
	}

	private void printPlayers() {
		int index = 1;
		for (Player player : players) {
			out.println(index + ": " + player.toString());
			index += 1;
		}
	}

	private void printDecks() {
		int index = 1;
		for (Deck deck : PremadeDeck.premadeDecks) {
			out.println(index + ": " + deck.toString());
			index += 1;
		}
	}
}