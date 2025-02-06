package serveur;

import java.io.*;
import java.net.*;

class Serveur implements Runnable {
	private ServerSocket listen_socket;
	
	// Cree un serveur TCP - objet de la classe ServerSocket
	Serveur(int port) throws IOException {
		listen_socket = new ServerSocket(port);
	}

	// Le serveur ecoute et accepte les connexions.
	// pour chaque connexion, il cree un ServiceInversion, 
	// qui va la traiter, et le lance
	public void run() {
		try {
			while(true) {
				System.out.println("J'attends un client...");
				Socket client_socket = listen_socket.accept(); // Appel bloquant !
				System.out.println("Ca y est ! J'ai un client.");
				
				System.out.print("Adresse IP locale : "+client_socket.getLocalAddress());
				System.out.println(" Port local : "+client_socket.getLocalPort());
				System.out.print("Adresse IP distante (client) : "+client_socket.getInetAddress());
				System.out.println(" Port distant : "+client_socket.getPort());
				
				// Ici On lance un thread pour réaliser un service particulier
				
				System.out.println("On raccroche avec le client\n");
				client_socket.close(); // Ca c'est ici pour que le squelette marche proprement
			}
		}
		catch (IOException e) { 
			try {this.listen_socket.close();} catch (IOException e1) {}
			System.err.println("Pb sur le port d'écoute :"+e);
		}
	}

	 // restituer les ressources --> finalize
	protected void finalize() throws Throwable {
		try {this.listen_socket.close();} catch (IOException e1) {}
	}
}
