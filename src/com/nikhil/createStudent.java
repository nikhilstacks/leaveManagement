package com.nikhil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createStudent
 */
@WebServlet("/createStudent")
public class createStudent extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   Connection connObj;
	       String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";
	       
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
	            if(connObj != null) {
	                DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
	                System.out.println("successfully connected");
	                
//	                String get = "select username as name, pass from login where pass= 123";
//	                Statement statement = connObj.createStatement();
//	                
//	                ResultSet rs = statement.executeQuery(get);
//	                String name = null;
//	                int pass = 0;
//	                while(rs.next()){
//	                	name = rs.getString("name");
//	                	pass = rs.getInt("pass");
//	                }
//	                
//	                System.out.println("agar ye chal gaya chandi hojaegii bccccccccc");
//	                System.out.println("name from query is: " + name + " pass word from query is: "+  pass);
//	                
//	                int rows = statement.executeUpdate(qry);
//	                
//	                if(rows > 0 ){
//	                	System.out.println("data inserted successfully...");
//	                } else {
//	                	System.out.println("try again");
//	                }
	                connObj.close();
	                response.sendRedirect("studentLogin.jsp");
	            } 
	        } catch(Exception sqlException) {
	            sqlException.printStackTrace();
	        }
	        
	}
		
}
