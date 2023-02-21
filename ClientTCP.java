import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class ClientTCP{

	public static Scanner scanner =new Scanner(System.in);

	private static void AfficherUnTableau(int tab[]){
	System.out.println(Arrays.toString(tab));				
	}

	private static int[] RemplirUnTableau(int tab[]){
		for (int i=0; i < tab.length; i++) {
		tab[i] = scanner.nextInt();
		}
		return tab;
	}
	
	public static void main(String[] args) {
		try{
			Socket socket = new Socket("localhost",6666);
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

			while(true){
				Thread.sleep(1000);
				System.out.println("Le nombre de client connecter deja est : " + input.readObject());		

				System.out.println("Veuillez entrer la taille de votre tableau :\nTaille = ");
				
				int taille = scanner.nextInt();
				int tableau[] = new int[taille];
				
				System.out.println("Veuillez remplir votre tableau :");
				tableau = RemplirUnTableau(tableau);
				output.writeObject(tableau);
				AfficherUnTableau(tableau);
				System.out.println("->" + (String) input.readObject());
			}	
		}
		
		catch(Exception e){
			System.out.println("Erreur !\n" + e);
		}		
	}
}


