<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.oeps.util.*"%>
<%@page import="java.lang.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Eventura - Reserve Ticket</title>
<link rel="stylesheet" type="text/css" href="styles/bookticket.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<!-----------------------Check login status---------------------->
	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("userId") == null){
			response.sendRedirect("login.jsp");
		}
	
	%>

	<!-----------------------header section---------------------->

	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-brand" href="index.jsp"><img src="img/logo.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item "><a class="nav-link" href="index.jsp#top">HOME</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="index.jsp#services">SERVICES</a></li>
					<li class="nav-item"><a class="nav-link"
						href="index.jsp#about-us">ABOUT US</a></li>
					<li class="nav-item"><a class="nav-link"
						href="index.jsp#testimonials">TESTIMONIALS</a></li>
					<li class="nav-item"><a class="nav-link"
						href="index.jsp#footer">CONTACT</a></li>
					<li class="nav-item"><a class="nav-link" href="customer.jsp">MY
							DASHBOARD</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">LOG
							OUT</a></li>
				</ul>
			</div>
		</nav>
	</section>


	<!-----------------------customer dashboard section---------------------->

	<section id="customer">
		<div class="container">
			<div class="row">
				<div class="col-md-9">



					<!-----------------------ticket booking section---------------------->

					<%
						try {
						int eId = Integer.parseInt(request.getParameter("eventId"));

						Connection connection = connectionUtil.getConnection();
						Statement stmt = connection.createStatement();
						ResultSet rs = stmt.executeQuery("select * from event where eId = '" + eId + "' ");
						rs.next();
					%>



					<div class="bookticket">

						<div class="create-event">
							<h4>Reserve Ticket :</h4>
							<div class="details">
								<h3><%=rs.getString("title")%></h3>
								<p>
									Date :
									<%=rs.getString("date")%>
									<br> Venue :
									<%=rs.getString("venue")%>
									<br>
									<%=rs.getString("time")%>
									on wards
								</p>
								<p><%=rs.getString("summary")%></p>
								<br>
							</div>

							<form action="bookticket">
								<div class="row">

									<input type="hidden" name="eventId"
										value="<%=rs.getString("eId")%>"> <input
										type="hidden" name="price"
										value="<%=rs.getString("entrance")%>">

									<div class="input1 col-md-4">Ticket Price :</div>
									<div class="input2 col-md-8">
										<input type="text" name="price"
											value="<%String price = rs.getString("entrance");
													if (price.equals("0")) {
														out.print("Free");
													}
													if (price.equals("1000")) {
														out.print("1000/= LKR");
													}
													if (price.equals("1500")) {
														out.print("1500/= LKR");
													}
													if (price.equals("2000")) {
														out.print("2000/= LKR");
													}
													if (price.equals("2500")) {
														out.print("2500/= LKR");
													}
													if (price.equals("3000")) {
														out.print("3000/= LKR");
													}%>"
											readonly> <br>
										<br>
									</div>
								</div>



								<div class="row">
									<div class="input1 col-md-4">Package :</div>
									<div class="input2 col-md-8">
										<select name="package">
											<option value="1">Standard Package</option>
											<option value="2">Premium Package (+1000 LKR)</option>
											<option value="3">VIP Package (+2000 LKR)</option>
										</select><br>
										<br>
									</div>
								</div>


								<div class="row">
									<div class="input1 col-md-4">Number of Tickets :</div>
									<div class="input2 col-md-8">
										<input type="text" name="qty" placeholder="Number of Tickets"
											required> <br>
										<br>
									</div>
								</div>


								<div class="row">
									<div class="input1 col-md-4">
										<!-- left side of submit button-->
									</div>
									<div class="input2 col-md-8">
										<input type="submit" name="submit" value="Next">
									</div>
								</div>
							</form>
						</div>

						<%
							} catch (Exception e) {
							e.printStackTrace();
						}
						%>

					</div>


					<!-----------------------sidebar section---------------------->


				</div>
				<div class="col-md-3">
					<form class="sidebar side">
						<a href="createevent.jsp" class="btn btn-primary">Create New
							Event</a><br>
						<br> <a href="myevents.jsp" class="btn btn-primary">My
							Events</a><br>
						<br> <a href="mybookings.jsp" class="btn btn-primary">My
							Bookings</a><br>
						<br> <a href="mypayments.jsp" class="btn btn-primary">My
							Payments</a><br>
						<br> <a href="updateprofile.jsp" class="btn btn-primary">Update
							Profile</a><br>
						<br> <a href="changepassword.jsp" class="btn btn-primary">Change
							Password</a>

					</form>
				</div>
			</div>
		</div>

	</section>





	<!-----------------------footer section---------------------->

	<section id="footer">

		<div class="container">
			<div class="row">
				<div class="col-md-4 footer-box">
					<img src="img/logo.png">
					<p>We placed #1 in the world's Top 20 Most User-Friendly Event
						Planning System Products Ranking by Capterra (a Gartner company) –
						out of over 400 candidates tested!</p>
				</div>
				<div class="col-md-4 footer-box">
					<p>
						<b>Contact Us</b>
					</p>
					<p>
						<i class="fa fa-map-marker"></i> Eventura (Pvt) Ltd, Colombo
					</p>
					<p>
						<i class="fa fa-phone"></i> Tel : 011-7 544 801
					</p>
					<p>
						<i class="fa fa-envelope-o"></i> E-mail : info@eventura.lk
					</p>
				</div>
				<div class="col-md-4 footer-box">
					<p>
						<b>Subscribe Newsletter</b>
					</p>
					<form action="newsletter">
						<input type="email" name="email" class="form-control"
							placeholder="Your E-mail" required> <input type="submit"
							class="btn btn-primary" name="newsletter" value="Subscribe">
					</form>
				</div>
			</div>
			<hr>
			<p class="copyright">Copyright 2020 Eventura (Pvt) Ltd. All
				rights reserved.</p>
		</div>
	</section>


</body>
</html>