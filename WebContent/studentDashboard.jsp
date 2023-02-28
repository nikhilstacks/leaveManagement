<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/homeButton.css">
<link rel="stylesheet" href="CSS/studentDashboard.css">
<title>Student Dashboard</title>
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
		</a><span>${usernameStudent }</span>
		<form class="logout" action="logoutStudent">
			<button type="submit">LogOut</button>
		</form>
	</section>

	<section class="dashboard">
		<div class="main">
			<form action="applyForLeave.jsp">
				<input type="submit" value="Apply for leave">
			</form>
		</div>
		<div class="main">
			<form action="studentLeaveDashboard.jsp">
				<input type="submit" value="Status Applied Leaves">
			</form>
		</div>
	</section>
</body>
</html>