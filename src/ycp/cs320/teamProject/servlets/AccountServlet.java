package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class AccountServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the accouny servlet do get");
		
		//get session information so we can re rout a user or admin back to the login page
		//will help implement a time out in the future 
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("username"));
		if (session.getAttribute("username") == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		
		if(session.getAttribute("type").equals("User")){
			resp.sendRedirect(req.getContextPath() + "/MainPage");
			
		}
		
		//set up the user as a model in the system
		User model = new User();
		//getting necessary account information to display in the model of the app 
		int UserNumber = (int) req.getSession().getAttribute("UserID");
		model.setUserID(UserNumber);
		String FirstName = (String) req.getSession().getAttribute("FirstName");
		model.setFirstName(FirstName);
		String LastName = (String) req.getSession().getAttribute("LastName");
		model.setLastName(LastName);
		String Email = (String) req.getSession().getAttribute("Email");
		model.setEmailAddress(Email);
		



		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("In the account do post");
		
		Projectcontroller controller = new Projectcontroller();
		String userName = req.getParameter("username");
		
		//create the users account as a model with all the necessary parameters
		ArrayList<User> users = controller.getAccountInformation(userName);
		User user = users.get(0);
		
		System.out.println(user.getUsername());
		System.out.println(user.getUserID());
		req.setAttribute("user", user);

		SOP sop = null;
		String errorMessage   = null;
		List<SOP> sops = null;
		System.out.println("In the MainPage servlet do post");
			// get list of sops returned from query
			sops = controller.TrainingHistory(userName);
			sop = sops.get(0);
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("sop",   sop);
		req.setAttribute("sops",  sops);
		
		//set the link back to the index page 
		if (req.getParameter("Index") != null) {
			System.out.println("back to index");
			resp.sendRedirect(req.getContextPath() + "/Index");
		}



		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	}


}
