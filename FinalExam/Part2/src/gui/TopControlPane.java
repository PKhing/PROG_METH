package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import logic.ButtonLogic;

public class TopControlPane extends BorderPane {

	private TimeDisplay timeDisplay;
	private Button newGameButton;

	public TopControlPane() {
		super();
		this.setPrefHeight(50.0);
		this.setPrefWidth(600.0);
		this.setPadding(new Insets(10, 20, 0, 20));
		timeDisplay = new TimeDisplay(0);
		newGameButton = new Button("New Game");
		newGameButton.setOnMouseClicked((MouseEvent e) -> ButtonLogic.topControlPaneOnClick());
		this.setLeft(timeDisplay);
		this.setRight(newGameButton);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	}

	public Button getNewGameButton() {
		return newGameButton;
	}

	public void setNewGameButton(Button newGameButton) {
		this.newGameButton = newGameButton;
	}

	public void setTimeDisplay(TimeDisplay timeDisplay) {
		this.timeDisplay = timeDisplay;
	}

	public TimeDisplay getTimeDisplay() {
		return timeDisplay;
	}
}
