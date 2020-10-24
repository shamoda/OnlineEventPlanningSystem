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
 * Servlet implementation class updateprofile
 */
@WebServlet("/updateprofile")
public class updateprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cuId = request.getParameter("cuId");
		
		user u4 = new user();
		
		u4.setuId(request.getParameter("nuId"));
		u4.setName(request.getParameter("name"));
		u4.setMobile(request.getParameter("mobile"));
		u4.setEmail(request.getParameter("email"));
		
		iService updateProfile = new serviceImpl();
		boolean status = updateProfile.updateProfile(u4, cuId);
		
		
		if(status) {
			
			request.setAttribute("updated", "Profile details updated successfully.");
            RequestDispatcher rd = request.getRequestDispatcher("/updateprofile.jsp");
            rd.forward(request, response);
			
		}
		else {
			request.setAttribute("error", "Something went wrong. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("/updateprofile.jsp");
            rd.forward(request, response);
		}
		
		
		
		
	}

}
