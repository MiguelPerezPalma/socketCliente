package socket.models;

import java.io.Serializable;

public class account implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected int money;
	protected user user;

	public account(int id, int money, socket.models.user user) {
		super();
		this.id = id;
		this.money = money;
		this.user = user;
	}

	public account(int money, socket.models.user user) {
		super();
		this.money = money;
		this.user = user;
	}

	public account() {
		super();
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

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "account [id=" + id + ", money=" + money + ", user=" + user + "]";
	}

}
