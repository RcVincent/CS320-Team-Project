package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class createSOPservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;

	private Projectcontroller controller = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("In the create SOP servlet do get");
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


		req.getRequestDispatcher("/_view/createSOP.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String errorMessage = null;
		String sucessMessage = null;

		String sopName = null;
		String sopPurpose = null;
		String strsopID = null;
		String priority = null;
		String revision = null;
		int sopID = 0;
		System.out.println("getting SOP info from webform");
		sopName = req.getParameter("sopName");
		sopPurpose = req.getParameter("sop_purpose");
		priority = req.getParameter("sop_priority");
		revision = req.getParameter("sop_revision");
		
		System.out.println(sopName);
		System.out.println(sopPurpose);
		System.out.println(priority);
		System.out.println(revision);
/*Trying to get addSOP to work with out the check for fields

		if(sopName == null || sopName.equals("") ||
				sopPurpose == null || sopPurpose.equals("") ||
				priority == null || priority.equals("") ||
				revision == null || revision.equals("") 
				) {
			errorMessage = "Please fill in all the require fields";
		} else {
			*/
			controller = new Projectcontroller();
			//sopID = Integer.parseInt(strsopID);

			controller.addSOPtoDB(sopName, sopPurpose, priority, revision); 
			//sucessMessage = sopName;

			//else {
			//errorMessage = "Failed to insert the new SOP: " + sopName;
			//}


			//req.setAttribute("sop_id", sopID);
			req.setAttribute("sop_name", sopName);
			req.setAttribute("sop_Purpose", sopPurpose);
			req.setAttribute("sop_priority", priority);
			req.setAttribute("sop_revision", revision);


			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("successMessage", sucessMessage);
		//}

			if (req.getParameter("index") != null) {
				resp.sendRedirect(req.getContextPath() + "/Index");
			}
			req.getRequestDispatcher("/_view/createSOP.jsp").forward(req, resp);
		}

	}
