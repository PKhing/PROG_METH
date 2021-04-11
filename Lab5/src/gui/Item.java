package gui;

public class Item {

	private String itemName;
	private String url;
	private int price;
	private int income;

	Item(String itemName) {
		switch (itemName) {
		case "Corn":
			url = "Corn.png";
			price = 100;
			income = 10;
			break;
		case "Coffee":
			url = "Coffee.png";
			price = 400;
			income = 40;
			break;
		case "Blueberry":
			url = "Blueberry.png";
			price = 1000;
			income = 100;
			break;
		case "Strawberry":
			url = "Strawberry.png";
			price = 4000;
			income = 400;
			break;
		case "Pineapple":
			url = "Pineapple.png";
			price = 16000;
			income = 2000;
			break;
		default:
			url = "Destroy.png";
			price = 0;
			itemName = "DestroyTool";
		}
		this.itemName = itemName;
	}

	public boolean isDestroyTool() {
		return this.itemName == "DestroyTool";
	}

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}

	public String getUrl() {
		return url;
	}

	public int getIncome() {
		return income;
	}

	public String getPriceText() {
		if (price > 0) {
			return "\nPrice: " + price;
		}
		return "";
	}

	public String getIncomeText() {
		if (income > 0) {
			return "\nIncome: " + income;
		}
		return "";
	}
}
