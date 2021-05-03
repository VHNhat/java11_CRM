package cybersoft.java11.crm.model;

public class Project {
	/* properties */
	private int id;
	private String name;
	private String description;
	private String startDate;
	private String dueDate;
	private User user;
	/* constructors */
	public Project() {
		id = -1;
		name = "";
		description = "";
		startDate = "";
		dueDate = "";
		user = null;
	}
	public Project(int id, String name, String description, String startDate, String dueDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.user = null;
	}
	/* getters & setters */
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
	public String getStart_date() {
		return startDate;
	}
	public void setStart_date(String startDate) {
		this.startDate = startDate;
	}
	public String getDue_date() {
		return dueDate;
	}
	public void setDue_date(String dueDate) {
		this.dueDate = dueDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
