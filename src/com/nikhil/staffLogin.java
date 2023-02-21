package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class staffLogin
 */
@WebServlet("/staffLogin")
public class staffLogin extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String mail = request.getParameter("mail");
		String psw = request.getParameter("psw");

		Connection connObj;
		String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
			if (connObj != null) {
				System.out.println("successfully connected");
				
				ResultSet rs;

				Statement statement = connObj.createStatement();
				String qry = "Select * from staff where email=?";

				PreparedStatement pstmt = connObj.prepareStatement(qry,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();
				String CheckMail = null;
				String pass = null;
				while (rs.next()) {
					// Display values
					CheckMail = rs.getString("email");
					pass = rs.getString("password");
				}
				
				if(CheckMail == null)
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('invalid Credentials');");
					out.println("location='srafflogin.jsp';");
					out.println("</script>");

				} else {
					
					if(pass.equals(psw))
					{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('User login successfully');");
					out.println("location='stafflogin.jsp';");
					out.println("</script>");
					} 
					else 
					{
						out.println("<script type=\"text/javascript\">");
						out.println("alert('invalid credentials');");
						out.println("location='stafflogin.jsp';");
						out.println("</script>");
					}
				}
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

	}
}
