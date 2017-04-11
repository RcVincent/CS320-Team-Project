package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.User;


public class CreateAccountServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CreateAccountServlet: doGet");
		req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CreateAccountServlet: doPost");
		String user = (String) req.getSession().getAttribute("User.username");
		User model = new User();
		Projectcontroller controller = new Projectcontroller();
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}


		int UserNumber = (int) req.getSession().getAttribute("UserID");
		model.setUserID(UserNumber);
		String UserName = (String) req.getSession().getAttribute("username");
		model.setLastName(UserName);
		String Password = (String) req.getSession().getAttribute("password");
		model.setLastName(Password);
		String FirstName = (String) req.getSession().getAttribute("FirstName");
		model.setFirstName(FirstName);
		String LastName = (String) req.getSession().getAttribute("LastName");
		model.setLastName(LastName);
		String Email = (String) req.getSession().getAttribute("Email");
		model.setEmailAddress(Email);
		String isAdmin = (String) req.getSession().getAttribute("Admin");
		model.setEmailAddress(isAdmin);
		
		controller.addUserToDatabase(UserName, Password, Email, isAdmin, FirstName, LastName);
		req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);

	}



}
