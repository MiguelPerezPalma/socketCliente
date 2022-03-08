package proyecto.socketCliente;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import proyecto.socketCliente.model.user;
import proyecto.socketCliente.send.ClientSend;
import proyecto.socketCliente.services.socketservice;

public class LoginController {

	@FXML
	private TextField txfName;
	@FXML
	private TextField txfPassword;
	private user miuser;
	@FXML
    private void switchToOperator() throws IOException {
        App.setRoot("createuser");
    }
	
	
	@FXML
	public void Login() {

		if(!txfName.getText().toString().isEmpty()&&!txfPassword.getText().toString().isEmpty()) {
			miuser = new user(txfName.getText().toString(),txfPassword.getText().toString(),0);
			ClientSend send=new ClientSend(1,miuser);
			System.out.println("Cambios");
			try {
				socketservice.sendDataToServer(send);
				App.setRoot("client");
				System.out.println("\n"+send);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
        
    
}
