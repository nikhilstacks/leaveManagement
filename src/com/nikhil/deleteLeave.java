package com.nikhil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

@WebServlet("/deleteLeave")
public class deleteLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		Logger deleteLeaveLogger = LogManager.getLogger(deleteLeave.class.getName());

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		if (connObj != null) {

			String qry1 = "DELETE FROM leaves WHERE id=?;";
			String qry2 = "DELETE FROM audit WHERE id=? AND state='pending';";
			
			deleteLeaveLogger.debug("executing DELETE FROM leaves WHERE id={};", id);
			deleteLeaveLogger.debug("executing DELETE FROM audit WHERE id={} AND state='pending';", id);
			
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
				deleteLeaveLogger.debug("deleted leave successfully ");
				response.sendRedirect("studentLeaveDashboard.jsp");
			} catch (Exception sqlException) {
				sqlException.printStackTrace();
			}
		}

	}

}
