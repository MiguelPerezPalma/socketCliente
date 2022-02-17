package proyecto.socketCliente.model;

public class user {
	protected int id;
	protected String name;
	protected String password;
	protected int wallet;
	protected account miaccount;
	

	public user(int id, String name, String password, int wallet, account miaccount) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.wallet = wallet;
		this.miaccount = miaccount;
	}

	public user() {
		super();
	}

	public account getMiaccount() {
		return miaccount;
	}

	public void setMiaccount(account miaccount) {
		this.miaccount = miaccount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		if (id != other.id)
			return false;
		if (miaccount == null) {
			if (other.miaccount != null)
				return false;
		} else if (!miaccount.equals(other.miaccount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (wallet != other.wallet)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", password=" + password + ", wallet=" + wallet + ", miaccount="
				+ miaccount + "]";
	}

}

