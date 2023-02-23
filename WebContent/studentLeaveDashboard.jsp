<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.nikhil.DatabaseConnectionMain"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/homeButton.css">
<link rel="stylesheet" href="CSS/tableCss.css">
<title>Student Leave Dashboard</title>
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
	<%
		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		ResultSet rs;

		String qry = "Select * from leaves where email=? order by id desc";

		PreparedStatement pstmt = connObj.prepareStatement(qry,
				Statement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, (String) session.getAttribute("usernameStudent"));
		rs = pstmt.executeQuery();
	%>
	<section class="requests">
		<TABLE  border="1" style="background-color: #D3E0DC;">
			<TR>
				<TH>FULL NAME</TH>
				<TH>EMAIL</TH>
				<TH>PHONE</TH>
				<TH>REASON FOR LEAVE</TH>
				<TH>START DATE</TH>
				<TH>END DATE</TH>
				<TH>COMMENTS</TH>
				<TH>STATUS</TH>
				<TH>ACTION</TH>
			</TR>
			<%
				while (rs.next()) {
			%>
			<TR>
				<TD><%=rs.getString(1)%></TD>
				<TD><%=rs.getString(2)%></TD>
				<TD><%=rs.getString(3)%></TD>
				<TD><%=rs.getString(4)%></TD>
				<TD><%=rs.getDate(5)%></TD>
				<TD><%=rs.getDate(6)%></TD>
				<TD><%=rs.getString(7)%></TD>
				<TD><%=rs.getString(8)%></TD>
				<TD><form action="deleteLeave">
						<input type="hidden" name="id" value="<%=rs.getString(9)%>" />
						<button type="submit">DELETE</button>
					</form></TD>
			</TR>
			<%
				}
			%>
			<%
				// close all the connections.
				rs.close();
				connObj.close();
			%>
		</TABLE>
	</section>

</body>
</html>