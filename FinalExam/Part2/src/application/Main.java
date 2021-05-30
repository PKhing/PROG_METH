package application;

import gui.BottomControlPane;
import gui.DisplayPane;
import gui.TopControlPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	private static TopControlPane tcp;
	private static DisplayPane dp;
	private static BottomControlPane bcp;

	@Override
    public void start(Stage stage) {
		tcp = new TopControlPane();
		dp = new DisplayPane();
		bcp = new BottomControlPane();
		BorderPane root = new BorderPane();
        
        root.setTop(tcp);
        root.setCenter(dp);
        root.setBottom(bcp);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Tanjiro’s training");
        stage.show();
    }

    public static TopControlPane getTcp() {
		return tcp;
	}

	public static DisplayPane getDp() {
		return dp;
	}

	public static BottomControlPane getBcp() {
		return bcp;
	}

	public static void main(String[] args) {
        launch();
    }

}
