package data;

import application.Main;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Alarm {
	 	private static final Image IMAGE = new Image("Red Alarm.png");
	    private static final int COLUMNS  =   2;
	    private static final int COUNT    = 2;
	    private static final int OFFSET_X =  0;
	    private static final int OFFSET_Y =  0;
	    private static final int WIDTH    = 1280;
	    private static final int HEIGHT   = 720;
		ImageView imageView;
		Animation animation;
		boolean isOn = false;
		
		public Alarm() {
			imageView = new ImageView(IMAGE);
			switchAlarm();
		}
		public void switchAlarm() {
		/*
		ctx.setFill(b.getC());
		ctx.fillOval(b.getX(), b.getY(), b.getR(), b.getR());
		*/
		
		imageView = new ImageView(IMAGE);
		
		imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
		imageView.relocate((double)(Main.width), (double)(Main.height));
		//imageView.relocate(arg0, arg1);
		
		animation = new SpriteAnimation(
		           imageView,
		           Duration.millis(1200),
		           COUNT, COLUMNS,
		           OFFSET_X, OFFSET_Y,
		           WIDTH, HEIGHT
		);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();

	}
	public ImageView getImageView() {
		return imageView;
	}
}
