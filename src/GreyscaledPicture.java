import processing.core.PApplet;
import processing.core.PImage;

public class GreyscaledPicture implements PictureFilter {
	PApplet p;
	
	public GreyscaledPicture(PApplet p) {
		this.p = p;
	}
	
	@Override
	// value is irrelevant here
	public PImage filter(PImage image, int value) {
		int[] pixels = image.pixels;
		PImage newImage = new PImage(image.width, image.height);
		for(int i = 0; i < pixels.length; i++) {
			int colour = pixels[i];
			int red = (int) p.red(colour);
			int green = (int) p.green(colour);
			int blue = (int) p.blue(colour);
			newImage.pixels[i] = p.color(max(red, green, blue));
		}
		return newImage;
	}
	
	private int max(int r, int g, int b) {
		int max = r;
		if(b > max) max = b;
		if(g > max) max = g;
		return max;
	}

}
