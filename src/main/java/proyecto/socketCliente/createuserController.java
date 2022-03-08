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
		
		if(!txfname.getText().toString().isEmpty()&&!txfpassword.getText().toString().isEmpty()) {
			user miuser = new user(txfname.getText().toString(),txfpassword.getText().toString(),0);
			account miaccount= new account(0, miuser);
			ClientSend send=new ClientSend(6,miuser,miaccount);
			System.out.println("Cambios");
			try {
				socketservice.sendDataToServer(send);
				App.setRoot("operator");
				System.out.println("\n"+send);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
