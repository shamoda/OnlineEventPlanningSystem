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
 * Servlet implementation class changepassword
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uId = request.getParameter("uId");
		String cpwd = request.getParameter("cpwd");
		String npwd = request.getParameter("npwd");
		
		user u3 = new user();
		u3.setuId(uId);
		u3.setPassword(cpwd);
		
		iService changePwd = new serviceImpl();
		boolean status = changePwd.changePassword(u3, npwd);
		
		if(status) {
			
			request.setAttribute("changed", "Password changed successfully.");
            RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
            rd.forward(request, response);
			
		}
		else {
			request.setAttribute("error", "The currunt passowrd you enterd is wrong. Please try again");
            RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
            rd.forward(request, response);
		}
		
		
		
		
	}

}
