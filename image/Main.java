package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
	    try {
	    	File input = new File("flag.jpeg");
	    	BufferedImage image;
			image = ImageIO.read(input);
//			BufferedImage newImage = getImageRotate(image, 1);
//		    File output = new File("counterclockwise-" + input.getName());
//		    // ImageIO.write write an image of a certain formats
//		    ImageIO.write(newImage, "jpg", output);
		    
		    ImageToPixel pixel = new ImageToPixel(image);
		    pixel.getFirstPixel();
		    pixel.printPixelArray();
		    
		    RotateImage rotate = new RotateImage(image, 1);
		    File output = new File("rotate-" + input.getName());
		    ImageIO.write(rotate.getImageRotate(), "jpg", output);
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
