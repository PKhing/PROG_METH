package gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ButtonLogic;

public class BottomControlPane extends HBox {
	private Button trainButton;
	private Button restButton;
	private Button eatButton;

	public BottomControlPane() {
		super();
		initAllButton();
		this.setPrefHeight(120.0);
		this.setPrefWidth(600.0);
		this.setSpacing(50.0);
		this.setAlignment(Pos.CENTER);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		this.getChildren().addAll(trainButton, restButton, eatButton);
	}

	public void initAllButton() {
		trainButton = new Button("Train");
		restButton = new Button("Rest");
		eatButton = new Button("Eat");
		trainButton.setFont(new Font("Arial", 30.0));
		restButton.setFont(new Font("Arial", 30.0));
		eatButton.setFont(new Font("Arial", 30.0));
		trainButton.setOnMouseClicked((MouseEvent e) -> ButtonLogic.bottomControlPaneOnClick("TRAIN"));
		restButton.setOnMouseClicked((MouseEvent e) -> ButtonLogic.bottomControlPaneOnClick("REST"));
		eatButton.setOnMouseClicked((MouseEvent e) -> ButtonLogic.bottomControlPaneOnClick("EAT"));
	}

	public Button getTrainButton() {
		return trainButton;
	}

	public void setTrainButton(Button trainButton) {
		this.trainButton = trainButton;
	}

	public Button getRestButton() {
		return restButton;
	}

	public void setRestButton(Button restButton) {
		this.restButton = restButton;
	}

	public Button getEatButton() {
		return eatButton;
	}

	public void setEatButton(Button eatButton) {
		this.eatButton = eatButton;
	}

}
