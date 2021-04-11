package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

//You might need to do something to the following line
public class ItemPane extends GridPane {

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();

	public ItemPane() {
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);

		final String itemNameList[] = { "Corn", "Coffee", "Blueberry", "Strawberry", "Pineapple", "DestroyTool" };
		for (int i = 0; i < itemNameList.length; i++) {
			ItemButton itemButton = new ItemButton(itemNameList[i]);
			itemButton.setOnAction((event) -> {
				if (SimulationManager.getMoney() >= itemButton.getItem().getPrice()) {
					this.setSelectedButton(itemButton);
				}
			});
			GridPane.setColumnIndex(itemButton, i % 3);
			GridPane.setRowIndex(itemButton, i / 3);
			this.getChildren().add(itemButton);
			itemButtonList.add(itemButton);
		}
	}

	public void setSelectedButton(ItemButton selecteditemButton) {
		SimulationManager.setSelectedItemButton(selecteditemButton);
		resetButtonsBackGroundColor();
		selecteditemButton.highlight();
	}

	public void resetButtonsBackGroundColor() {
		for (ItemButton itemButton : itemButtonList) {
			itemButton.unhighlight();
		}
	}

}
