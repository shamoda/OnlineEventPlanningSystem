package com.oeps.servlet;
/*
 * This servlet performs approve event
 * 
 * @author S M Jayasekara - IT 19 1616 48
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.model.user;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class approveevent
 */
@WebServlet("/approveevent")
public class approveevent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// retrieving the event id from get method
		int eId = Integer.parseInt(request.getParameter("eventId"));
		
		/*
		 * creating an object from serviceImpl class
		 * calling approveEvent method
		 */
		iService approve = new serviceImpl();
		approve.approveEvent(eId);
		
		//redirecting user to the relevant dashboard 
		response.sendRedirect("admin.jsp?approve=1"); 
		
		
	}

}
