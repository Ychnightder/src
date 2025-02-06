package serveur;

import java.io.IOException;

class Application {
	private final static int PORT = 1234;

	public static void main(String[] args) {
		try {
			new Thread(new Serveur(PORT)).start();
			System.out.println("Serveur demarre sur le port " + PORT);
		} 
		catch (IOException e) {
			System.err.println("Pb lors de la cr�ation du serveur : " +  e);			
		}
	}
}
