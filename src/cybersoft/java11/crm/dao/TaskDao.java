package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Project;
import cybersoft.java11.crm.model.Status;
import cybersoft.java11.crm.model.Task;
import cybersoft.java11.crm.model.User;

public class TaskDao {
	public List<Task> findAll(){
		List<Task> listTask = new LinkedList<Task>();
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "select id, name, description, startDate, dueDate, assignee, project_id, status_id";
			
			ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				Task newTask = new Task();
				newTask.setId(results.getInt("id"));
				newTask.setName(results.getString("name"));
				newTask.setDescription(results.getString("description"));
				newTask.setStart_date(results.getDate("start_date"));
				newTask.setDue_date(results.getDate("due_date"));
				newTask.setAssignee(results.getObject("assignee", User.class));
				newTask.setProject(results.getObject("project_id", Project.class));
				newTask.setStatus(results.getObject("status_id", Status.class));
				listTask.add(newTask);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listTask;
	}
}
