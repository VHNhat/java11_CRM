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
import cybersoft.java11.crm.utils.JspPathConst;
import cybersoft.java11.crm.utils.UrlConstant;
@WebServlet(name = "userServlet", urlPatterns = {
		UrlConstant.USER_DASHBOARD,
		UrlConstant.USER_ADD,
		UrlConstant.USER_DELETE,
		UrlConstant.USER_UPDATE
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
		String path = req.getServletPath();
		switch(path) {
			case UrlConstant.USER_DASHBOARD:
				List<User> listUser = biz.findAll();
				for(int i = 0;i < listUser.size();i++) {
					System.out.println(listUser.get(i));
				}
				
				req.setAttribute("users", listUser);
				
				
				req.getRequestDispatcher(JspPathConst.USER_DASDBOARD).forward(req, resp);
				break;
			case UrlConstant.USER_ADD:
				
				req.getRequestDispatcher(JspPathConst.USER_ADD).forward(req, resp);
				break;
			case UrlConstant.USER_UPDATE:
				
				req.getRequestDispatcher(JspPathConst.USER_UPDATE).forward(req, resp);
				break;
			case UrlConstant.USER_DELETE:
				
				break;
			case UrlConstant.USER_PROFILE:
				
				break;
			
			default:
				break;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch(path) {
			case UrlConstant.USER_DASHBOARD:
				
				break;
			case UrlConstant.USER_ADD:
				
				break;
			case UrlConstant.USER_UPDATE:
				
				break;
			case UrlConstant.USER_DELETE:
				
				break;
			case UrlConstant.USER_PROFILE:
				
				break;
			
			default:
				break;
		}
	}
}
