package application.shop.actions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import application.ShopApp;
import card.base.Card;
import card.base.CharacterCard;
import card.base.ItemCard;
import card.cards.ExodiaCharacterCard;
import card.cards.MainCharacterCard;
import deck.Deck;
import deck.InsertCardFailedException;
import deck.PremadeDeck;
import deck.RemoveCardFailedException;
import player.Player;

public class PlayTest extends ShopApp {

	Player[] opponentList = { new Player("Yugi Muto", 300, 55, 10), new Player("Sendou Aichi", 400, 35, 15),
			new Player("Joe Kirifuda", 500, 45, 5) };

	private Player player;
	private Player opponent;

	private List<Card> playerHand = new ArrayList<Card>();

	private boolean playerWincondition;

	public PlayTest(PrintStream out, Scanner in, Player player) {
		super(out, in);
		out.println("Begin Play Testing");
		this.player = player;
	}

	public void run() {
		int choice;
		// Choose opponent
		choice = this.getChoice(1, opponentList.length, () -> this.prompt_ChooseOppo(),
				index -> opponentList[index - 1].getName());
		opponent = opponentList[choice - 1];
		out.println(opponent.getName() + " is ready to fight! ");

		// ShuffleDeck
		player.setDeck(shuffleArray(player.getDeck()));

		// Gameplay
		// Start the game
		out.println("You draw five card");
		DrawCard(10);
		while (player.getCurrentLifePoint() > 0 && opponent.getCurrentLifePoint() > 0) {
			out.println("Your Move!!!");
			out.println("Draw!!!");
			DrawCard(1);
			printGameStatus();
			UseCard();

			if (player.getAssignedCharacter() instanceof ExodiaCharacterCard
					&& ((ExodiaCharacterCard) (player.getAssignedCharacter()))
							.winConditionCheck(player.getInventory())) {
				out.println(
						opponent.getName() + ": Draw your last pathetic card so I can end this, " + player.getName());
				out.println(player.getName() + ": My deck has no pathetic cards, " + opponent.getName()
						+ ". But it does contain, the unstoppable Exodia! ");
				out.println(opponent.getName() + ": Ahh! it's not possible! No one's ever been able to summon him!");
				out.println(player.getName() + ": Exodia Obliterate!!");
				out.println("YOU WIN!!!!!!!!");
				break;
			}
			Attack_Phase();
			if (opponent.getCurrentLifePoint() == 0) {
				out.println("YOU WIN!!!!!!!!");
				break;
			}
			Opponent_Phase();
			if (player.getCurrentLifePoint() == 0) {
				out.println("YOU LOSE!!!!!!!!");
				break;
			}
		}

	}

	void DrawCard(int count) {
		List<Card> newHand = playerHand;
		for (int i = 0; i < count; i++) {
			out.println(
					"You drew " + player.getDeck().getDeckList()[player.getDeck().getDeckList().length - 1] + "card");
			try {
				// out.println(player.getDeck().removeCard(player.getDeck().getDeckList().length-1));
				newHand.add(player.getDeck().removeCard(player.getDeck().getDeckList().length - 1));
			} catch (RemoveCardFailedException e) {
				out.println("Remove Card failed, " + e.message);
			}
			// newHand = Arrays.copyOf(newHand, newHand.size() +1);
			// newHand.get(newHand.size()-1) =
			// player.getDeck().getDeckList()[player.getDeck().getDeckSize()];

		}
		playerHand = newHand;

	}

	void UseCard() {
		// Card card = getCardChoice(playerHand, () -> this.prompt_ChooseHandCard());
		int choice = this.getChoice(1, playerHand.size(), () -> this.prompt_ChooseHandCard());

		Card card = playerHand.get(choice - 1);
		playerHand.remove(choice - 1);

		if (card instanceof MainCharacterCard
				&& card == (player.getAssignedCharacter() != null ? player.getAssignedCharacter() : null)) {
			int choiceC = this.getChoice(1, 3, () -> this.prompt_MainCharacterCardAction());
			if (choiceC == 1) {
				((CharacterCard) card).switchCharacter(player);
				player.setAssignedCharacter((CharacterCard) card);
				player.removeAllInventory();
				out.println("You switch your character to " + card.getName()
						+ ", All of previous character items are lost");
			} else if (choiceC == 2) {
				int heal = ((CharacterCard) card).sacrifice(player);
				out.println("You sacrifice " + card.getName() + " card, " + player.getName() + " gains " + heal
						+ " Life Point");
			} else if (choiceC == 3) {
				((MainCharacterCard) (player.getAssignedCharacter())).levelUp(player);
				out.println(player.getAssignedCharacter().getName() + " level up! All stats increased!");
			}
		} else if (card instanceof CharacterCard) {
			int choiceC = this.getChoice(1, 2, () -> this.prompt_CharacterCardAction());
			if (choiceC == 1) {
				((CharacterCard) card).switchCharacter(player);
				player.setAssignedCharacter((CharacterCard) card);
				player.removeAllInventory();
				out.println("You switch your character to " + card.getName()
						+ ", All of previous character items are lost");
			} else if (choiceC == 2) {
				int heal = ((CharacterCard) card).sacrifice(player);
				out.println("You sacrifice " + card.getName() + " card, " + player.getName() + " gains " + heal
						+ " Life Point");
			}
		} else if (card instanceof ItemCard) {
			((ItemCard) card).equipItem(player);
			out.println(player.getName() + " equip " + card.getName() + ", your character stat has been changed");
		}
	}

	public void prompt_ChooseOppo() {
		out.println("Select your opponent");
		int index = 1;
		for (Player opponent : opponentList) {
			out.println(index + ": " + opponent.toString());
			index += 1;
		}
	}

	public void prompt_ChooseHandCard() {
		out.println("Select your card to play");
		int index = 1;
		for (Card card : playerHand) {
			out.println(index + ": " + card.toString());
			index += 1;
		}
	}

	public void prompt_CharacterCardAction() {
		out.println("Select your action for character card");
		out.println("1) Switch to this Character");
		out.println("2) Sacrifice for current character lifepoint ");
	}

	public void prompt_MainCharacterCardAction() {
		out.println("Select your action for character card");
		out.println("1) Switch to this Character");
		out.println("2) Sacrifice for current character lifepoint ");
		out.println("3) Level up current character ");
	}

	static Deck shuffleArray(Deck deck) {

		Card[] ar = deck.getDeckList();
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Card a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
		Deck shuffle = new Deck(deck.getName(), ar);
		return shuffle;
	}

	void Attack_Phase() {
		dealDamage(player, opponent);
	}

	void Opponent_Phase() {
		out.println("Your Opponent Move!!!");
		dealDamage(opponent, player);
	}

	int dealDamage(Player attacker, Player defender) {
		out.println(attacker.getName() + " attacks " + defender.getName());
		int damage = attacker.getAttack() - defender.getDefense();
		damage = damage > 0 ? damage : 0;
		out.println(attacker.getName() + " deals " + damage + " damage to " + defender.getName());
		defender.setCurrentLifePoint(defender.getCurrentLifePoint() - damage);
		defender.setCurrentLifePoint(defender.getCurrentLifePoint() > 0 ? defender.getCurrentLifePoint() : 0);
		out.println(defender.getName() + " has " + defender.getCurrentLifePoint() + " Life Point left");
		return damage;
	}

	void printGameStatus() {
		out.println("====================Game Status=========================");
		out.println(player.toStringShortVer());
		out.println(opponent.toStringShortVer());
		out.println("========================================================");
	}

}