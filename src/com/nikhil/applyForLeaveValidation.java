package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;




/**
 * Servlet Filter implementation class applyForLeaveValidation
 */
@WebFilter("/applyForLeave")
public class applyForLeaveValidation implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("inside inside validation leaves");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("fname");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String reason = request.getParameter("rtl");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		Connection connObj;
		String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
			if (connObj != null) {
				System.out.println("successfully connected validation");
				
				//---------------------This is for date------------------------------------------
				LocalDate date = LocalDate.now();
				LocalDate startDateConvert = LocalDate.parse(startDate);
				LocalDate endDateConvert = LocalDate.parse(endDate);
				int compareValueStart= date.compareTo(startDateConvert);
				int compareValueEnd = startDateConvert.compareTo(endDateConvert);
				
					if (uname.length() < 2 || phone.length() < 10 || reason.length() < 10  || compareValueStart > 0 || compareValueEnd > 0 ) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Enter valid details :-( ')");
						out.println("location='applyForLeave.jsp';");
						out.println("</script>");

						System.out.println("inside validation for create leave");
						// httpResponse.sendRedirect("createStudent.jsp");
					} else
						chain.doFilter(request, response);
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
