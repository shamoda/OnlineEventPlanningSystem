package com.oeps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class deletebooking
 */
@WebServlet("/deletebooking")
public class deletebooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bId = request.getParameter("bId");
		
		iService delete = new serviceImpl();
		delete.deleteBooking(bId);
		
		response.sendRedirect("mybookings.jsp?delete=3");
		
		
	}

}
