package data;

import java.util.Random;

import application.Main;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Crewmate {
	int x, y, r, speedX, speedY;
	int c;
	public static Random random = new Random();
	ImageView imageView;
	boolean isDead;
	Animation animation;
	public Crewmate(int x, int y) {
		this.x = x;
		this.y = y;
		this.c = random.nextInt(3);
		isDead = false;
		r = 30 + random.nextInt(50);
		speedX = 10 - random.nextInt(10) - 5;
		speedY = random.nextInt(10) - 5;
		createSprite();
	}
	/////////////////////////////////////// Crewmate Movement //////////////////////////////////////	
	public void update() {
		if(!isDead) {
			this.x+= speedX;
			this.y+= speedY;
			if(x < 0 || x > Main.width) {
				speedX *= -1;
			}
			if(y < 0 || y > Main.height) {
				speedY *= -1;
			}	
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}
	
	public ImageView getImageView() {
		return imageView;
	}
	
	public void kill() {
		
		isDead = true;
		createSprite();
	}
	
	/////////////////////////////////////// Crewmate Animation //////////////////////////////////////
	
	 private static final Image IMAGE1 = new Image("New Among Us Walk Sprite 1.png");
	 private static final Image IMAGE2 = new Image("New Among Us Walk Sprite 2.png");
	 private static final Image IMAGE3 = new Image("New Among Us Walk Sprite 3.png");
	 private static final Image IMAGE1D = new Image("New Among Us Dead Sprite 1.png");
	 private static final Image IMAGE2D = new Image("New Among Us Dead Sprite 2.png");
	 private static final Image IMAGE3D = new Image("New Among Us Dead Sprite 3.png");
	 private static final int COLUMNS  =   12;
	 private static final int COUNT    = 12;
	 private static final int OFFSET_X =  0;
	 private static final int OFFSET_Y =  0;
	 private static final int WIDTH    = 85;
	 private static final int HEIGHT   = 140;
	    
	    
	void createSprite() {
		if(isDead) {
			imageView.setImage(null);
			animation.stop();
			imageView = new ImageView(c==0?IMAGE1D:(c==1?IMAGE2D:IMAGE3D));
		}
		else {
			
			imageView = new ImageView(c==0?IMAGE1:(c==1?IMAGE2:IMAGE3));
		}
		imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
		imageView.relocate((double)(getX()), (double)(getY()));
		//imageView.relocate(arg0, arg1);
		if(!isDead) {
			animation = new SpriteAnimation(
		             imageView,
		             Duration.millis(500),
		             COUNT, COLUMNS,
		             OFFSET_X, OFFSET_Y,
		             WIDTH, HEIGHT
				);
				animation.setCycleCount(Animation.INDEFINITE);
				animation.play();			
		}
	}
	
}
