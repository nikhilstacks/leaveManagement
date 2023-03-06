package com.nikhil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/logoutStudent")
public class logoutStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Logger logoutStudentLogger = LogManager.getLogger(logoutStudent.class.getName());
		HttpSession session = request.getSession();

		// destroying session variable related to login
		session.removeAttribute("usernameStudent");
		logoutStudentLogger.info("Student logged out Successfully");

		response.sendRedirect("index.html");
	}

}
