package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.HomeBiz;

@WebServlet(name = "homeServlet", urlPatterns = {
		"/health",
		"/home"
})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HomeBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO: init HomeBiz
		super.init();
		biz = new HomeBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: check database health
		Cookie cookie = new Cookie("username", "tuanphan91");
		cookie.setMaxAge(60*60*24);
		resp.addCookie(cookie);
		
		System.out.println(Calendar.getInstance().getTime().toString());
		Date curTime = Calendar.getInstance().getTime();
		String now = "" + curTime.getHours()
						+ ":" + curTime.getMinutes()
						+ ":" + curTime.getSeconds()
						+ "-" + curTime.getDate()
						+ "/" + curTime.getMonth()
						+ "/" + curTime.getYear();
		Cookie anotherCookie = new Cookie("lastAccess", now);
		anotherCookie.setMaxAge(60*60*24*30);
		resp.addCookie(anotherCookie);
		
		HttpSession currentSession = req.getSession();
		
		System.out.println(currentSession.getAttribute("loggedUser"));
		if (currentSession.getAttribute("loggedUser") == null) {
			// set an attribute to current session
			currentSession.setAttribute("loggedUser", "tuanphan91");
			// set max time to wait for another request from client
			currentSession.setMaxInactiveInterval(20);
		}
		
		boolean databaseCheckResult = biz.checkHealth();
		if(databaseCheckResult)
			resp.getWriter().append("Connection to database has been made successfully.");
		else
			resp.getWriter().append("Connection to database has been made unsuccessfully.");
		
		req.getRequestDispatcher("/WEB-INF/home/index.jsp").forward(req, resp);
	}
}
