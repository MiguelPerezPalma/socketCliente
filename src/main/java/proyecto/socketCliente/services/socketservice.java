package proyecto.socketCliente.services;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class socketservice {
	private static Socket server;

	public static void connectToServer() {
		try {
			server = new Socket("localhost", 2024);
			readServerInputs(server);
		} catch (IOException e) {
			System.out.println("Error, No se consiguio conectar al Server");
		}
	}

    public static Socket getConnectionToServer() {
        return server;
    }
    
    
    public static void readServerInputs(Socket server2) {
		new Thread(() -> {
			System.out.println("Cliente");
			try {
				while (true) {
					listenToServerActions(server2);
				}

			} catch (Exception e) {

				closeServer(server2, true);
			}

		}).start();

	}
    private static void listenToServerActions(Socket server2) {
		
	}
    
    public static void sendDataToServer(Object o) throws IOException {
		if (server != null && !server.isClosed()) {
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(server.getOutputStream());
				objectOutputStream.writeObject(o);
				objectOutputStream.flush();
			} catch (EOFException e) {
				if (objectOutputStream != null)
					objectOutputStream.close();
				throw new SocketException("Desconectado");
			}
		}
	}
    private static void closeServer(Socket server, boolean isFromException) {
		try {
			server.getOutputStream().close();
			server.close();
		} catch (IOException e) {

		}
	}
}
