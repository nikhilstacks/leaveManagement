package com.nikhil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet Filter implementation class Validation
 */
@WebFilter("/createStudent")
public class Validation implements Filter {

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("inside filter");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String mail = request.getParameter("mail");
		String psw = request.getParameter("psw");
		
		
		
		Connection connObj;
	       String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";
	       
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
	            if(connObj != null) {
	                System.out.println("successfully connected validation");
	                ResultSet rs;
	                
	                Statement statement = connObj.createStatement();
	                String qry = "Select * from student where email=?";
	               

				PreparedStatement pstmt = connObj.prepareStatement(qry,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();
	            String CheckMail = null;  
				while(rs.next()){
		            //Display values
		            CheckMail = rs.getString("email");
		         }
	                if(CheckMail == null)
	                {
	                	if(uname.length() < 2 || psw.length() < 8)
	            		{
	            			HttpServletResponse httpResponse = (HttpServletResponse) response;
	            			out.println("<script type=\"text/javascript\">");
	            			   out.println("alert('Insert Valid data');");
	            			   out.println("location='createStudent.jsp';");
	            			   out.println("</script>");
	            			   
	            			   System.out.println("inside validation for create user");
//	            			httpResponse.sendRedirect("createStudent.jsp");
	            		} 
	                	else chain.doFilter(request, response);
	                } 
	                else 
	                {
	                   out.println("<script type=\"text/javascript\">");
         			   out.println("alert('Email already registered');");
         			   out.println("location='createStudent.jsp';");
         			   out.println("</script>");
	                }
	                
	            }
	        } catch(Exception sqlException) {
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
