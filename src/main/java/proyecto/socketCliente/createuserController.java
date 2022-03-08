package proyecto.socketCliente;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import proyecto.socketCliente.model.account;
import proyecto.socketCliente.model.user;
import proyecto.socketCliente.send.ClientSend;
import proyecto.socketCliente.services.socketservice;

public class createuserController {

	@FXML
	private TextField txfname;
	@FXML
	private TextField txfpassword;

	@FXML
	private void Resgistro() {
		// comprobaciones para procurar que se introducen valores correctos
		if (!txfname.getText().toString().isEmpty() && !txfpassword.getText().toString().isEmpty()) {
			// se crea un nuevo usuario con los datos facilitados
			user miuser = new user(txfname.getText().toString(), txfpassword.getText().toString(), 0);
			// nueva cuenta creada por defecto junto al usuario
			account miaccount = new account(0, miuser);
			// objeto que le comunicará al servidor la cuenta manipulada y la operación que
			// debe realizar
			ClientSend send = new ClientSend(6, miuser, miaccount);
			try {
				// comunicación con el servidor
				socketservice.sendDataToServer(send);
				App.setRoot("operator");
				System.out.println("\n" + send);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
