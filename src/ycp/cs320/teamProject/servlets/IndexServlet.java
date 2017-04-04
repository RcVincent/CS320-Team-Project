package ycp.cs320.teamProject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException	{

		System.out.println("In the Index servlet");
		if (req.getParameter("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/account");//"http://localhost:8081/Dhartma9/addNumbers");
		} else if (req.getParameter("createAccount") != null) {
			resp.sendRedirect(req.getContextPath() + "/CreateAcount");//"http://localhost:8081/Dhartma9/multNumbers");
		} else if (req.getParameter("createSOP") != null) {
			resp.sendRedirect(req.getContextPath() + "/createSOP");//"http://localhost:8081/Dhartma9/guessingGame");
		} else if (req.getParameter("mainPage") != null) {
			resp.sendRedirect(req.getContextPath() + "/MainPage");//"http://localhost:8081/Dhartma9/guessingGame");
		} else if (req.getParameter("reviseSOP") != null) {
			resp.sendRedirect(req.getContextPath() + "/reviseSOP");//"http://localhost:8081/Dhartma9/guessingGame");
		} else if (req.getParameter("sop") != null) {
			resp.sendRedirect(req.getContextPath() + "/SOP");//"http://localhost:8081/Dhartma9/guessingGame");
		} else if (req.getParameter("treaingHistory") != null) {
			resp.sendRedirect(req.getContextPath() + "/Traininghistory");//"http://localhost:8081/Dhartma9/guessingGame");
		}
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
}


