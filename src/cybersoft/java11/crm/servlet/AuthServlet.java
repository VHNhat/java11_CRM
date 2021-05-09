package cybersoft.java11.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.AuthBiz;
import cybersoft.java11.crm.model.User;
import cybersoft.java11.crm.utils.JspPathConst;
import cybersoft.java11.crm.utils.UrlConstant;


@WebServlet(name = "authServlet", urlPatterns = {
			UrlConstant.AUTH_LOGIN,
			UrlConstant.AUTH_LOGOUT,
			UrlConstant.AUTH_FORGOT_PASSWORD,
			UrlConstant.AUTH_REGISTER
})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthBiz biz;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = req.getServletPath();
//		System.out.println(servletPath);
		switch(servletPath) {
			case "/login":
				req.getRequestDispatcher(JspPathConst.AUTH_LOGIN).forward(req, resp);
				break;
			case UrlConstant.AUTH_LOGOUT:
				req.getSession().invalidate();
				req.getRequestDispatcher(JspPathConst.AUTH_LOGIN).forward(req, resp);
				break;
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = req.getServletPath();
//		System.out.println(servletPath);
		switch(servletPath) {
			case "/login":
				String email = req.getParameter("email");
				String password = req.getParameter("password");
				
				System.out.printf("email: %s, password: %s\n", email,password);
				
				User user = biz.login(email, password);
				
				if(user != null) {
					HttpSession session = req.getSession();
					
					session.setAttribute("userId", "" + user.getId());
					session.setAttribute("fullname", user.getFullname());
					
					session.setMaxInactiveInterval(3600);
					resp.sendRedirect(req.getContextPath() + "/home");
				} else {
					req.getRequestDispatcher("WEB-INF/auth/login.jsp").forward(req, resp);
				}
				break;
				
			default:
				break;
		}
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		biz = new AuthBiz();
	}
	
	
	
	

}
