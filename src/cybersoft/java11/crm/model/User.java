package cybersoft.java11.crm.model;

public class User {
	/* properties */
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String address;
	private String phone;
	private Role	 role;
	
	/* constructors */
	public User(int id, String email, String password, String fullname, String address, String phone) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.role = null;
	}
	
	public User() {
		this.id = -1;
		this.email = "";
		this.password = "";
		this.fullname = "";
		this.address = "";
		this.phone = "";
		this.role = null;
	}
	
	/* getters/setters */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + id + " " + email + " " + fullname + " " + address + " " + phone;
	}
}
