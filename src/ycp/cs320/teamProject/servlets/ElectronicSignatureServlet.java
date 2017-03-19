package ycp.cs320.teamProject.servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class ElectronicSignatureServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/ElectronicSignature.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User();
		
		if(user.isElectronicSignatureFlag() == true) {
			req.getRequestDispatcher("");
		}
		else {
			//pull the SOP 
			//need to add a method for that 
		}
	}
}
