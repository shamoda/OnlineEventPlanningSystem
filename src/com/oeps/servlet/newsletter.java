package com.oeps.servlet;
/*
 * This servlet performs inserting data into newsletter
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

import com.oeps.model.newsLetter;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class newsletter
 */
@WebServlet("/newsletter")
public class newsletter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating newsletter object
		newsLetter n1 = new newsLetter();
		
		//retrieving email address from get method
		n1.setEmail(request.getParameter("email"));
		
		/*
		 * creating an object from serviceImpl class
		 * calling newsLetter method
		 */
		iService newsletter = new serviceImpl();
		newsletter.newsletter(n1);
		
		//redirecting user to home page with a notification
		request.setAttribute("newsletter", "Thanks for subscribing Eventura.");
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
		
		
	}

}
