import processing.core.PImage;
import processing.core.PApplet;

public enum TintedPicture implements PictureFilter{
	RED_TINT(0),
	GREEN_TINT(1),
	BLUE_TINT(2);
	
	PApplet p;
	private final int component;
	
	TintedPicture(int component) {
		this.component = component;
	}
	
	public void setPApplet(PApplet p) {
		this.p = p;
	}
	
	@Override
	public PImage filter(PImage image, int value) {
		int[] pixels = image.pixels;
		PImage newImage = new PImage(image.width, image.height);
		int[] colours = new int[3];
		int colour = 0;
		for(int i = 0; i < pixels.length; i++) {
			colour = pixels[i];
			colours[0] = (int) p.red(colour);
			colours[1] = (int) p.green(colour);
			colours[2] = (int) p.blue(colour);
			colours[component] = (colours[component]*value > 255) ? 255 : colours[component]*value;
			newImage.pixels[i] = p.color(colours[0], colours[1], colours[2]);
		}
		return newImage;
	}

}
