<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Educational registration form</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" href="CSS/studentleave.css">
</head>
<body>
	<a href="index.html"> <img src="images/LMS.png"
		alt="Logo of Leave Management System" height="40px" width="80px">
	</a>
	<div class="main-block">
		<div class="left-part">
			<i class="fas fa-graduation-cap"></i>
			<div class="btn-group">
				<h2>Create Leave Request Here</h2>
			</div>
		</div>
		<form action="applyForLeave">
			<div class="title">
				<i class="fas fa-pencil-alt"></i>
				<h2>Register here</h2>
			</div>
			<div class="info">
				<input class="fname" type="text" name="fname" placeholder="Full name" required>
				<input type="email" name="mail" placeholder="Email" required> <input
					type="text" name="phone" placeholder="Phone number" required> <input
					type="text" name="rtl" placeholder="Reason to Leave" required> <input
					type="datetime" name="startDate" placeholder="Start date of leave" required> <input
					type="datetime" name="endDate" placeholder="End date of leave" required>
					<input type="text" name="comment" placeholder="Comments">
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
