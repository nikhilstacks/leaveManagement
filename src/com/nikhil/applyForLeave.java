package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/applyForLeave")
public class applyForLeave extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// System.out.println("inside leave");

		PrintWriter out = response.getWriter();

		Logger applyForLeaveLogger = LogManager.getLogger(applyForLeave.class
				.getName());

		// ----------------getting parameters value from url---------------

		String fname = request.getParameter("fname");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String reason = request.getParameter("rtl");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String comment = request.getParameter("comment");

		// ------------------DB Connection-------------------------------------
		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		if (connObj != null) {

			String insertLeaves = "insert into leaves(fname, email, phone, Reason, startDate, endDate, comments, state)"
					+ "values(?,?,?,?,?,?,?,'pending')";
			
			applyForLeaveLogger.info("Executing two queries");
			applyForLeaveLogger
					.debug("insert into leaves(fname, email, phone, Reason, startDate, endDate, comments, state)"
							+ "values({},{},{},{},{},{},{},'pending')", fname,
							mail, phone, reason, startDate, endDate, comment);

			try {
				PreparedStatement pstmt = connObj.prepareStatement(
						insertLeaves, Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, fname);
				pstmt.setString(2, mail);
				pstmt.setString(3, phone);
				pstmt.setString(4, reason);
				pstmt.setString(5, startDate);
				pstmt.setString(6, endDate);
				pstmt.setString(7, comment);

				String insertAudit = "insert into audit(fname, email, Reason, startDate, endDate, state)"
						+ "values(?,?,?,?,?,'pending')";
				
				applyForLeaveLogger.debug("insert into audit(fname, email, Reason, startDate, endDate, state)"
						+ "values({},{},{},{},{},'pending')", fname, mail, reason, startDate, endDate);

				PreparedStatement pstmt2 = connObj.prepareStatement(
						insertAudit, Statement.RETURN_GENERATED_KEYS);

				pstmt2.setString(1, fname);
				pstmt2.setString(2, mail);
				pstmt2.setString(3, reason);
				pstmt2.setString(4, startDate);
				pstmt2.setString(5, endDate);

				int row1 = pstmt.executeUpdate();
				int row2 = pstmt2.executeUpdate();

				if (row1 > 0 && row2 > 0) {
					
					applyForLeaveLogger.info("Both Queries Exucuted successfully");
					applyForLeaveLogger.info("successfully applied for leave");
					// System.out.println("Data Inserted Successfully...");
					response.sendRedirect("studentLeaveDashboard.jsp");
				} else {

					// System.out.println("failed to Inserted Data...");
					applyForLeaveLogger.debug("Faild to Execute Queries");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('data insertion fail :-( ');");
					out.println("location='applyForLeave.jsp';");
					out.println("</script>");
				}

				connObj.close();
			} catch (Exception sqlException) {
				applyForLeaveLogger.error("Exception sql {}", sqlException.getMessage());
			}
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
