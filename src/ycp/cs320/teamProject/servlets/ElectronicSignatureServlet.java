package ycp.cs320.teamProject.servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class ElectronicSignatureServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//get session information so we can re rout a user or admin back to the login page
		//will help implement a time out in the future 
		HttpSession session = req.getSession();
			System.out.println(session.getAttribute("username"));
			if (session.getAttribute("username") == null) {
				// user is not logged in, or the session expired
				resp.sendRedirect(req.getContextPath() + "/Login");
				return;
			}
				
		req.getRequestDispatcher("/_view/ElectronicSignature.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User();
		
		//leaving space here to add session data if we need it 
		if(user.isElectronicSignatureFlag() == true) {
			resp.sendRedirect(req.getContextPath() + "/MainPage");
		}
		else {
			req.getRequestDispatcher("/_view/ElectronicSignature.jsp").forward(req, resp);
			//set the electronic signature flag in the user class to true 
			user.setElectronicSignatureFlag(true);
			//after the flag is set to true
			resp.sendRedirect(req.getContextPath() + "/MainPage");
		}
	}
}
