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

		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

			if (connObj != null) {
				System.out.println("successfully connected delete");

				String qry1 = "DELETE FROM leaves WHERE id=?;";
				String qry2 = "DELETE FROM audit WHERE id=? AND state='pending';";
				try{
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
				out.println("location='studentLeaveDashboard.jsp';");
				out.println("</script>");
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
			}
		

	}

}
