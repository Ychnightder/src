package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Application {
	private final static int PORT = 1234;
	private final static String HOST = "localhost"; 

	public static void main(String[] args) {
		Socket socket = null;		
		try {
			// Cree ET connecte une socket pour communiquer avec le service
			// se trouvant sur la machine host au port PORT
			socket = new Socket(HOST, PORT);
			// Informe l'utilisateur que la connection est r�alis�e
			System.out.println("Connect� au serveur " + socket.getInetAddress() + ":"+ socket.getPort());
			System.out.println("Port local : " + socket.getLocalPort());

			// Cree les streams pour lire et ecrire du texte dans cette socket
			BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
			// Cree le stream pour lire du texte a partir du clavier 
			// (on pourrait aussi utiliser Scanner)
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));


			System.out.println("On raccroche avec le serveur\n");
			socket.close();
		}
		catch (IOException e) { System.err.println(e); }
		// Refermer dans tous les cas la socket
		try { if (socket != null) socket.close(); } 
		catch (IOException e2) { ; }		
	}
}
