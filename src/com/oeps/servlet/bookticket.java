package com.oeps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oeps.model.bookings;
import com.oeps.service.iService;
import com.oeps.service.serviceImpl;

/**
 * Servlet implementation class bookticket
 */
@WebServlet("/bookticket")
public class bookticket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);  
		
		String uId1 = (String)session.getAttribute("userId");
		int price = Integer.parseInt(request.getParameter("price"));
		String eId = request.getParameter("eventId");
		String pack = request.getParameter("package");
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		int finalPrice = 0;
		
		if(pack.equals("1")) {
			finalPrice = price;
		}
		if(pack.equals("2")) {
			finalPrice = price + 1000;
		}
		if(pack.equals("3")) {
			finalPrice = price + 2000;
		}
		
		int cost = finalPrice * qty;
		
		
		bookings b1 = new bookings();
		
		b1.setCost(cost);
		b1.seteId(eId);
		b1.setQty(qty);
		b1.setuId(uId1);
		
		iService IService = new serviceImpl();
		IService.bookTicket(b1);
		
		
		response.sendRedirect("payment.jsp?cost="+cost+"");
		
		
		
		
		
	}

}
