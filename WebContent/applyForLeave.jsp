<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Educational registration form</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
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
				<input class="fname" type="text" name="name" placeholder="Full name">
				<input type="text" name="name" placeholder="Email"> <input
					type="text" name="name" placeholder="Phone number"> <input
					type="text" name="name" placeholder="Reason to Leave"> <input
					type="datetime" placeholder="Start date of leave"> <input
					type="datetime" placeholder="End date of leave">
			</div>
			<button type="submit" href="/">Submit</button>
		</form>
	</div>
</body>
</html>
