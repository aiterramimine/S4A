package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImageToPixel {
	
	private BufferedImage image;
	private String[] pixelArray;
	
	public ImageToPixel(BufferedImage image){
		this.image = image;
		this.pixelArray = new String[image.getWidth()*image.getHeight()]; 
	}
	/**
	 * This method return a String type array that contains all the pixels of the image
	 * @return
	 */
	public String[] getPixelArray(){
		return this.pixelArray;
	}
	
	/**
	 * Return an array of type String that all the pixel
	 * @return
	 */
	public String[] imageToPixelArray(){
		int k = 0;
		//There are 2 loops because an image has a 2d matrix that contains pixel
		for(int i = 0 ; i < image.getHeight() ; i++){
			for(int j = 0 ; j < image.getWidth() ; j++){
				Color c = new Color(image.getRGB(j, i));
			    pixelArray[k] = convertColorToHexadeimal(c);
			    k++;
			}
		}
		return pixelArray;
	}
	/**
	 * This method is only used during the testing period of the class
	 * Returns the first pixel and shows the value in decimal of each color in the pixel 
	 */
	public void getFirstPixel() {
		//getRgb returns the image's pixel of the given coordinate in the form of integer 
	    Color c = new Color(image.getRGB(1, 1));
	    String firstPixel = convertColorToHexadeimal(c);
	    System.out.print(firstPixel + ": "+ c.getRed()+", "+c.getGreen()+", "+c.getBlue());
	}
	
	/**
	 * Method that converts integer to String in the form of hexadecimal
	 * @param color
	 * @return
	 */
	public String convertColorToHexadeimal(Color color)
	{
	        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
	        //This condition is used to make the String presentation look formal
	        if(hex.length() < 6) 
	        {
	            if(hex.length()==5)
	                hex = "0" + hex;
	            if(hex.length()==4)
	                hex = "00" + hex;
	            if(hex.length()==3)
	                hex = "000" + hex;
	        }
	        hex = "#" + hex;
			return hex;
	}
	
	/**
	 * Print all the pixel in the array of the image
	 */
	public void printPixelArray(){
		String[] pixelArray = imageToPixelArray();
	    for(int i = 0; i < image.getHeight()*image.getWidth() ; i++){
	    	if(i % image.getWidth() == 0){
	    		System.out.print("\n");
	    	}
	    	System.out.print(pixelArray[i] + ", ");
	    }
	}
}
