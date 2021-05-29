package data;

import java.util.Random;

public class TaskUtil {
	
	private static Random rand = new Random();
	
	private static String[] taskList = {
	"Pick all the weeds",
	"Pick all the trash",
	
	"Plant 5 Flowers",
	"Plant 1 Cidar Tree",
	"Plant 1 Fruit Tree",
	
	"Talk to 3 Neighbors",
	
	"Assess 5 Fossils",
	
	"Hit the Rock 5 Times",
	
	"Order 20 Pieces of Furniture",
	"Order Office Desk",
	"Order Water Cooler",
	"Order Vending Machine",
	"Order Toilet",
	"Order Bidet",
	
	"Craft Filmsy Shovel",
	"Craft Fishing Rod",
	"Craft Ironwood Kitchenette",
	"Craft Flying Saucer",
	"Craft Toy Robot",
	
	
	"Collect 20 Seashells",
	
	"Run Fishing Tourney",
	
	"Catch 1 Sea Bass",
	"Catch 1 Blue Marin",
	"Catch 1 Oarfish",
	"Catch Blue Marin",
	
	"Run Bug Catching Contest",
	
	"Catch 30 Tarantulas",
	"Catch 30 Scorpions",
	"Catch 2 Wharf Roach",
	
	"Finding Missing Device Part",
	"Finding 5 Missing Spirits",
	"Buy 5000$ worth of Clothing",
	"Fishes 3 Large-sized Fish in a Row",
	"Commission Atlas Moth Model"
	};
	
	public static String getRandomTask() {
		return taskList[rand.nextInt(taskList.length)];
	}
	
	public static int getRandomReward() {
		return rand.nextInt(999)*10;
	}
	
}
