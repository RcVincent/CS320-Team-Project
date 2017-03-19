package ycp.cs320.teamProject.servlets;

import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.model.MileStone1_User;
import ycp.cs320.teamProject.model.User;
//Priority #1
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		String username = null;
		String password = null;
		
		//working for milestone
		MileStone1_User model = new MileStone1_User();
		
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		//Authenticate here/match user with password 
		if(username.equals(model.getUsername()) && password.equals(model.getPassword())){
			resp.sendRedirect(req.getContextPath() + "/MainPage");
			
		}
		//after we changed this to handle the DB, we will add a reference to go to the check electronic
		//signature page. 
		
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
	}

}

