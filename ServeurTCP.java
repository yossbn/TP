import java.net.*;
import java.io.*;
import java.util.*;

public class ServeurTCP extends Thread{

	static final int port = 6666;
	private Socket socket;
	private static int nombreDeClient;

	public ServeurTCP(Socket soc) {
		this.socket = soc;
	}

	private static void AfficherUnTableau(int tab[]){
	System.out.println(Arrays.toString(tab));				
	}

	private static String ChercherUnDoublant(int t[])
	{
		for (int i=0; i<t.length; i++){
			for (int j=i+1; j<t.length; j++) 
			{
				if (t[i]==t[j]) {
					return "Oui, le tableau contient un doublant";	
				}
			
			}}
			return "Non, le tableau ne contient pas un doublant";							
	}

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(port);

		while(true)
		{
			System.out.println("Attendre l'arriver d'un client..");
			Socket socket = serverSocket.accept();
			nombreDeClient++;
			System.out.println("Nombre de client connecter au serveur : " + nombreDeClient);
			ServeurTCP serveurTCP = new ServeurTCP(socket);
			serveurTCP.start();
		}
	}
	
	public void run () {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				System.out.println("Adresse et port du client : " + socket.getRemoteSocketAddress());
				output.writeObject(nombreDeClient);
				int[] tab = (int[]) input.readObject();
				System.out.println("Tableau du client actuel : ");
				AfficherUnTableau(tab);
				String message = ChercherUnDoublant(tab);
				output.writeObject(message);
			}
		} 
		catch (Exception e) {
			System.out.println("Un client s'est deconnecte !");
			nombreDeClient--;
		}
	}
	
}