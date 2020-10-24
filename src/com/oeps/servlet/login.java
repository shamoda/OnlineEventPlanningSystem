package com.oeps.servlet;
/**
 * 
 * This servlet performs the login validation logics
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

import com.oeps.model.*;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//retrieving login form data and assign them to variables 
		String id = request.getParameter("uId");
		String pwd = request.getParameter("password");
		
		try {
			
			/*
			 * calling the login method declared in iService interface.
			 */
			iService IService = new serviceImpl();
			user u1 = IService.login(id, pwd);
			
			if(u1.getuId() != null) {
				
				/*
				 * starting session for the logged user
				 */
				HttpSession session = request.getSession();
				session.setAttribute("userId", u1.getuId());
				session.setAttribute("username", u1.getName());
				session.setAttribute("designation", u1.getDesignation());
				session.setAttribute("type", u1.getType());
				session.setAttribute("password", u1.getPassword());
				
				String type = u1.getType();
			
				/*
				 * Redirecting validated user to the relevant user interface
				 */
				if(type.equals("0")) {
					response.sendRedirect("customer.jsp");
				}
				else {
					response.sendRedirect("admin.jsp");
				}
			
		}
		else {
			
			/*
			 * Redirecting invalid user to the login page
			 */
			request.setAttribute("errorMessage", "Invalid user id or password");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
