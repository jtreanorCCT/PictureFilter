import processing.core.PApplet;
import processing.core.PImage;

public class GreenTintedPicture implements PictureFilter {
	PApplet p;
	
	public GreenTintedPicture(PApplet p) {
		this.p = p;
	}
	
	public PImage filter(PImage image, int multiplier) {
		PImage newImage = new PImage(image.width, image.height);
		int[] pixels = image.pixels;
		for(int i = 0; i < pixels.length; i++) {
			int colour = pixels[i];
			int red = (int) p.red(colour);
			int green = (int) p.green(colour);
			int blue = (int) p.blue(colour);
			
			green = (green > 255) ? 255 : green*multiplier;
			newImage.pixels[i] = p.color(red, green, blue);
		}
		return newImage;
	}
	
	
}
