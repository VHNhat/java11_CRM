package cybersoft.java11.crm.model;

import java.sql.Date;

public class Task {
	/* properties */
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date dueDate;
	private User assignee;
	private Project project;
	private Status status;
	
	/* constructors */
	public Task() {
		id = -1;
		name = "";
		description = "";
		startDate = new Date(-1);
		dueDate = new Date(-1);
	}

	public Task(int id, String name, String description, Date startDate, Date dueDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.dueDate = dueDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
