package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter("/createStudent")
public class createStudentValidation implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		Logger  createStudentValidationLogger = LogManager.getLogger(createStudentValidation.class.getName());
		String mail = request.getParameter("mail");

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();
		try {
			if (connObj != null) {
				ResultSet rs;

				String qry = "Select * from student where email=?";
				createStudentValidationLogger.debug("executing Select * from student where email={}", mail);

				PreparedStatement pstmt = connObj.prepareStatement(qry,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();
				String CheckMail = null;

				// checking if email is already exists or not
				while (rs.next()) {
					CheckMail = rs.getString("email");
				}
				if (CheckMail == null) {
					chain.doFilter(request, response);
				} else {
					createStudentValidationLogger.debug("Email already registered Login again");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Email already registered');");
					out.println("location='createStudent.html';");
					out.println("</script>");
				}

			}
		} catch (Exception sqlException) {
			createStudentValidationLogger.error("Exception sql {}", sqlException.getMessage());
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
