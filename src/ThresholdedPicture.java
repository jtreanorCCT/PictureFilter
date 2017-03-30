import processing.core.PApplet;
import processing.core.PImage;

public class ThresholdedPicture implements PictureFilter {
	PApplet p;
	
	public ThresholdedPicture(PApplet p) {
		this.p = p;
	}
	
	@Override
	public PImage filter(PImage image, int threshold) {
		// assume a greyscaled image gets passed in
		int[] pixels = image.pixels;
		PImage newImage = new PImage(image.width, image.height);
		for(int i = 0; i < pixels.length; i++) {
			int grey = (int) p.red(pixels[i]);
			newImage.pixels[i] = (grey > threshold) ? p.color(255) : p.color(0);
		}
		return newImage;
	}

}
