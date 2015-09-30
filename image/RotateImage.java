package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * This class is used for rotating an image(Jpg format only tested)
 * there are 2 methods available in this class, getImageRotateClockwise and getImageRotateCounterClockwise
 * @author user
 *
 */

public class RotateImage {
	
	private BufferedImage image;
	private int option = 1;
	
	public RotateImage(BufferedImage image, int option){
		this.image = image;
		this.option = option;
	}
	
	public BufferedImage getImageRotate(){
		return rotateTheImage();
	}
	
	/**
	 * Rotation option can be change in this setter method
	 * @param option
	 */
	public void setImageRotate(int option){
		this.option = option;
	}
	
	/**
	 * This method takes in parameter an image of type BufferedImage and 
	 * an option of type int (1 for clockwise else for counter clockwise) 
	 * @param image
	 * @return
	 */
	public BufferedImage rotateTheImage() {
		int width = image.getWidth();
	    int height = image.getHeight();
	    
	    //toHeight and toWidth is the height and width of the rotated image
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

}
