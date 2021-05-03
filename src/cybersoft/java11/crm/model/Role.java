package cybersoft.java11.crm.model;

public class Role {
	/* properties */
	private int id;
	private String name;
	private String description;
	
	/* constructors */
	public Role(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Role() {
		this.id = -1;
		this.name = "";
		this.description = "";
	}

	/* getters/setters */
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/* methods */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + id + " " + name + " " + description + "\n";
	}
}
