package cybersoft.java11.crm.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.RoleBiz;
import cybersoft.java11.crm.model.Role;
import cybersoft.java11.crm.utils.JspPathConst;
import cybersoft.java11.crm.utils.UrlConstant;

@WebServlet(name = "roleServlet", urlPatterns = {
		UrlConstant.ROLE_DASHBOARD,
		UrlConstant.ROLE_ADD,
		UrlConstant.ROLE_UPDATE,
		UrlConstant.ROLE_DELETE
})
public class RoleServlet extends HttpServlet {
	private RoleBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO: init RoleBiz
		super.init();
		biz = new RoleBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.ROLE_DASHBOARD:
				List<Role> listRole = biz.findAll();
				
				req.setAttribute("role", listRole.get(1));
//				req.setAttribute("roles", listRole);
				
				req.getRequestDispatcher(JspPathConst.ROLE_DASHBOARD).forward(req, resp);
				break;
			case UrlConstant.ROLE_ADD:
				req.getRequestDispatcher(JspPathConst.ROLE_ADD).forward(req, resp);
				break;
			case UrlConstant.ROLE_UPDATE:
				req.getRequestDispatcher(JspPathConst.ROLE_UPDATE).forward(req, resp);
				break;
			case UrlConstant.ROLE_DELETE:
				String id = req.getParameter("id");
				biz.delete(Integer.parseInt(id));
				resp.sendRedirect(req.getContextPath() + UrlConstant.ROLE_DASHBOARD);
				break;

		default:
			break;
		}
		
		
	}
}

