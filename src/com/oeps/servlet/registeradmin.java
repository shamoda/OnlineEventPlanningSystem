package com.oeps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.model.user;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class registeradmin
 */
@WebServlet("/registeradmin")
public class registeradmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user u2 = new user();
		
		u2.setuId(request.getParameter("uId"));
		u2.setName(request.getParameter("name"));
		u2.setMobile(request.getParameter("mobile"));
		u2.setDesignation(request.getParameter("designation"));
		u2.setEmail(request.getParameter("email"));
		u2.setPassword(request.getParameter("password"));
		
		iService IService = new serviceImpl();	
		boolean status = IService.registerAdmin(u2);
		
		if(status == true) {
			request.setAttribute("registered", "Admin Registration Successful.");
            RequestDispatcher rd = request.getRequestDispatcher("/registeradmin.jsp");
            rd.forward(request, response);
		}
		else {
			request.setAttribute("registrationError", "Something went wrong please try again...");
            RequestDispatcher rd = request.getRequestDispatcher("/registeradmin.jsp");
            rd.forward(request, response);
		}
		
	}

}
