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
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/createStaff")
public class createStaff extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Logger  createStaffLogger = LogManager.getLogger(createStaff.class.getName());
		
		// ---------getting input values from url---------------------
		String uname = request.getParameter("uname");
		String mail = request.getParameter("mail");
		String psw = request.getParameter("psw");
		String id = request.getParameter("id");

		PrintWriter out = response.getWriter();
		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();
		try {

			if (connObj != null) {

				String get = "insert into staff(name, email, password, employee_id)"
						+ "values(?,?,?,?)";
				
				createStaffLogger.debug("executing insert into staff(name, email, password, employee_id)"
						+ "values({},{},{},{})", uname, mail, psw, id);

				PreparedStatement pstmt = connObj.prepareStatement(get,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, uname);
				pstmt.setString(2, mail);
				pstmt.setString(3, psw);
				pstmt.setString(4, id);

				int rows = pstmt.executeUpdate();
				if (rows > 0) {
					HttpSession session = request.getSession();
					// if a staff logs out session will end by destroying
					// variable related to that login
					session.removeAttribute("usernameStaff");
					createStaffLogger.info("User Created Successfully query executed");
					response.sendRedirect("stafflogin.jsp");
				} else {
					createStaffLogger.debug("query execution failed");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Account Creation Failed :-( ');");
					out.println("location='stafflogin.html';");
					out.println("</script>");
				}

				connObj.close();
			}
		} catch (Exception sqlException) {
			createStaffLogger.error("Exception sql {}", sqlException.getMessage());
		}

	}
}
