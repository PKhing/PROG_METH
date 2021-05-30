package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;
import data.Alarm;
import data.Crewmate;
import data.CrewmateField;

public class Main extends Application {
  	private ThreadMain threadMain;
  	protected static CrewmateField crewmateField;
  	private static Alarm alarm;
  	private static Button createCrewmate;	
  	private static Button killCrewmate;
  	private static Button sabotage;
  	public int frames = 10;
  	public String title = "Between Us";
  	public static int width = 600;
  	public static int height = 400;
  	public static Random random = new Random();
	private static boolean isAlarmOn = false;
  	Canvas canvas = new Canvas();
  	static Pane pane = new Pane();
  	GraphicsContext ctx = canvas.getGraphicsContext2D();
  	private static final Image background = new Image("SpaceshipBackground.png");
    
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
    	threadMain = new ThreadMain();
    	setup();
		canvas.setHeight(height);
		canvas.setWidth(width);
		crewmateField = new CrewmateField();
		alarm = new Alarm();
		VBox root = new VBox();
		HBox controlTab = new HBox();
		controlTab.setAlignment(Pos.CENTER);
		createCrewmate = new Button("Create Crewmate");
		killCrewmate = new Button("Kill");
		sabotage = new Button("Sabotage");
		controlTab.getChildren().addAll(createCrewmate,killCrewmate,sabotage);
		root.getChildren().addAll(controlTab, pane);
		stage.setTitle(title);
		stage.setScene(new Scene(root, width, height));
		stage.show();
		drawBackground();
		
		createCrewmate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				crewmateField.addCrewMate(); 
				threadMain.initalizeNewCrewmate(crewmateField.getCrewmateCount()-1);
			}
		});
		
		killCrewmate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				crewmateField.killCrewMate(); 
			}
		});
		
		sabotage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				threadMain.initalizeAlarm();
			}
		});
		canvas.requestFocus();
    }
	
	void setup() {
		title = "Between Us";
		width = 800;
		height = 600;
	}
	void drawBackground() {
		ImageView backgroundImgView = new ImageView(background);	
		addToPane(backgroundImgView);
	}

	
	
	protected static void drawCrewmate(Crewmate b) {
		ImageView im = b.getImageView();
        removeFromPane(im);
        im.relocate((double)(b.getX()), (double)(b.getY()));
        addToPane(im);

	}
	protected static void turnAlarm() {
		isAlarmOn = !isAlarmOn;
		ImageView im = alarm.getImageView();
        removeFromPane(im);
        im.relocate(0, (double)0);
        if(isAlarmOn)addToPane(im);

	}
	 public static void addToPane(ImageView imageview) {
	        pane.getChildren().add(imageview);
	}

	public static void removeFromPane(ImageView imageview) {
	        pane.getChildren().remove(imageview);
	}
}