<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Apply For Leave</title>
<script src="JavaScript/popup.js" defer></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" href="CSS/studentleave.css">
<link rel="stylesheet" href="CSS/homeButton.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); //http 1.1

		response.setHeader("Pragma", "no-cache"); //http 1.0

		response.setHeader("Expires", "0"); //proxies

		if (session.getAttribute("usernameStudent") == null) {
			response.sendRedirect("studentLogin.jsp");
		}
	%>
	<section>
		<a class="home" href="index.html"> <img src="images/home.png"
			alt="Logo of Leave Management System" height="40px" width="80px">
		</a> <a class="back" href="studentDashboard.jsp"> <img
			src="images/back.svg" alt="Logo of Leave Management System"
			height="40px" width="80px">
		</a><span>${usernameStudent }</span>
		<form class="logout" action="logoutStudent">
			<button type="submit">LogOut</button>
		</form>
	</section>
	<div class="main-block">
		<div class="left-part">
			<i class="fas fa-graduation-cap"></i>
			<div class="btn-group">
				<h2>Create Leave Request Here</h2>
			</div>
		</div>
		<form name="applyForLeave" onsubmit="return ApplyLeaveValidation()"
			action="applyForLeave">
			<div class="title">
				<i class="fas fa-pencil-alt"></i>
				<h2>Register here</h2>
			</div>
			<div class="info">
				<label for="fname">Full Name</label>
				<input class="fname" type="text" name="fname"
					placeholder="Full name" required>
				<label for="mail">Email</label>
				<input class="userMail" type="email" name="mail" placeholder="Email"
					required value="${usernameStudent}" readonly>
				<label for="phone">Phone Number</label>
				<input type="number" name="phone"
					placeholder="Phone number Min 10 characters" required
					autocomplete="off">
				<label for="rtl">Reason For Leave</label>
				<input type="text" name="rtl" placeholder="Reason to Leave"
					autocomplete="off" required>
				<label for="startDate">Leave Start Date</label>
				<input type="datetime" name="startDate"
					placeholder="Start date YYYY-MM-DD" autocomplete="off" required>
				<label for="endDate">Leave End Date</label>
				<input type="datetime" name="endDate"
					placeholder="End date YYYY-MM-DD" autocomplete="off" required>
				<label for="comment">Comment</label>
				<input type="text" name="comment" placeholder="Comments"
					autocomplete="off">
				<p id="message" class="danger"></p>
			</div>
			<button class="final" type="submit" onclick="ApplyLeaveValidation()">Submit</button>
		</form>
	</div>
</body>
</html>
