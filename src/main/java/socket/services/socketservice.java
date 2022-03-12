package socket.services;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import javafx.application.Platform;
import socket.App;
import socket.CurrentUserController;
import socket.models.Send;
import socket.models.account;
import socket.models.user;

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
				e.printStackTrace();
				closeServer(server, true);
			}

		}).start();

	}

	// método con el que el cliente se comunica con el servidor (cliente ->
	// servidor)
	private static void listenToServerActions(Socket server) {
		ObjectInputStream objstream;
		try {
			// flujo de entrada
			objstream = new ObjectInputStream(server.getInputStream());
			try {
				// los datos se asignan a un objeto Send para su manipulación
				Send seleccion = (Send) objstream.readObject();
				user miuser = seleccion.getObj1();
				account miaccount = seleccion.getObj2();

				switch (seleccion.getSelect()) {
				case 1:
					if (miuser.getId() != -1) {
						// inicio de sesión
						// se obtiene el cliente junto a su cuenta
						miuser = seleccion.getObj1();
						CurrentUserController.usuario = miuser;
						miaccount = seleccion.getObj2();
						CurrentUserController.cuenta = miaccount;
						Platform.runLater(() -> {
							try {
								App.setRoot("client");
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
					} else {
						System.out.println("No se pudo iniciar sesión");
					}
					break;

				// ingresar y retirar
				case 2:
					// se actualiza la cuenta que se está usando
					miaccount = seleccion.getObj2();
					CurrentUserController.cuenta = miaccount;
					break;
					
				// registrarse
				case 4:
					
					miuser = seleccion.getObj1();
					miaccount = seleccion.getObj2();
					
					CurrentUserController.usuario = miuser;
					CurrentUserController.cuenta = miaccount;
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
	public static void sendDataToServer(Send o) throws IOException {
		if (server != null && !server.isClosed()) {

			// flujo de salida
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(server.getOutputStream());
				objectOutputStream.writeObject(o);
			} catch (EOFException e) {
				if (objectOutputStream != null)
					objectOutputStream.close();
				throw new SocketException("Desconectado del servidor");
			}
		}
	}

	private static void closeServer(Socket server, boolean isFromException) {
		try {
			server.getOutputStream().close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
