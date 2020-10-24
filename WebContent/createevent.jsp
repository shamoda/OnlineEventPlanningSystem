<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Eventura - Create New Event</title>
<link rel="stylesheet" type="text/css" href="styles/createevent.css">
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

	<!-----------------------notification section---------------------->
	<div class="notify">
		<p>
			<%
				if (null != request.getAttribute("creationError")) {
				out.println(request.getAttribute("creationError"));
			}
			if (null != request.getAttribute("creationSuccess")) {
				out.println(request.getAttribute("creationSuccess"));
			}
			%>
		</p>
	</div>



	<!-----------------------customer dashboard section---------------------->

	<section id="customer">
		<div class="container">
			<div class="row">
				<div class="col-md-9">



					<!-----------------------create event section---------------------->

					<div class="create-event">
						<h4>Create New Event :</h4>

						<form action="createevent" method="post">
							<div class="row">
								<div class="input1 col-md-4">Title :</div>
								<div class="input2 col-md-8">
									<input type="text" name="title" placeholder="Event Title"
										required> <br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Date :</div>
								<div class="input2 col-md-8">
									<input type="date" name="date" required><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Time :</div>
								<div class="input2 col-md-8">
									<input type="time" name="time" required><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Venue :</div>
								<div class="input2 col-md-8">
									<select name="venue">
										<option value="Eventura Main Auditorium">Eventura Main Auditorium</option>
										<option value="Colombo Courtyard">Colombo Courtyard</option>
										<option value="Movenpick Colombo">Movenpick Colombo</option>
										<option value="Enclave Colombo">Enclave Colombo</option>
										<option value="Villa Escondite Kotte">Villa Escondite Kotte</option>
										<option value="Olcote in Ceylon">Olcote in Ceylon</option>
										<option value="Gartons Ark">Gartons Ark</option>
										<option value="Hilton Colombo">Hilton Colombo</option>
										<option value="The Kingsbury">The Kingsbury</option>
										<option value="Galle Face Hotel">Galle Face Hotel</option>
										<option value="Tintagel Colombo">Tintagel Colombo</option>
										<option value="Nisala Arana">Nisala Arana</option>
										<option value="Citrus Waskaduwa">Citrus Waskaduwa</option>
										<option value="Viharamahadevi Park Open Air Theatre">Viharamahadevi Park Open Air Theatre</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Theme :</div>
								<div class="input2 col-md-8">
									<select name="theme">
										<option value="Hollywood">Hollywood</option>
										<option value="Black & White">Black & White</option>
										<option value="Gameday">Gameday</option>
										<option value="Murder Mystery Party">Murder Mystery
											Party</option>
										<option value="Luau">Luau</option>
										<option value="Casino Night">Casino Night</option>
										<option value="Wild West">Wild West</option>
										<option value="Top Chef">Top Chef</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Package :</div>
								<div class="input2 col-md-8">
									<select name="package">
										<option value="Standard Package">Standard Package</option>
										<option value="Premium Package">Premium Package</option>
										<option value="Deluxe Package">Deluxe Package</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Summary :</div>
								<div class="input2 col-md-8">
									<textarea name="summary" placeholder="Event Summary" rows="8"
										cols="50" required></textarea>
									<br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Foods & Beverages :</div>
								<div class="input2 col-md-8">
									<select name="foods">
										<option value="Package 1">Package 1</option>
										<option value="Package 2">Package 2</option>
										<option value="Package 3">Package 3</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Liquor :</div>
								<div class="input2 col-md-8">
									<select name="liquor">
										<option value="None">None</option>
										<option value="Well Package">Well Package</option>
										<option value="Call Package">Call Package</option>
										<option value="Premium Package">Premium Package</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Sounds & Lights :</div>
								<div class="input2 col-md-8">
									<select name="sounds">
										<option value="The Wobble">The Wobble</option>
										<option value="All About the Bass">All About the Bass</option>
										<option value="3 Piece Band">3 Piece Band</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Number of Participants :</div>
								<div class="input2 col-md-8">
									<input type="text" name="participants"
										placeholder="Number of Participants" required> <br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Your Budget :</div>
								<div class="input2 col-md-8">
									<input type="text" name="budget" placeholder="Your Budget"
										required> <br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Entrance Fee :</div>
								<div class="input2 col-md-8">
									<select name="entrance">
										<option value="0">Free</option>
										<option value="1000">1000 LKR</option>
										<option value="1500">1500 LKR</option>
										<option value="2000">2000 LKR</option>
										<option value="2500">2500 LKR</option>
										<option value="3000">3000 LKR</option>
									</select><br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Additional :</div>
								<div class="input2 col-md-8">
									<textarea name="additional"
										placeholder="Tell us more about your additional requirements."
										rows="4" cols="50"></textarea>
									<br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4">Tags :</div>
								<div class="input2 col-md-8">
									<textarea name="tags"
										placeholder="Tags will help people to find your event. You can separate each tag using a space."
										rows="4" cols="50" required></textarea>
									<br>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="input1 col-md-4"></div>
								<div class="input2 col-md-8">
									<input type="submit" name="submit" value="Apply">
								</div>
							</div>
						</form>
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
			<p class="copyright">Copyright 2020 Eventura (Pvt) Ltd. All rights reserved.</p>
		</div>
	</section>



</body>
</html>