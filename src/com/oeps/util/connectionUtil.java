package com.oeps.util;

import java.sql.*;

/**
 * 
 * This is the Database connection creation class.
 * 
 * @author S M Jayasekara - IT 19 1616 48
 *
 */

public class connectionUtil {

	
	private static Connection connection;
	
	
	// This works according to singleton pattern
	private connectionUtil() {}
	
	/**
	 * 
	 * Create Database connection for the system database by passing url, user name and password.
	 * 
	 * This static method  returns the Connection.
	 * 
	 * All the possible Exceptions are throws away.
	 *
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/oeps";
		String uname = "root";
		String password ="";
		
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, password);
		}
		return connection;
	}

}
