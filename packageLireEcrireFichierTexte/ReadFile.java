package packageLireEcrireFichierTexte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//terminer classe 
public class ReadFile {

	public static void main(String[] argv) throws IOException {
		System.out.println("inscrire le nom de fichier à lire");
		Scanner a = new Scanner(System.in);
		lire(a.nextLine());
	}

	public static void lire(String fichier) throws IOException {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		String fileName = fichier;
		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(fileName));
			System.out.println("lecture dans le fichier : ");
			while ((ligne = lecteurAvecBuffer.readLine()) != null)
				System.out.println(ligne);
			lecteurAvecBuffer.close();
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		System.out.println("Fin de programme");
	}
}	
