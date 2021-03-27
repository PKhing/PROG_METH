package application.shop.actions;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import application.shop.actions.forge.ForgeBasicCharacterCard;
import application.shop.actions.forge.ForgeBasicItemCard;
import application.shop.actions.forge.ForgeExodiaPartCard;
import application.shop.actions.forge.ForgeMainCharacterCard;
import card.base.Card;
import card.cards.*;
import deck.Deck;
import deck.InsertCardFailedException;
import deck.PremadeDeck;
import player.Player;

public class ChangeToPremadeDeck extends ShopApp {
	private Player player;

	public ChangeToPremadeDeck(PrintStream out, Scanner in, Player player) {
		super(out, in);
		out.println("Select Premade Deck");
		this.player = player;
	}

	public void run() {
		int choice;
		out.println("Select deck: ");
		choice = this.getChoice(1, PremadeDeck.premadeDecks.length, () -> this.prompt(),
				index -> PremadeDeck.premadeDecks[index - 1].getName());
		player.setDeck(PremadeDeck.premadeDecks[choice - 1]);
		out.println(player.getName() + " change his deck to " + player.getDeck().getName() + " premade deck");
	}

	public void prompt() {
		out.println("Select premade deck");
		int index = 1;
		for (Deck deck : PremadeDeck.premadeDecks) {
			out.println(index + ": " + deck.toString());
			index += 1;
		}
	}
}