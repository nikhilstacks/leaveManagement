package com.nikhil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/deleteLeave")
public class deleteLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		if (connObj != null) {
			System.out.println("successfully connected delete");

			String qry1 = "DELETE FROM leaves WHERE id=?;";
			String qry2 = "DELETE FROM audit WHERE id=? AND state='pending';";
			try {
				PreparedStatement pstmt = connObj.prepareStatement(qry1,
						Statement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmt2 = connObj.prepareStatement(qry2,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, id);
				pstmt2.setString(1, id);
				pstmt.executeQuery();
				pstmt2.executeQuery();

				// System.out.println("successfully deleted data...");
				response.sendRedirect("studentLeaveDashboard.jsp");
			} catch (Exception sqlException) {
				sqlException.printStackTrace();
			}
		}

	}

}
