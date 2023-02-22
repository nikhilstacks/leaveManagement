package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createStaff
 */
@WebServlet("/createStaff")
public class createStaff extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uname = request.getParameter("uname");
		String mail = request.getParameter("mail");
		String psw = request.getParameter("psw");
		String id = request.getParameter("id");

		PrintWriter out = response.getWriter();

		Connection connObj;
		String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
			if (connObj != null) {
				System.out.println("successfully connected");

				String get = "insert into staff(name, email, password, employee_id)"
						+ "values(?,?,?,?)";


				PreparedStatement pstmt = connObj.prepareStatement(get,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, uname);
				pstmt.setString(2, mail);
				pstmt.setString(3, psw);
				pstmt.setString(4, id);

				int rows = pstmt.executeUpdate();
				if (rows > 0) {
					System.out.println("Data Inserted Successfully...");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Account Created Successfully :-) ');");
					out.println("location='stafflogin.jsp';");
					out.println("</script>");
				} else
				{
					System.out.println("Data failed to insert...");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Account Creation Failed :-( ');");
					out.println("location='stafflogin.jsp';");
					out.println("</script>");
				}

				connObj.close();
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

	}
}
