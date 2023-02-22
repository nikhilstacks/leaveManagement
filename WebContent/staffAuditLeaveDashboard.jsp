<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.nikhil.DatabaseConnectionMain"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff Audit Dashboard</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); //http 1.1

		response.setHeader("Pragma", "no-cache"); //http 1.0

		response.setHeader("Expires", "0"); //proxies

		if (session.getAttribute("usernameStaff") == null) {
			response.sendRedirect("stafflogin.jsp");
		}
	%>
	<a href="index.html"> <img src="images/LMS.png"
		alt="Logo of Leave Management System" height="40px" width="80px">
	</a>
	<form action="logoutStaff">
		<input type="submit" value="LOGOUT">
	</form>
	<%
		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		ResultSet rs;

		String qry = "Select * from audit";

		PreparedStatement pstmt = connObj.prepareStatement(qry,
				Statement.RETURN_GENERATED_KEYS);

		rs = pstmt.executeQuery();
	%>
	<TABLE cellpadding="15" border="1" style="background-color: #ffffcc;">
		<TR>
			<TH>FULL NAME</TH>
			<TH>EMAIL</TH>
			<TH>REASON FOR LEAVE</TH>
			<TH>START DATE</TH>
			<TH>END DATE</TH>
			<TH>STATUS</TH>
			<TH>ACTIONS</TH>
		</TR>
		<%
			while (rs.next()) {
		%>
		<TR>
			<TD><%=rs.getString(1)%></TD>
			<TD><%=rs.getString(2)%></TD>
			<TD><%=rs.getString(3)%></TD>
			<TD><%=rs.getDate(4)%></TD>
			<TD><%=rs.getDate(5)%></TD>
			<TD><%=rs.getString(6)%></TD>
			<TD><form action="approveLeave">
					<input type="hidden" name="id" value="<%=rs.getString(7)%>" />
					<button type="submit">Approve</button>
				</form>
				<form action="declineLeave">
					<input type="hidden" name="id" value="<%=rs.getString(7)%>" />
					<button type="submit">Decline</button>
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
</body>
</html>