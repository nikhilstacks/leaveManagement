package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/applyForLeave")
public class applyForLeaveValidation implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
//		--------getting values from url------------------
		String uname = request.getParameter("fname");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String reason = request.getParameter("rtl");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();
		try {
			if (connObj != null) {
				System.out.println("successfully connected validation");

//			   ---------this is date validation----------------------
				LocalDate date = LocalDate.now();
				LocalDate startDateConvert = LocalDate.parse(startDate);
				LocalDate endDateConvert = LocalDate.parse(endDate);
				int compareValueStart = date.compareTo(startDateConvert);
				int compareValueEnd = startDateConvert
						.compareTo(endDateConvert);
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession session = req.getSession();
				
				if (mail.equals((String) session
						.getAttribute("usernameStudent"))) {
					if (uname.length() < 2 || phone.length() < 10
							|| reason.length() < 10 || compareValueStart > 0
							|| compareValueEnd > 0) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Enter valid details :-( ')");
						out.println("location='applyForLeave.jsp';");
						out.println("</script>");

						// httpResponse.sendRedirect("createStudent.jsp");
					} else
						chain.doFilter(request, response);
				} else {
//					System.out.println("inside email matched else");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Enter valid Email :-( ')");
					out.println("location='applyForLeave.jsp';");
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
