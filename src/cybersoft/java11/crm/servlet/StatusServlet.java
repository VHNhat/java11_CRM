package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.StatusBiz;
import cybersoft.java11.crm.model.Status;
@WebServlet(name = "statusServlet", urlPatterns = {
		"/status"
})
public class StatusServlet extends HttpServlet{
	private StatusBiz biz;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new StatusBiz();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Status> listStatus = biz.findAll();
		for (Status status : listStatus) {
			resp.getWriter().append(status.toString());
		}
	}
}
