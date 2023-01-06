package Client;

import java.io.IOException;

/**
 * The main class to run the client code in
 * 
 * @author Daniel Falcone
 *
 */
public class ClientMain {

	public static void main(String[] args) {
		Client c = new Client();

		try {
			c.runClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
