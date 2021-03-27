package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class DrawUtil {

	private static String image_path = ClassLoader.getSystemResource("images/sprites_sheet.png").toString();
	private static Image mainsprites = new Image(image_path);
	
	private static String congrat_path = ClassLoader.getSystemResource("images/congratulations.png").toString();
	private static Image congratsprites = new Image(congrat_path);
	
	
	public static void drawSprite(GraphicsContext gc,int x,int y,int index) {
		WritableImage img = new WritableImage(mainsprites.getPixelReader(),index*24,0,24,24);
		gc.drawImage(img, x, y);
	}
	
	public static void drawCongrats(GraphicsContext gc,int x,int y) {
		//System.out.println(image_path);
		gc.drawImage(congratsprites, x-200, y-80);
	}
}
