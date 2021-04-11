package main;

import gui.ControlPane;
import gui.FieldPane;
import gui.SimulationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		root.setPrefHeight(400);
		ControlPane controlPane = new ControlPane();
		FieldPane fieldPane = new FieldPane();
		root.getChildren().addAll(controlPane, fieldPane);
		SimulationManager.setControlPane(controlPane);
		SimulationManager.setFieldPane(fieldPane);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Harvest Simulator");
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
