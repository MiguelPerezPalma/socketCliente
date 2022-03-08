package proyecto.socketCliente;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import proyecto.socketCliente.model.account;
import proyecto.socketCliente.model.user;
import proyecto.socketCliente.send.ClientSend;
import proyecto.socketCliente.services.socketservice;

public class clientController {
	private static user userconect=new user();
	private static account accountconnect=new account();
	@FXML
	private Label LabWallet;
	@FXML
	private TextField txfdinero;

	@FXML
	protected void initialize() {
		LabWallet.setText(userconect.getWallet()+" €");
	}
	@FXML
	public void ingresar() {
		int dinero = Integer.parseInt(txfdinero.getText()) ;
		ClientSend ingreso=new ClientSend(2, accountconnect);
		try {
			socketservice.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@FXML
	public void retirar() {
		int dinero = Integer.parseInt(txfdinero.getText()) ;
		ClientSend ingreso=new ClientSend(3, accountconnect);
		try {
			socketservice.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LabWallet.setText(userconect.getWallet()+"€");
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
