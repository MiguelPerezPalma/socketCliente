package proyecto.socketCliente;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import proyecto.socketCliente.model.ClientSend;
import proyecto.socketCliente.model.account;
import proyecto.socketCliente.model.user;
import proyecto.socketCliente.services.socketservice;

public class clientController {
	private static user userconect = new user();
	private static account accountconnect = new account();
	@FXML
	private Label LabWallet;
	@FXML
	private TextField txfdinero;

	@FXML
	protected void initialize() {
//		LabWallet.setText(userconect.getWallet() + " €");
	}

	@FXML
	public void ingresar() {
		// obtiene el dinero del input
		int dinero = Integer.parseInt(txfdinero.getText());
		// objeto que le comunicará al servidor la cuenta manipulada y la operación que
		// debe realizar
		ClientSend ingreso = new ClientSend(2, accountconnect);
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
		ClientSend ingreso = new ClientSend(3, accountconnect);
		try {
			// comunicación con el servidor
			socketservice.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		LabWallet.setText(userconect.getWallet() + "€");
	}

	@FXML
	public static void setMiuser(user miuser) {
		userconect = miuser;
	}

	@FXML
	public static void setAccountconnect(account accountconnect) {
		clientController.accountconnect = accountconnect;
	}
}
