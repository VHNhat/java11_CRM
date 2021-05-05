package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.ProjectBiz;
import cybersoft.java11.crm.model.Project;
@WebServlet(name = "projectServlet", urlPatterns = {
		"/project"
})
public class ProjectServlet extends HttpServlet{
	private ProjectBiz biz;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new ProjectBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Project>listProject = biz.findAll();
		for (Project project : listProject) {
			resp.getWriter().append(project.toString());
		}
	}
}
