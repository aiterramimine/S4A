package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * This class is used for rotating an image(Jpg format only tested)
 * there are 2 methods available in this class, getImageRotateClockwise and getImageRotateCounterClockwise
 * @author user
 *
 */

public class RotateImage {
	
	/**
	 * This method takes in parameter an image of type BufferedImage and 
	 * an option of type int (1 for clockwise else for counter clockwise) 
	 * @param image
	 * @return
	 */
	public static BufferedImage getImageRotate(BufferedImage image,int option) {
		int width = image.getWidth();
	    int height = image.getHeight();
	    int toHeight = width;
	    int toWidth = height;
	    //Creation of a new image with the inverted width and height from the given image
	    BufferedImage newImage = new BufferedImage(toWidth, toHeight , BufferedImage.TYPE_INT_RGB);
	    
	    for(int i = 0; i < height; i++){
	      for(int j = 0; j < width; j++){
	    	//Saves the image pixels of the coordinate j,i.
	        Color c = new Color(image.getRGB(j, i));
		    if(option == 1){
		    	//Set the pixel starting at top right towards bottom left (clockwise)
		    	int k = (toWidth - 1) - i;
		    	//Set the pixel on the new pixel at the given coordinate
		    	newImage.setRGB(k,j,c.getRGB());
		    }
		    else{
		    	//Set the pixel starting at bottom left towards towards right.
		    	 int k = (toHeight - 1) - j;
			     newImage.setRGB(i,k,c.getRGB());
		    }
	      }
	    }
	    return newImage;
	  }

	  static public void main(String args[]) throws IOException {
		File input = new File("world_map.jpg");
	    BufferedImage image = ImageIO.read(input);
	    BufferedImage newImage = getImageRotate(image, 1);
	    File output = new File("counterclockwise-" + input.getName());
	    // ImageIO.write write an image of a certain formats
	    ImageIO.write(newImage, "jpg", output);
	  }
}
