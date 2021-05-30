package gui;

import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DisplayPane extends VBox {
	private ImageView statusImage;
	private String trainUrl;
	private String restUrl;
	private String eatUrl;
	private ProgressBar skillBar;
	private ProgressBar staminaBar;
	private ProgressBar foodBar;
	
	public DisplayPane() {
		super();
		this.initImageUrl();
		this.initStatusImage();
		this.initProgressBar();
		this.setPrefHeight(350);
		this.setPrefWidth(600);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
		this.getChildren().addAll(statusImage,skillBar,staminaBar,foodBar);
	}
	private void initImageUrl() {
		trainUrl = ClassLoader.getSystemResource("res/train.jpeg").toString();
		eatUrl = ClassLoader.getSystemResource("res/eat.jpeg").toString();
		restUrl = ClassLoader.getSystemResource("res/rest.jpeg").toString();
	}

	private void initStatusImage() {
		Image newGame = new Image(trainUrl);
		statusImage = new ImageView(newGame);
		statusImage.setFitHeight(200);
		statusImage.setFitWidth(200);
	}
	
	private void initProgressBar() {
		skillBar = new ProgressBar(0);
		skillBar.setPrefWidth(300);
		staminaBar = new ProgressBar(0);
		staminaBar.setPrefWidth(300);
		foodBar = new ProgressBar(0);	
		foodBar.setPrefWidth(300);
	}
	
	public void act(String action) {
		switch (action) {
		case "TRAIN":
			if (staminaBar.getProgress() >= 0.2 && foodBar.getProgress() >= 0.2) {
				statusImage.setImage(new Image(trainUrl));
				skillBar.setProgress(skillBar.getProgress()+0.1);
				staminaBar.setProgress(staminaBar.getProgress()-0.2);
				foodBar.setProgress(foodBar.getProgress()-0.2);
			}
			break;
		case "REST":
			if (staminaBar.getProgress()<= 0.9) {	
				statusImage.setImage(new Image(restUrl));
				staminaBar.setProgress(staminaBar.getProgress()+0.1);
			}
			break;
		case "EAT":
			if (foodBar.getProgress()<= 0.9) {	
				statusImage.setImage(new Image(eatUrl));
				foodBar.setProgress(foodBar.getProgress()+0.1);
			}
			break;
		default:
			break;
		}
	}
	
	public void resetDisplayPane() {
		statusImage.setImage(new Image(trainUrl));
		skillBar.setProgress(0);
		staminaBar.setProgress(0);
		foodBar.setProgress(0);
	}
}
