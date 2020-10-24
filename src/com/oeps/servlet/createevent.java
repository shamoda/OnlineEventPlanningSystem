package com.oeps.servlet;
/**
 * 
 * This servlet perform creating a new event.
 * 
 * @author S M Jayasekara - IT 19 1616 48
 *
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oeps.model.event;
import com.oeps.model.user;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

import java.util.*;

/**
 * Servlet implementation class createevent
 */
@WebServlet("/createevent")
public class createevent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//retrieving user ID from the session
		HttpSession session=request.getSession(false);  
		
		String userType = (String)session.getAttribute("type");
		String uId1 = (String)session.getAttribute("userId");
		
		//creating an event object
		event e1 = new event();
		
		/*
		 * retrieving details from the get method
		 * setting values to the created event object
		 */
		e1.setuId(uId1);
		e1.setTitle(request.getParameter("title"));
		e1.setDate(request.getParameter("date"));
		e1.setTime(request.getParameter("time"));
		e1.setVenue(request.getParameter("venue"));
		e1.setTheme(request.getParameter("theme"));
		e1.setEpackage(request.getParameter("package"));
		e1.setSummary(request.getParameter("summary"));
		e1.setFoods(request.getParameter("foods"));
		e1.setLiquor(request.getParameter("liquor"));
		e1.setSounds(request.getParameter("sounds"));
		e1.setParticipants(request.getParameter("participants"));
		e1.setBudget(request.getParameter("budget"));
		e1.setEntrance(request.getParameter("entrance"));
		e1.setAdditional(request.getParameter("additional"));
		e1.setTags(request.getParameter("tags"));
		
		
		/*
		 * calling the createEvent method declared in iService interface.
		 */
		
		iService IService = new serviceImpl();
		boolean status = IService.createEvent(e1);
		
		/*
		 * Redirecting user to the relevant user interface
		 */
		
		if(status == true) {
			request.setAttribute("creationSuccess", "Event created successfully. Admins will review your application. You can check the status in My Events page.");
            RequestDispatcher rd = request.getRequestDispatcher("/createevent.jsp");
            rd.forward(request, response);
		}
		else {
			request.setAttribute("creationError", "Something went wrong please try again...");
            RequestDispatcher rd = request.getRequestDispatcher("/createevent.jsp");
            rd.forward(request, response);
		}		
		
	}

}
