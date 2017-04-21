package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.User;


public class changePasswordServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/changePassword.jsp").forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		req.getRequestDispatcher("/_view/changePassword.jsp").forward(req, resp);
		String user = (String) req.getSession().getAttribute("User.username");

		Projectcontroller controller = new Projectcontroller();
		//session data 
		User model = new User();
		String session = getSession(req, "seesionid");
		model.setSessionid(session);
		if (model.getSessionid()== null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}
		String name = (String)req.getSession().getAttribute("user");
		String oldPassword = (String) req.getSession().getAttribute("oldPassword");
		String password = (String) req.getSession().getAttribute("password");
		String password2 = (String) req.getSession().getAttribute("password2");
		if (password != password2){
			//Passwords don't match
			resp.sendRedirect(req.getContextPath()+ "/retrychangePassword");
		}else if(password ==password2){
		controller.changeUserPassword(name, oldPassword, password);
		model.setPassword(password);
		}
				
		req.setAttribute("sessionid", model);
		
		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}
		
		req.getRequestDispatcher("/_view/changePassword.jsp").forward(req, resp);

	}

		private String getSession(HttpServletRequest req, String name) {
			// TODO Auto-generated method stub
			return String.valueOf(req.getParameter(name));
		}


}
