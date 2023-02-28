<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>Create Staff</title>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" href="CSS/signup.css">
<link rel="stylesheet" href="CSS/homeButton.css">
</head>
<body>
	<section>
		<a class="home" href="index.html"> <img src="images/home.png"
			alt="Logo of Leave Management System" height="40px" width="80px">
		</a>
	</section>
	<form action="createStudent">
		<h1>SIGN UP STUDENT</h1>
		<div class="icon">
			<i class="fas fa-user-circle"></i>
		</div>
		<div class="formcontainer">
			<div class="container">
				<label for="uname"><strong>Username</strong></label> <input
					type="text" placeholder="Enter Username minimum 2 characters"
					name="uname" required autocomplete="off"> <label for="mail"><strong>E-mail</strong></label>
				<input type="email" placeholder="Enter E-mail" name="mail" required
					autocomplete="off"> <label for="psw"><strong>Password</strong></label>
				<input type="password"
					placeholder="Enter Password minimum 8 characters" name="psw"
					required autocomplete="off">
			</div>
			<button class="final" type="submit">
				<strong>SIGN UP</strong>
			</button>
		</div>
	</form>
</body>
</html>