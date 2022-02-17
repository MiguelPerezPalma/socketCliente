package proyecto.socketCliente.model;

import java.util.List;

public class account {
	protected int id;
	protected int money;
	protected List<user> users;
	
	
	public account(int id, int money, List<user> users) {
		super();
		this.id = id;
		this.money = money;
		this.users = users;
	}

	public account() {
		super();
	}

	public List<user> getUsers() {
		return users;
	}

	public void setUsers(List<user> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		account other = (account) obj;
		if (id != other.id)
			return false;
		if (money != other.money)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "account [id=" + id + ", money=" + money + ", users=" + users + "]";
	}
	
	
}
