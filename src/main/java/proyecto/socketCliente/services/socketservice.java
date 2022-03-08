package proyecto.socketCliente.services;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import proyecto.socketCliente.clientController;
import proyecto.socketCliente.model.account;
import proyecto.socketCliente.model.user;
import proyecto.socketCliente.send.ClientSend;

public class socketservice {
	private static Socket server;

	// método que realiza la conexión con el servidor, en este caso en localhost y
	// puerto 2024
	public static void connectToServer() {
		try {
			server = new Socket("localhost", 2024);
			readServerInputs(server);
		} catch (IOException e) {
			System.out.println("Error, No se consiguio conectar al Server");
		}
	}

	// método que mantiene al cliente a la escucha del servidor
	public static void readServerInputs(Socket server) {
		new Thread(() -> {
			try {
				while (true) {
					listenToServerActions(server);
				}

			} catch (Exception e) {

				closeServer(server, true);
			}

		}).start();

	}

	// método con el queel cliente se comunica con el servidor (cliente -> servidor)
	private static void listenToServerActions(Socket server) {
		try {
			// flujo de entrada
			ObjectInputStream objstream = new ObjectInputStream(server.getInputStream());
			try {
				// los datos se asignan a un objeto ClientSend para su manipulación
				ClientSend seleccion = (ClientSend) objstream.readObject();
				user miuser;
				account miaccount;

				switch (seleccion.getSelect()) {
				case 1:
					// inicio de sesión
					// se obtiene el cliente junto a su cuenta
					miuser = (user) seleccion.getObj1();
					miaccount = (account) seleccion.getObj2();

					clientController.setMiuser(miuser);
					clientController.setAccountconnect(miaccount);

					break;

				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// método que pasa un objeto al servidor
	public static void sendDataToServer(Object o) throws IOException {
		if (server != null && !server.isClosed()) {

			// flujo de salida
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
