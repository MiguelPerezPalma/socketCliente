package proyecto.socketCliente;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import proyecto.socketCliente.model.ClientSend;
import proyecto.socketCliente.model.user;
import proyecto.socketCliente.services.socketservice;

public class LoginController {

	@FXML
	private TextField txfName;
	@FXML
	private TextField txfPassword;

	@FXML
	private void switchToOperator() throws IOException {
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
			ClientSend paquete = new ClientSend(1, miuser);
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
