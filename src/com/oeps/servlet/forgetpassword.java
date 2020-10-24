package com.oeps.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.util.connectionUtil;

/**
 * Servlet implementation class forgetpassword
 */
@WebServlet("/forgetpassword")
public class forgetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emoblie = request.getParameter("mobile");
		String eemail = request.getParameter("email");
		
		try {
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "select * from user where mobile = '"+emoblie+"' AND email = '"+eemail+"'";
		
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				request.setAttribute("success", "Your User ID : "+rs.getString("uId")+" <br> Your Password : "+rs.getString("password")+" ");
	            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
	            rd.forward(request, response);
				
			}else {
				
				request.setAttribute("failed", "Somethings wrong. Please Double Check the Mobile Number and Email.");
	            RequestDispatcher rd = request.getRequestDispatcher("/forgetpassword.jsp");
	            rd.forward(request, response);
				
			}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
