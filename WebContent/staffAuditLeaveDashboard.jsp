<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.nikhil.DatabaseConnectionMain"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Leave Dashboard</title>
</head>
<body>
<a href="index.html"> <img src="images/LMS.png"
		alt="Logo of Leave Management System" height="40px" width="80px">
	</a>
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