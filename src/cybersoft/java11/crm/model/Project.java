package cybersoft.java11.crm.model;

import java.sql.Date;

public class Project {
	/* properties */
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private User user;
	/* constructors */
	public Project() {
		id = -1;
		name = "";
		description = "";
		startDate = null;
		endDate = null;
		user = null;
	}
	public Project(int id, String name, String description, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public Date getStart_date() {
		return startDate;
	}
	public void setStart_date(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEnd_date() {
		return endDate;
	}
	public void setEnd_date(Date endDate) {
		this.endDate = endDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
