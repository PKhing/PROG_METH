package deck;

import java.util.ArrayList;
import java.util.List;

import card.base.Card;
import card.cards.BasicCharacterCard;
import card.cards.BasicItemCard;
import card.cards.MainCharacterCard;
import card.cards.ExodiaCharacterCard;
import card.cards.ExodiaPartCard;

public class PremadeDeck {

	static MainCharacterCard darkMagician = new MainCharacterCard("Dark Magician", "He's magic and stuff", 300, 70, 15,
			0.3f);
	static MainCharacterCard darkMagicianGirl = new MainCharacterCard("Dark Magician Girl", "She's magic and stuff",
			250, 85, 15, 0.4f);
	static MainCharacterCard blasterBlade = new MainCharacterCard("Blaster Blade", "He's sword and stuff", 600, 50, 18,
			0.35f);
	static MainCharacterCard alfred = new MainCharacterCard("Alfred", "He's king and stuff", 700, 40, 20, 0.25f);
	static MainCharacterCard drgOfDestiny = new MainCharacterCard("Dragon of Destiny", "He's dragon and stuff", 500, 80,
			0, 0.2f);
	static MainCharacterCard aquaSurfer = new MainCharacterCard("Aqua Surfer", "He's surf and stuff", 600, 40, 25,
			0.4f);

	static BasicCharacterCard mage = new BasicCharacterCard("Mage", "mage", 250, 70, 15);
	static BasicCharacterCard lightmage = new BasicCharacterCard("Light Mage", "light mage", 210, 80, 15);
	static BasicCharacterCard darkmage = new BasicCharacterCard("Dark Mage", "dark mage", 300, 60, 15);
	static BasicCharacterCard knight = new BasicCharacterCard("Knight", "knight", 600, 40, 18);
	static BasicCharacterCard warrior = new BasicCharacterCard("Warrior", "warrior", 700, 30, 18);
	static BasicCharacterCard swordsman = new BasicCharacterCard("Swordsman", "swordsman", 500, 50, 18);
	static BasicCharacterCard dragon = new BasicCharacterCard("Dragon", "dragon", 450, 65, 0);
	static BasicCharacterCard beast = new BasicCharacterCard("Beast", "beast", 550, 55, 0);
	static BasicCharacterCard monster = new BasicCharacterCard("Monster", "monster", 350, 70, 0);

	static BasicItemCard sword = new BasicItemCard("Sword", "sword", 0, 20, 0);
	static BasicItemCard longSword = new BasicItemCard("Long Sword", "long sword", 0, 30, -10);
	static BasicItemCard lightSword = new BasicItemCard("Light Sword", "light sword", 30, 10, 0);
	static BasicItemCard darkSword = new BasicItemCard("Dark Sword", "dark sword", -50, 35, 0);
	static BasicItemCard shield = new BasicItemCard("Shield", "shield", 0, 0, 15);
	static BasicItemCard largeShield = new BasicItemCard("Large Shield", "large shield", -50, 0, 25);
	static BasicItemCard lightShield = new BasicItemCard("Light Shield", "light shield", 0, 10, 5);
	static BasicItemCard darkShield = new BasicItemCard("Dark Shield", "dark shield", 0, -15, 30);
	static BasicItemCard armor = new BasicItemCard("Armor", "armor", 60, 0, 0);
	static BasicItemCard largeArmor = new BasicItemCard("Large Armor", "large armor", 100, -15, 0);
	static BasicItemCard lightArmor = new BasicItemCard("Light Armor", "light armor", 40, 0, 5);
	static BasicItemCard darkArmor = new BasicItemCard("Dark Armor", "dark armor", 120, 0, -20);

	static ExodiaCharacterCard exodia = new ExodiaCharacterCard();
	static ExodiaPartCard exodiaLArm = new ExodiaPartCard("Exodia Left Arm", 20);
	static ExodiaPartCard exodiaRArm = new ExodiaPartCard("Exodia Right Arm", 20);
	static ExodiaPartCard exodiaLLeg = new ExodiaPartCard("Exodia Left Leg", 20);
	static ExodiaPartCard exodiaRLeg = new ExodiaPartCard("Exodia Right Leg", 20);

	public static List<Card> initialCardStock = new ArrayList<Card>(
			List.of(darkMagician, darkMagicianGirl, blasterBlade, alfred, drgOfDestiny, aquaSurfer, mage, lightmage,
					darkmage, knight, warrior, swordsman, dragon, beast, monster, sword, longSword, lightSword,
					darkSword, shield, largeShield, lightShield, darkShield, armor, largeArmor, lightArmor, darkArmor,
					exodia, exodiaLArm, exodiaRArm, exodiaLLeg, exodiaRLeg));

	static Card[] default_ = { mage, mage, mage, mage, knight, knight, knight, knight, dragon, dragon, dragon, dragon,
			sword, sword, sword, shield, shield, shield, armor, armor, armor, longSword, longSword, longSword,
			longSword, largeShield, largeShield, largeShield, largeShield, largeArmor, largeArmor, largeArmor,
			largeArmor };

	static Card[] darkMag = { darkMagician, darkMagician, darkMagician, darkMagician, darkMagicianGirl,
			darkMagicianGirl, darkMagicianGirl, darkMagicianGirl, mage, mage, mage, mage, lightmage, lightmage,
			lightmage, lightmage, darkmage, darkmage, darkmage, darkmage, sword, sword, sword, shield, shield, shield,
			armor, armor, armor, longSword, longSword, longSword, longSword, lightSword, lightSword, lightSword,
			lightSword, darkSword, darkSword, darkSword, darkSword };
	static Card[] blastBlade = { blasterBlade, blasterBlade, blasterBlade, blasterBlade, alfred, alfred, alfred, alfred,
			knight, knight, knight, knight, warrior, warrior, warrior, warrior, swordsman, swordsman, swordsman,
			swordsman, sword, sword, sword, shield, shield, shield, armor, armor, armor, largeShield, largeShield,
			largeShield, largeShield, lightShield, lightShield, lightShield, lightShield, darkShield, darkShield,
			darkShield, darkShield };
	static Card[] desDragon = { drgOfDestiny, drgOfDestiny, drgOfDestiny, drgOfDestiny, aquaSurfer, aquaSurfer,
			aquaSurfer, aquaSurfer, dragon, dragon, dragon, dragon, beast, beast, beast, beast, monster, monster,
			monster, monster, sword, sword, sword, shield, shield, shield, armor, armor, armor, largeArmor, largeArmor,
			largeArmor, largeArmor, lightArmor, lightArmor, lightArmor, lightArmor, darkArmor, darkArmor, darkArmor,
			darkArmor };
	static Card[] exodiaD = { exodia, exodiaLArm, exodiaRArm, exodiaLLeg, exodiaRLeg, exodia, exodiaLArm, exodiaRArm,
			exodiaLLeg, exodiaRLeg, exodia, exodiaLArm, exodiaRArm, exodiaLLeg, exodiaRLeg, exodia, exodiaLArm,
			exodiaRArm, exodiaLLeg, exodiaRLeg };
	static Deck defaultDeck = new Deck("Default Deck", default_);
	static Deck darkMagDeck = new Deck("Dark Magicain Deck", darkMag);
	static Deck blastBladeDeck = new Deck("Blaster Blade Deck", blastBlade);
	static Deck desDragonDeck = new Deck("Dragon of Destiny Deck", desDragon);
	static Deck exodiaDeck = new Deck("Exodia Deck", exodiaD);

	public static Deck[] premadeDecks = { defaultDeck, darkMagDeck, blastBladeDeck, desDragonDeck, exodiaDeck };
}
