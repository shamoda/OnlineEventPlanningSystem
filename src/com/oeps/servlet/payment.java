package com.oeps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oeps.model.payments;
import com.oeps.model.user;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);  
		
		String uId = (String)session.getAttribute("userId");
		String cardNo = request.getParameter("cardNo");
		String ccv = request.getParameter("ccv");
		String cardType = request.getParameter("cardType");
		String cost = request.getParameter("cost");
		
		payments p1 = new payments();
		
		p1.setCardNo(cardNo);
		p1.setCardType(cardType);
		p1.setCcv(ccv);
		p1.setCost(cost);
		p1.setuId(uId);
		
		iService pay = new serviceImpl();
		pay.makePayment(p1);
		
		request.setAttribute("paid", "You reserved your ticket successfully. Thank you for being with us.");
        RequestDispatcher rd = request.getRequestDispatcher("/customer.jsp");
        rd.forward(request, response);
		
		
		
	}

}
