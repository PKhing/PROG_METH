package application;

import java.util.Scanner;

import application.shop.Shop;
import player.Player;
import deck.Deck;
import card.base.*;
import card.cards.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	private static void printLineSeparator() {
		System.out.println("==================================================");
	}

	private static void printDeckList(Deck deck) {
		int cardsNumber = 0;
		for (Card card : deck.getDeckList()) {
			if (card != null) {
				cardsNumber += 1;
			}
		}
		System.out.println("Deck count (" + cardsNumber + "/" + deck.getDeckSize() + ")");
		int index = 1;
		for (Card card : deck.getDeckList()) {
			if (card != null) {
				System.out.println(index + ": " + card.toString());
				index += 1;
			}
		}
	}

	public static void main(String[] args) {
		printLineSeparator();
		System.out.println("============ YugiUno: Card Shop =========");
		printLineSeparator();

		Player player = new PlayerSelection(System.out, scanner).runPlayerSelection();

		System.out.println("Selected " + player.getName());
		Deck deck = new PlayerSelection(System.out, scanner).runDeckSelection();
		player.setDeck(deck);
		System.out.println("Selected " + deck.getName());
		printLineSeparator();

		System.out.println("Entering card shop");
		new Shop(System.out, scanner, player).run();

		printLineSeparator();
		/*
		 * System.out.println("Final stats: "); System.out.println(player.toString());
		 * printDeckList(player.getDeck()); printLineSeparator();
		 * 
		 * System.out.println(player.getName() +
		 * " : It's time to DueDue Due Due DDDDDDDDDDD DUEL!!");
		 */
	}
}
