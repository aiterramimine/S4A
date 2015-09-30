package packageBinarytoString;

import java.util.Scanner;

/**
 * Classe test qui "convertit" une chaine de caractères (ascii)
 * en un flot de bits
 * @author Adrien
 * date : 23/09/2015
 *
 */

public class BinaryToString {

	static StringBuilder chaineToBinaire(String chaine){
	    byte[] bytes = chaine.getBytes();
	    StringBuilder binary = new StringBuilder();
	    for (byte b : bytes) {
	        int val = b;
	        for (int i = 0; i < 8; i++) {
	            binary.append((val & 128) == 0 ? 0 : 1);
	            val <<= 1;
	        }
	        //binary.append(' ');
	    }
	    return binary;
	}
	
	static String binaireToChaine(StringBuilder a2){
	     
	    String res="";
	        for(int i=1;i<a2.length();i++){
	            if(i%8==0){
	                char a=(char)Integer.parseInt(a2.substring(i-8,i),2);
	                res=res+a;
	            }  
	        }
	        res=res+(char)Integer.parseInt(a2.substring(a2.length()-8,a2.length()),2);
	        return res;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("chaine texte avant transformation binaire (caractère ascii) : ");
		Scanner a = new Scanner(System.in);
		String debut= a.nextLine();
		
		String fin= new String();
		
		System.out.println(debut+": "+chaineToBinaire(debut));
		fin=binaireToChaine(chaineToBinaire(debut));
		System.out.println(chaineToBinaire(debut)+": "+fin);
	}

}
