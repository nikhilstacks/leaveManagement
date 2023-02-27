<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Staff Login</title>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" href="CSS/Login.css">
<link rel="stylesheet" href="CSS/homeButton.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); //http 1.1

		response.setHeader("Pragma", "no-cache"); //http 1.0

		response.setHeader("Expires", "0"); //proxies

		if (session.getAttribute("usernameStaff") != null) {
			response.sendRedirect("staffAuditLeaveDashboard.jsp");
		}
	%>
	<section>
		<a class="home" href="index.html"> <img src="images/home.png"
			alt="Logo of Leave Management System" height="40px" width="80px">
		</a>
	</section>

	<section class="main">
		<form action="staffLogin">
			<h1>Login Staff</h1>
			<div class="formcontainer">
				<hr />
				<div class="container">
					<label for="uname"><strong>Username</strong></label> <input
						type="email" placeholder="Enter Email" name="mail" required>
					<label for="psw"><strong>Password</strong></label> <input
						type="password" placeholder="Enter Password" name="psw" required>
				</div>
				<button class="final" type="submit">Login</button>
			</div>
		</form>
	</section>

</body>
</html>