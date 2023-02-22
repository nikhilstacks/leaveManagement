<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<a href="index.html"> <img src="images/LMS.png"
		alt="Logo of Leave Management System" height="40px" width="80px">
	</a>
	<form action="logout">
		<input type="submit" value="LOGOUT">
	</form>
	<form action="applyForLeave.jsp">
		<input type="submit" value="Apply for leave">
	</form>
	
	<form action="studentLeaveDashboard.jsp">
		<input type="submit" value="Show status for applied leave">
	</form>
</body>
</html>