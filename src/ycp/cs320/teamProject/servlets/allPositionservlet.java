package ycp.cs320.teamProject.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.Position;




public class allPositionservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("In the allPosition servlet do get");
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
		req.getRequestDispatcher("/_view/allposition.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Position position = null;
		String errorMessage   = null;
		List<Position> positions = null;
		System.out.println("In the allPosition servlet do post");
		
		
			Projectcontroller controller = new Projectcontroller();

			// get list of books returned from query
			positions = controller.findAllPositions();

		
		
				position = positions.get(0);
				System.out.println(position.getPositionIdS());
				System.out.println(position.getPositionName());
				System.out.println(position.getPositionDuty());
			
		


		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("position",   position);
		req.setAttribute("positions",  positions);
		req.getRequestDispatcher("/_view/position.jsp").forward(req, resp);

	}



}
