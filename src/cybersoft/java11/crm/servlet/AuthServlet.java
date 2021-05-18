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
			case UrlConstant.AUTH_LOGIN:
				req.getRequestDispatcher(JspPathConst.AUTH_LOGIN).forward(req, resp);
				break;
			case UrlConstant.AUTH_LOGOUT:
				req.getSession().invalidate();
				req.getRequestDispatcher(JspPathConst.AUTH_LOGIN).forward(req, resp);
				break;
			case UrlConstant.AUTH_REGISTER:
				req.getRequestDispatcher(JspPathConst.AUTH_REGISTER).forward(req, resp);
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = req.getServletPath();
		String email, password, fullname;
//		System.out.println(servletPath);
		switch(servletPath) {
			case UrlConstant.AUTH_LOGIN:
				email = req.getParameter("email");
				password = req.getParameter("password");
				
//				System.out.printf("email: %s, password: %s\n", email,password);
				
				User user = biz.login(email, password);
				
				if(user != null) {
					HttpSession session = req.getSession();
					
					session.setAttribute("userId", "" + user.getId());
					session.setAttribute("fullname", user.getFullname());
					
					session.setMaxInactiveInterval(3600);
					resp.sendRedirect(req.getContextPath() + UrlConstant.HOME);
				} else {
					req.setAttribute("msg", "Your email or password is not correct");
					req.getRequestDispatcher(JspPathConst.AUTH_LOGIN).forward(req, resp);
				}
				break;
			case UrlConstant.AUTH_REGISTER:
				fullname = req.getParameter("fullname");
				email = req.getParameter("email");
				password = req.getParameter("password");
				
				if(email.equals("") || email == null || password.equals("") || password == null || fullname.equals("") || fullname == null) {
					req.setAttribute("msg", "name,email and password can not be emty.");
					req.getRequestDispatcher(JspPathConst.AUTH_REGISTER).forward(req, resp);
				} else {
					User newUser = new User();
					newUser.setFullname(fullname);
					newUser.setEmail(email);
					newUser.setPassword(password);
					
					if(biz.checkEmailExisted(newUser)) {
						biz.register(newUser);
						resp.sendRedirect(req.getContextPath() + UrlConstant.AUTH_LOGIN);
					}	else {
						req.setAttribute("msg", "Email has been used!");
						req.getRequestDispatcher(JspPathConst.AUTH_REGISTER).forward(req, resp);
					}
					
				}
				
				
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
