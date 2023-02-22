package com.nikhil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionMain {
	public Connection getConnection() {
		Connection connObj = null;
		String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
			if (connObj != null) {
				System.out.println("successfully connected");
				return connObj;
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return connObj;
	}
}
