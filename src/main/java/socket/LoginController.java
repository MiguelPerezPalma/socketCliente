package socket;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import socket.models.Send;
import socket.models.user;
import socket.services.socketservice;

public class LoginController {

	@FXML
	private TextField txfName;
	@FXML
	private TextField txfPassword;

	@FXML
	private void switchToSignUp() throws IOException {
		App.setRoot("createuser");
	}

	@FXML
	public void login() {
		// comprobaciones para procurar que se introducen valores correctos
		if (!txfName.getText().toString().isEmpty() && !txfPassword.getText().toString().isEmpty()) {

			// se asignan los valores a un usuario, para pasarlos al servidor y compruebe
			// las credenciales
			user miuser = new user(txfName.getText().toString(), txfPassword.getText().toString());

			// objeto que le comunicará al servidor la cuenta manipulada y la operación que
			// debe realizar
			Send paquete = new Send(1, miuser);
			try {
				// comunicación con el servidor
				socketservice.sendDataToServer(paquete);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
