package cybersoft.java11.crm.biz;

import java.util.List;

import cybersoft.java11.crm.dao.TaskDao;
import cybersoft.java11.crm.model.Task;

public class TaskBiz {
	private TaskDao dao;
	public TaskBiz() {
		// TODO Auto-generated constructor stub
		dao = new TaskDao();
	}
	public List<Task>findAll(){
		return dao.findAll();
	}
}
