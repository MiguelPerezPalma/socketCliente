package proyecto.socketCliente;

import java.util.ArrayList;
import java.util.List;

import proyecto.socketCliente.model.account;
import proyecto.socketCliente.model.user;

public class CurrentUserController {

	public static user usuario = new user();
	public static account cuenta = new account();
	public static List<user> allUsers = new ArrayList<user>();
	public static List<account> allAccounts = new ArrayList<account>();
}
