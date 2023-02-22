package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteLeave")
public class deleteLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");

		Connection connObj;
		String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
			if (connObj != null) {
				System.out.println("successfully connected delete");

				String qry1 = "DELETE FROM leaves WHERE id=?;";
				String qry2 = "DELETE FROM audit WHERE id=?;";

				PreparedStatement pstmt = connObj.prepareStatement(qry1,
						Statement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmt2 = connObj.prepareStatement(qry2,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, id);
				pstmt2.setString(1, id);
				pstmt.executeQuery();
				pstmt2.executeQuery();
				System.out.println("successfully deleted data...");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('data deleted successfully :-( ');");
				out.println("location='studentLeaveDashboard.jsp';");
				out.println("</script>");
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

	}

}
