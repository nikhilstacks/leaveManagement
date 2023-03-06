package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter("/applyForLeave")
public class applyForLeaveValidation implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		// --------getting values from url------------------
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		Logger ApplyLeaveValidationLogger = LogManager
				.getLogger(applyForLeaveValidation.class.getName());
		try {
			if (connObj != null) {

				// ---------this is date validation----------------------

				String DATE_FORMAT = "yyyy-MM-dd";

				DateFormat df = new SimpleDateFormat(DATE_FORMAT);
				boolean dateCheck;
				try {
					df.parse(startDate);
					df.parse(endDate);
					dateCheck = true;
				} catch (ParseException e) {
					dateCheck = false;
				}
				if (dateCheck == false) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Enter Valid Date Format :-( ')");
					out.println("location='applyForLeave.jsp';");
					out.println("</script>");
					ApplyLeaveValidationLogger.debug("Date Format is wrong");
				}

				// getting today date
				LocalDate date = LocalDate.now();

				// parsing string to date
				LocalDate startDateConvert = LocalDate.parse(startDate);
				LocalDate endDateConvert = LocalDate.parse(endDate);
				int compareValueStart = date.compareTo(startDateConvert);
				int compareValueEnd = startDateConvert
						.compareTo(endDateConvert);
				
				System.out.print(compareValueEnd);
				System.out.print(compareValueStart);

				if (compareValueStart > 0 || compareValueEnd > 0) {
					ApplyLeaveValidationLogger
					.debug("Enter valid Start and end Date");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('invalid Date start date should be future date and end date should be after start date');");
					out.println("location='applyForLeave.jsp';");
					out.println("</script>");
					// httpResponse.sendRedirect("createStudent.jsp");
				} else
				chain.doFilter(request, response);

			}
		} catch (Exception sqlException) {
			ApplyLeaveValidationLogger.error("Exception sql {}",
					sqlException.getMessage());
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
