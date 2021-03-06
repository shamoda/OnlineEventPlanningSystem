<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.oeps.util.*"%>
<%@page import="java.lang.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Eventura - Event Admin</title>
<link rel="stylesheet" type="text/css" href="styles/eventadmin.css">
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
		/*
		*	user access control
		*	check whether user is logged into the system or not
		*/
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
				<div class="col-md-9 event">
					<!-----------------------event section---------------------->
					<br>
					<h4>Event Info :</h4>

					<%
						try {
						int eId = Integer.parseInt(request.getParameter("eId"));

						//getting event details
						Connection connection = connectionUtil.getConnection();
						Statement stmt = connection.createStatement();
						ResultSet rs = stmt.executeQuery("select * from event where eId = '" + eId + "' ");
						rs.next();
					%>

					<div class="banner"
						style="background-image: url('img/locations/<%=rs.getString("venue")%>.jpg');">

					</div>

					<h2>
						<b><%=rs.getString("title")%></b>
					</h2>

					<p>
						<b>Date :</b>
						<%=rs.getString("date")%>
						<br>
						<b>Venue :</b>
						<%=rs.getString("venue")%>
						<br><%=rs.getString("time")%>
						<b>on wards</b>
					</p>

					<p>
						<b>Theme :</b>
						<%=rs.getString("theme")%></p>
					<p>
						<b>Package :</b>
						<%=rs.getString("package")%></p>
					<p>
						<b>Foods & Beverages :</b>
						<%=rs.getString("foods")%></p>
					<p>
						<b>Liquor :</b>
						<%=rs.getString("liquor")%></p>
					<p>
						<b>Sounds & Lights :</b>
						<%=rs.getString("sounds")%></p>
					<p>
						<b>Number of Participants :</b>
						<%=rs.getString("participants")%></p>
					<p>
						<b>Entrance :</b>
						<%=rs.getString("entrance")%></p>
					<p>
						<b>Budget :</b>
						<%=rs.getString("budget")%></p>
					<p>
						<b>Additional :</b>
						<%=rs.getString("additional")%></p>


					<p>
						<%=rs.getString("summary")%>
					</p>
					<br>

					<p>
						<b>Status : <%
							String status = "0";

						String sts = rs.getString("status");
						if (sts.equals("0")) {
							status = "Pending";
						}
						if (sts.equals("1")) {
							status = "Approved";
						}
						if (sts.equals("2")) {
							status = "Rejected";
						}
						if (sts.equals("4")) {
							status = "Ended";
						}
						out.print(status);
						%></b>
					</p>
					<br>



					<div class="container">
						<div class="row">
							<div class="col-md-4 custbtn">
								<a href="approveevent?eventId=<%=rs.getString("eId")%>"
									class="btn btn-primary">Approve Event</a>
							</div>

							<div class="col-md-4 custbtn">
								<a href="rejectevent?eventId=<%=rs.getString("eId")%>"
									class="btn btn-primary">Reject Event</a>
							</div>

							<div class="col-md-4 custbtn">
								<a href="deleteevent?eventId=<%=rs.getString("eId")%>"
									class="btn btn-primary">Delete Event</a>
							</div>
						</div>
					</div>

					<%
						} catch (Exception e) {
						e.printStackTrace();
					}
					%>



				</div>
				<div class="col-md-3">
					<form class="sidebar side">
						<a href="manageevents.jsp" class="btn btn-primary">Manage
							Events</a><br> <br> <a href="manageusers.jsp"
							class="btn btn-primary">Manage Users</a><br> <br> <a
							href="registeradmin.jsp" class="btn btn-primary">Add New
							Admin</a><br> <br> <a href="newsletter.jsp"
							class="btn btn-primary">Subscriptions</a> <br> <br> <a
							href="updateprofile.jsp" class="btn btn-primary">Update
							Profile</a><br> <br> <a href="changepassword.jsp"
							class="btn btn-primary">Change Password</a>

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