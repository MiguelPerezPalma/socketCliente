package socket;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import socket.models.Send;
import socket.models.account;
import socket.models.user;
import socket.services.socketservice;

public class clientController {
	@FXML
	private Label LabWallet;
	@FXML
	private TextField txfdinero;

	@FXML
	protected void initialize() {
		LabWallet.setText(CurrentUserController.cuenta.getMoney() + "€");
	}

	@FXML
	public void ingresar() {
		// obtiene el dinero del input
		int dinero = Integer.parseInt(txfdinero.getText());
		// objeto que le comunicará al servidor la cuenta manipulada y la operación que
		// debe realizar
		Send ingreso = new Send(2, CurrentUserController.usuario, CurrentUserController.cuenta);
		try {
			// comunicación con el servidor
			socketservice.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void retirar() {
		// obtiene el dinero del input
		int dinero = Integer.parseInt(txfdinero.getText());
		// objeto que le comunicará al servidor la cuenta manipulada y la operación que
		// debe realizar
		Send retirada = new Send(3, CurrentUserController.usuario, CurrentUserController.cuenta);
		try {
			// comunicación con el servidor
			socketservice.sendDataToServer(retirada);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
