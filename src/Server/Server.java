package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A class to represent the TCP server
 * 
 * @author Daniel Falcone
 *
 */
public class Server {
	private int serverPort;
	private ServerSocket server;
	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;

	/**
	 * Server constructor that initializes the server port number
	 */
	public Server() {
		serverPort = 1254;
	}

	/**
	 * A method to run the server methods and close the connection
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	public void runServer() throws IOException {
		try {
			server = new ServerSocket(serverPort, 10);

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
	 * A method to accept the connection from the client
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void waitForConnection() throws IOException {
		System.out.println("Waiting for connection");
		connection = server.accept();
		System.out.println("Connection received from " + connection.getInetAddress().getHostAddress());
	}

	/**
	 * A method to initialize the input and output streams
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void getStreams() throws IOException {
		input = new DataInputStream(connection.getInputStream());
		output = new DataOutputStream(connection.getOutputStream());
	}

	/**
	 * A method to send a message to the client
	 * 
	 * @throws IOException if there is an issue with the physical network medium
	 */
	private void processConnection() throws IOException {
		output.writeUTF("**** Hello from the server! ****");
		output.flush();
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
