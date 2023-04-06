package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	public static void main(String[] args) {
		try {
			//for loading jdbc driver we need forName method which is belong to  
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");

			//for loading jdbc driver we need forName method which is belong to 
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");
			System.out.println("Connection Establish succesfully");
		} catch (Exception e)

		{
			System.err.print(e);

		}

	}

}
