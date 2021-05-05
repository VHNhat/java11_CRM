package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.TaskBiz;
import cybersoft.java11.crm.model.Task;
@WebServlet(name ="taskServlet", urlPatterns = {
		"/task"
})
public class TaskServlet extends HttpServlet{
	private TaskBiz biz;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new TaskBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Task> listTask = biz.findAll();
		
		for (Task task : listTask) {
			resp.getWriter().append(task.toString());
		}
	}
}
