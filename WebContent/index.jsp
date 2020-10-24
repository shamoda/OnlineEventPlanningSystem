<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Eventura - Home</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
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

	<!-----------------------header section---------------------->

	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-brand" href="#"><img src="img/logo.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item "><a class="nav-link" href="#top">HOME</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#services">SERVICES</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#about-us">ABOUT
							US</a></li>
					<li class="nav-item"><a class="nav-link" href="#testimonials">TESTIMONIALS</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#footer">CONTACT</a>
					</li>

					<%
						//if session has already started, MY DASHBOARD and LOG OUT buttons will display on the navigation bar
						if (session.getAttribute("type") != null) {
					%>

					<li class="nav-item"><a class="nav-link" href="customer.jsp">MY DASHBOARD</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">LOG OUT</a></li>

					<%
						} else {
					%>



					<li class="nav-item"><a class="nav-link" href="login.jsp">LOGIN</a>
					</li>

					<%
						}
					%>


				</ul>
			</div>
		</nav>
	</section>






	<!-----------------------banner section---------------------->


	<section id="banner">

		<!-----------------------notification section---------------------->

		<p class="notify">
			<%
				if (null != request.getAttribute("newsletter")) {
				out.println(request.getAttribute("newsletter"));
			}
			%>
		</p>

		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<p class="promo-title">
						Exclusive Events <br> Priceless Memories
					</p>
					<p>You already dreamed it join now & create it with Eventura. 
						Standout with beautiful that are tailed to your industry. 
						Grow your business with the powerful new insight tools. 
						<br>Plan for the unplannable with the world's most collborative
						events platform.</p>
					<a href="register.jsp" class="btn btn-primary">Sign Up Today</a>
				</div>
				<div class="col-md-6 text-center">
					<img src="img/banner1.png" class="img-fluid">
				</div>
			</div>
		</div>
		<img src="img/wave.png" class="bottom-img">
	</section>



	<!-----------------------services section---------------------->


	<section id="services">
		<div class="container text-center">
			<h1 class="title">What We Do ?</h1>
			<div class="row text-center">
				<div class="col-md-4 services">
					<img src="img/launchevent.png" class="services-img">
					<h4>
						Launch Your Event <br> with Eventura
					</h4>
					<p>Every journey must start somewhere, what follow either
						little steps. We Eventura, turn your goals into Reality</p>
				</div>
				<div class="col-md-4 services">
					<img src="img/promote.png" class="services-img">
					<h4>
						Promote Your Event <br> Completely FREE
					</h4>
					<p>No need to worry about promotions. You just need to launch
						your event with us. Our marketing experts will take care of the
						rest.</p>
				</div>
				<div class="col-md-4 services">
					<img src="img/bookticket.png" class="services-img">
					<h4>
						Reserve Your Seat <br> Discounts are waiting
					</h4>
					<p>You can Reserve your space at your favorite up comming
						events in just few easy steps. Special discounts are waiting for
						you.</p>
				</div>
			</div>
			<a href="register.jsp" class="btn btn-primary">Join with Us</a>

		</div>
	</section>


	<!-----------------------about us section---------------------->

	<section id="about-us">
		<div class="container">
			<h1 class="title text-center">About Eventura</h1>
			<div class="row">
				<div class="col-md-6 about-us">
					<p class="about-title">Why choose us ?</p>
					<ul>
						<li>Our Approach</li>
						<li>Our Unique Abilities</li>
						<li>Unparalleled Quality</li>
						<li>5+ years Experience</li>
						<li>Flexibility</li>
						<li>24/7 Support</li>
						<li>Free Promotions</li>
						<li>#1 Customer Satisfication</li>
					</ul>
				</div>
				<div class="col-md-6">
					<img src="img/aboutus.png" class="img-fluid">
				</div>
			</div>
		</div>
	</section>


	<!-----------------------testimonials section---------------------->

	<section id="testimonials">
		<div class="container">
			<h1 class="title text-center">Happy Clients</h1>
			<div class="row offset-1">
				<div class="col-md-5 testimonials">
					<p>I was quite overwhelmed at first when thinking about
						planning a huge party at our home so I reached out to a few party
						planners. I was so happy I picked Eventura and All Set.</p>
					<img src="img/user1.jpg">
					<p class="user-details">
						<b>Dayna Michel</b> <br> Founder of E-Cal
					</p>
				</div>
				<div class="col-md-5 testimonials">
					<p>From the very first phone call, Eventura made my life
						easier. Planning a such event was very stressful for me, and they
						made the process fun again!</p>
					<img src="img/user2.jpg">
					<p class="user-details">
						<b>David Jonathon</b> <br> Co-Founder of Vyvone
					</p>
				</div>
			</div>
		</div>
	</section>


	<!-----------------------social media section---------------------->

	<section id="social-media">
		<div class="container text-center">
			<p>Follow Us</p>
			<div class="social-icons">
				<a href="facebook.com"><img src="img/facebook.png"></a> <a
					href="instagram.com"><img src="img/instagram.png"></a> <a
					href="twitter.com"><img src="img/twitter.png"></a> <a
					href="whatsapp.com"><img src="img/whatsapp.png"></a> <a
					href="linkedin.com"><img src="img/linkedin.png"></a> <a
					href="snapchat.com"><img src="img/snapchat.png"></a>
			</div>
		</div>
	</section>


	<!-----------------------footer section---------------------->

	<section id="footer">
		<img src="img/wave1.png" class="footer-img">
		<div class="container">
			<div class="row">
				<div class="col-md-4 footer-box">
					<img src="img/logo.png">
					<p>We placed #1 in the world's Top 20 Most User-Friendly Event
						Planning System Products Ranking by Capterra (a Gartner company)
						â€“ out of over 400 candidates tested!</p>
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

	<!-----------------------smooth scroll---------------------->

	<script type="text/javascript" src="js/smooth-scroll.js"></script>
	<script>
		var scroll = new SmoothScroll('a[href*="#"]');
	</script>


</body>
</html>