package packageLireEcrireFichierTexte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
	//protected String FichierDestination;
	public static void main(String[] argv) throws IOException {
		   //ecrire();
		System.out.println("inscrire le nom de fichier � �crire");
		Scanner a = new Scanner(System.in);
		ecrireFichier(a.nextLine());
	}
	public static void ecrireFichier(String ecriture) throws IOException{
		//cr�ation d'un fichier � partir de la chaine de caract�res pass�e en parametre
		
		File f=new File(ecriture);
		//v�rifie l'existence du fichier dans le repertoire courant
		
		if(f.exists()){
			System.out.println("found ");
			FileWriter fichier = new FileWriter(ecriture);
			BufferedWriter ecrit= new BufferedWriter(fichier);
			ecrit.write("bonjour");
			ecrit.newLine();
			ecrit.write("Nous sommes le 30/09/2015");     
			ecrit.write(", le nombre magique est 123");
			System.out.println("Fin d'�criture dans le fichier "+ecriture);
			ecrit.close();
		}
	       else System.out.println("not found");
		System.out.print("Fin de programme");
		
	}
	
	
	
}
