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

@WebServlet("/logoutStaff")
public class logoutStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger logoutStaffLogger = LogManager.getLogger(logoutStaff.class.getName());

		HttpSession session = request.getSession();
		// if a staff logs out session will end by destroying variable related
		// to that login
		session.removeAttribute("usernameStaff");
		logoutStaffLogger.info("Staff Logout Successfully");
		
		response.sendRedirect("index.html");
	}

}
