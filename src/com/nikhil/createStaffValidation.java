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

@WebFilter("/createStaff")
public class createStaffValidation implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("inside filter staff");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String mail = request.getParameter("mail");
		String psw = request.getParameter("psw");

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();
		try {

			if (connObj != null) {
				ResultSet rs;

				String qry = "Select * from staff where email=?";

				PreparedStatement pstmt = connObj.prepareStatement(qry,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();

				String CheckMail = null;
				while (rs.next()) {
					CheckMail = rs.getString("email");
				}

				// checking if mail already exists or not
				if (CheckMail == null) {
					if (uname.length() < 2 || psw.length() < 8) {

						out.println("<script type=\"text/javascript\">");
						out.println("alert('Insert Valid data');");
						out.println("location='createStaff.jsp';");
						out.println("</script>");

						// httpResponse.sendRedirect("createStudent.jsp");
					} else
						chain.doFilter(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Email already registered');");
					out.println("location='createStaff.jsp';");
					out.println("</script>");
				}

			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
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
