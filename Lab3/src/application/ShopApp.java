package application;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.base.CLIApp;
import card.base.Card;
import deck.Deck;

public class ShopApp extends CLIApp {
	public ShopApp(PrintStream out, Scanner in) {
		super(out, in);
	}

	public Card getCardChoice(List<Card> cards, Runnable prompt) {
		int choice = getChoice(1, cards.size(), prompt);
		return cards.get(choice - 1);
	}

	public Card getCardChoice(Card[] cards, Runnable prompt) {
		int choice = getChoice(1, cards.length, prompt);
		return cards[choice - 1];
	}

	public Deck getDeckChoice(List<Deck> decks, Runnable prompt) {
		int choice = getChoice(1, decks.size(), prompt);
		return decks.get(choice - 1);
	}
}
