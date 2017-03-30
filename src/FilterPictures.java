import processing.core.PApplet;
import processing.core.PImage;

public class FilterPictures extends PApplet {
	public static void main(String[] args) {
		PApplet.main("FilterPictures");
	}
	
	PImage myPicture;
	
	public void settings() {
		size(1000, 500);
		myPicture = loadImage("pics/HappyDog.jpg");
	}
	
	public void setup() {
		// Apply a red tint
		PictureFilter rtp = new RedTintedPicture(this);
		PImage redTintedPicture = rtp.filter(myPicture, 5);
		// Apply a blue tint
		BlueTintedPicture btp = new BlueTintedPicture(this);
		PImage blueTintedPicture = btp.filter(myPicture, 10);
		// Apply a green tint
		GreenTintedPicture gtp = new GreenTintedPicture(this);
		PImage greenTintedPicture = gtp.filter(myPicture, 2);
		// Convert the image to greyscale
		GreyscaledPicture gsp = new GreyscaledPicture(this);
		PImage greyscaledPicture = gsp.filter(myPicture, 0);
		// Threshold the image at a value of say 50
		// we will pass in the greyscaled picture for now
		ThresholdedPicture tp = new ThresholdedPicture(this);
		PImage thresholdedPicture = tp.filter(greyscaledPicture, 50);
		
		//redTintedPicture.resize(1000,  500);
		//image(redTintedPicture, 0, 0);
		
		//greenTintedPicture.resize(1000,500);
		//image(greenTintedPicture, 0, 0);
		
		//blueTintedPicture.resize(1000, 500);
		//image(blueTintedPicture, 0, 0);
		
		//greyscaledPicture.resize(1000, 500);
		//image(greyscaledPicture,0,0);
		
		//thresholdedPicture.resize(1000,500);
		//image(thresholdedPicture, 0, 0);
		
		TintedPicture p = TintedPicture.BLUE_TINT;
		p.setPApplet(this);
		PImage newP = new PImage(myPicture.width, myPicture.height);
		newP = p.filter(myPicture, 10);
		
		newP.resize(1000, 500);
		image(newP, 0, 0);
		
		//myPicture.resize(1000,500);
		//image(myPicture, 0, 0);
	}
}
