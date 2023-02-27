package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/staffLogin")
public class staffLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

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
				String pass = null;
				while (rs.next()) {
					// Display values
					CheckMail = rs.getString("email");
					pass = rs.getString("password");
				}
				
				if(CheckMail == null)
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('invalid Credentials');");
					out.println("location='stafflogin.jsp';");
					out.println("</script>");

				} else {
					
					if(pass.equals(psw))
					{
					HttpSession session = request.getSession();
				    session.setAttribute("usernameStaff", mail);	
					response.sendRedirect("staffAuditLeaveDashboard.jsp");
					} 
					else 
					{
						out.println("<script type=\"text/javascript\">");
						out.println("alert('invalid credentials');");
						out.println("location='stafflogin.jsp';");
						out.println("</script>");
					}
				}
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

	}
}
