package com.oeps.servlet;
/*
 * This servlet update event
 * 
 * @author S M Jayasekara - IT 19 1616 48
 */


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.model.event;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class updateevent
 */
@WebServlet("/updateevent")
public class updateevent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating new event object
		event e2 = new event();
		
		/*
		 * retrieving details from the get method
		 * setting values to the created event object
		 */
		e2.seteId(request.getParameter("eId"));
		e2.setTitle(request.getParameter("title"));
		e2.setDate(request.getParameter("date"));
		e2.setTime(request.getParameter("time"));
		e2.setTheme(request.getParameter("theme"));
		e2.setVenue(request.getParameter("venue"));
		e2.setEpackage(request.getParameter("package"));
		e2.setFoods(request.getParameter("foods"));
		e2.setLiquor(request.getParameter("liquor"));
		e2.setSounds(request.getParameter("sounds"));
		e2.setParticipants(request.getParameter("participants"));
		e2.setBudget(request.getParameter("budget"));
		e2.setEntrance(request.getParameter("entrance"));
		
		
		/*
		 * creating an object from serviceImpl class
		 * calling updateEvent method
		 */
		iService updateEvent = new serviceImpl();
		updateEvent.updateEvent(e2);
		
		//redirecting user to the relevant dashboard  with a notification.
		request.setAttribute("updated", "Event Details Updated Successfully.");
        RequestDispatcher rd = request.getRequestDispatcher("/myevents.jsp");
        rd.forward(request, response);
		
		
	}

}
