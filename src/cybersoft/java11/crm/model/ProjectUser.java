package cybersoft.java11.crm.model;

public class ProjectUser {
	/* properties */
	private String joinDate;
	private String roleDescription;
	private Project project;
	private User user;
	/* constructors */
	public ProjectUser(String joinDate, String roleDescription) {
		this.joinDate = joinDate;
		this.roleDescription = roleDescription;
		this.project = null;
		this.user = null;
	}
	public ProjectUser() {
		joinDate = "";
		roleDescription = "";
		project = null;
		user = null;
	}
	/* getters & setters */
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
