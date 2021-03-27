package test.student;

import application.shop.actions.RemoveCard;
import card.base.Card;
import deck.Deck;
import deck.InsertCardFailedException;

public class TestCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card card1 = new Card("AntMan", "SuperHero");
		Card card2 = new Card("AntMan", "SuperHero");
		Card card3 = new Card("AntMan", "SuperHero");
		Card card4 = new Card("AntMan", "SuperHero");
		Card card5 = new Card("AntBoy", "KidsHero");
		Card[] deckList = { card1, card2, card3, card4 };
		Deck deck = new Deck("my_deck", deckList);
		try {
			deck.insertCard(card5);
			Card[] cards = deck.getDeckList();
			for (Card card : cards) {
				System.out.println(card.getName());
			}
		} catch (InsertCardFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Card remove = deck.removeCard(3);
		System.out.println("removed card : " + remove.getName());
		Card[] cards = deck.getDeckList();
		for (Card card : cards) {
			System.out.println(card.getName());
		}

		/*
		 * if ( card1.equals(card2)==true) { System.out.println(" OK "); }else {
		 * System.out.println(" Re Implement function please!! "); }
		 */

	}

}
