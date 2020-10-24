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
 * Servlet implementation class deletepayment
 */
@WebServlet("/deletepayment")
public class deletepayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("pId");
		
		iService delete = new serviceImpl();
		delete.deletePayment(pId);
		
		response.sendRedirect("mypayments.jsp?delete=3");
		
		
	}

}
