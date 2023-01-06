package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A class to represent the TCP client
 * 
 * @author Daniel Falcone
 *
 */
public class Client {
	private String host = "localhost";
	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;

	/**
	 * A method to run the client methods and close the connection
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	public void runClient() throws IOException {
		try {
			connection = new Socket(host, 1254);

			while (true) {
				waitForConnection();
				getStreams();
				processConnection();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * A method to show that the client has waited and then received a connection
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void waitForConnection() throws IOException {
		System.out.println("Waiting for connection");
		System.out.println("Connection received from " + connection.getInetAddress().getHostAddress());
	}

	/**
	 * A method to initialize the data input and output streams
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void getStreams() throws IOException {
		input = new DataInputStream(connection.getInputStream());
		output = new DataOutputStream(connection.getOutputStream());
	}

	/**
	 * A method to input the message from the server and then display it to the
	 * console
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void processConnection() throws IOException {
		String line = input.readUTF();
		System.out.println(line);
	}

	/**
	 * A method to close the connection and the input/output streams
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void closeConnection() throws IOException {
		System.out.println("Closing the connection...");
		input.close();
		output.close();
		connection.close();
	}
}
