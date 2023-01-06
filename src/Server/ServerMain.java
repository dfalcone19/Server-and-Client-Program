package Server;

import java.io.IOException;

/**
 * The main class to run the server code in
 * 
 * @author Daniel Falcone
 *
 */
public class ServerMain {

	public static void main(String[] args) {
		Server s = new Server();

		try {
			s.runServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
