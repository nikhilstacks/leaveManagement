<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Simple login form</title>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" href="CSS/staffLogin.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); //http 1.1

		response.setHeader("Pragma", "no-cache"); //http 1.0

		response.setHeader("Expires", "0"); //proxies

		if (session.getAttribute("usernameStudent") != null) {
			response.sendRedirect("studentDashboard.jsp");
		}
	%>
	<!-- <a href="index.html"> <img src="images/LMS.png"
		alt="Logo of Leave Management System" height="40px" width="80px">
	</a> -->

	<section class="main">
		<form action="studentLogin">
			<h1>Login Student</h1>
			<div class="formcontainer">
				<hr />
				<div class="container">
					<label for="uname"><strong>Username</strong></label> <input
						type="email" placeholder="Enter Username" name="mail" required>
					<label for="psw"><strong>Password</strong></label> <input
						type="password" placeholder="Enter Password" name="psw" required>
				</div>
				<button type="submit">Login</button>
			</div>
		</form>
	</section>

</body>
</html>