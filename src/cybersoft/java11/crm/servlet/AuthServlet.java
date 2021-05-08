package cybersoft.java11.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.AuthBiz;
import cybersoft.java11.crm.model.User;


@WebServlet(name = "authServlet", urlPatterns = {
		"/login",
		"/logout",
		"/register"
})
public class AuthServlet extends HttpServlet {
	private AuthBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new AuthBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: forward to login.jsp
		String path = req.getServletPath();
		
		switch (path) {
		case "/login":
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/auth/login.jsp");
			dispatcher.forward(req, resp);
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: 
		String path = req.getServletPath();
		
		switch (path) {
		case "/login":
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			System.out.printf("email: %s, password: %s\n", email, password);
			
			User user = biz.login(email, password);
			
			if(user != null) { // logged in successfully
				HttpSession session = req.getSession();
				
				session.setAttribute("userId", "" + user.getId());
				session.setMaxInactiveInterval(30);
				
				resp.sendRedirect(req.getContextPath() + "/home");
			} else { // logged in fail
				req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
			}
			
			break;

		default:
			break;
		}
	}
}