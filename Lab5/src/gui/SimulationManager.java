package gui;

public class SimulationManager {

	private static ItemButton selectedItemButton;
	private static FieldPane fieldPane;
	private static ControlPane controlPane;
	private static int money = 500;

	public static ItemButton getSelectedItemButton() {
		return selectedItemButton;
	}

	public static void setSelectedItemButton(ItemButton selectedItemButton) {
		SimulationManager.selectedItemButton = selectedItemButton;
	}

	public static int getMoney() {
		return money;
	}

	public static void harvestHandler() {
		SimulationManager.money += fieldPane.calculateIncome();
		controlPane.setMoneyLabelText();
	}

	public static void reduceMoneyBuySeed() {
		SimulationManager.money -= SimulationManager.getSelectedItemButton().getItem().getPrice();
		controlPane.setMoneyLabelText();
		if (SimulationManager.money < SimulationManager.getSelectedItemButton().getItem().getPrice()) {
			SimulationManager.getSelectedItemButton().unhighlight();
			SimulationManager.setSelectedItemButton(null);
		}
	}

	public static void setFieldPane(FieldPane fieldPane) {
		SimulationManager.fieldPane = fieldPane;
	}

	public static FieldPane getFieldPane() {
		return fieldPane;
	}

	public static void setControlPane(ControlPane controlPane) {
		SimulationManager.controlPane = controlPane;
	}

}
