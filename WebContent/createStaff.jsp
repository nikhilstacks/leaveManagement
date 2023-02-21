<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>Simple Sign up from</title>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/signup.css">
</head>
<body>
	<a href="index.html"> <img src="images/LMS.png"
		alt="Logo of Leave Management System" height="40px" width="80px">
	</a>
	<form action="createStaff">
		<h1>SIGN UP STAFF</h1>
		<div class="icon">
			<i class="fas fa-user-circle"></i>
		</div>
		<div class="formcontainer">
			<div class="container">
				<label for="uname"><strong>Username</strong></label> <input
					type="text" placeholder="Enter Username" name="uname" required>
				<label for="mail"><strong>E-mail</strong></label> <input
					type="email" placeholder="Enter E-mail" name="mail" required>
				<label for="psw"><strong>Password</strong></label> <input
					type="password" placeholder="Enter Password" name="psw" required>
				<label for="psw"><strong>Employee Id</strong></label> <input
					type="text" placeholder="Enter Id" name="id" required>
			</div>
			<button type="submit">
				<strong>SIGN UP</strong>
			</button>
	</form>
</body>
</html>