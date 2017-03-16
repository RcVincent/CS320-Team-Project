package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ycp.cs320.teamProject.model.User;


public class retrychangePassword extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("User.username");
		User model = new User();
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}
		String password = (String) req.getSession().getAttribute("password");
		String password2 = (String) req.getSession().getAttribute("password2");
		if (password != password2){
			//Passwords don't match
			resp.sendRedirect(req.getContextPath()+ "/retrychangePassword");
		}
		model.setPassword(password);

		
		
		req.getRequestDispatcher("/_view/retrychangePassword.jsp").forward(req, resp);

	}



}
