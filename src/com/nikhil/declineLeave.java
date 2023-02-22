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
 * Servlet implementation class declineLeave
 */
@WebServlet("/declineLeave")
public class declineLeave extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
				System.out.println("successfully connected decline");

				String qry1 = "update leaves set state='declined' WHERE id=?;";
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
				out.println("alert('approved successfuly :-( ');");
				out.println("location='staffAuditLeaveDashboard.jsp';");
				out.println("</script>");
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

	}

}
