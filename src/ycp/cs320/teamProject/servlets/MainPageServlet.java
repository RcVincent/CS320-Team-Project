package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.model.MileStone1_User;


//Priority  # 2
public class MainPageServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/MainPage.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MileStone1_User model = new MileStone1_User();
		
		
		

		req.getRequestDispatcher("/_view/MainPage.jsp").forward(req, resp);
	
		}
		
		
		
		
	
}
