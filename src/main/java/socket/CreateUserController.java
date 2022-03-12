package socket;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import socket.models.Send;
import socket.models.account;
import socket.models.user;
import socket.services.socketservice;

public class CreateUserController {

	@FXML
	private TextField txfName;
	@FXML
	private TextField txfPassword;

	
	public void signup() {
		// comprobaciones para evitar que introduzcan valores vacíos
		if (!txfName.getText().toString().isEmpty() && !txfPassword.getText().toString().isEmpty()) {
			
			// creamos nuevo usuario con los datos facilitados por el cliente
			user usuario = new user(txfName.getText(), txfPassword.getText());
			account cuenta = new account(0, usuario);

			// paquete que se enviará al servidor
			Send paquete = new Send(4, usuario, cuenta);
			try {
				//envío
				socketservice.sendDataToServer(paquete);
				App.setRoot("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
