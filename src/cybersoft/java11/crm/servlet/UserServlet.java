package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.UserBiz;
import cybersoft.java11.crm.model.User;
@WebServlet(name = "userServlet", urlPatterns = {
		"/user"
})
public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserBiz biz;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new UserBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> listUser = biz.findAll();
		for (User user : listUser) {
			resp.getWriter().append(user.toString());
		}
	}
}
