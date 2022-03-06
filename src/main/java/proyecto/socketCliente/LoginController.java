package proyecto.socketCliente;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import proyecto.socketCliente.model.user;

public class LoginController {

	@FXML
	private TextField txfName;
	@FXML
	private TextField txfPassword;
	
	@FXML
    private void switchToOperator() throws IOException {
        App.setRoot("operator");
    }
	
	
	@FXML
    private void login() throws IOException {
	
	}
        
    
}
