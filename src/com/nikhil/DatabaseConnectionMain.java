package com.nikhil;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnectionMain {
	public Connection getConnection() {
		Connection connObj = null;
		String JDBC_URL = "jdbc:sqlserver://MUM-606Z2B3\\MSSQLSERVER04;DatabaseName=LeaveManagementSys;trustServerCertificate=true;encrypt=false;";
		
		Logger databaseLogger = LogManager.getLogger(DatabaseConnectionMain.class.getName());
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL, "sa", "root");
			if (connObj != null) {
				databaseLogger.info("Successfully Connected to Database main");
				return connObj;
			}
		} catch (Exception sqlException) {
			databaseLogger.error("Failed to connect to database {}", sqlException.getMessage());
		}
		return connObj;
	}
}
