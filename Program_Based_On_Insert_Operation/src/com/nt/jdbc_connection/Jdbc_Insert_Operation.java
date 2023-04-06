package com.nt.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_Insert_Operation{
	
	public static void main(String[] args) {
		try {
			//for loading jdbc driver we need forName method which is belong to  
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");

			//for loading jdbc driver we need forName method which is belong to 
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");
		
		
			Statement stmt = con.createStatement(); // for writing static query for creating table we need
			// createStatement() method which is belong to
			// Statement interface and createStatement() method return type is
			// Statement

			// stmt.execute("create table zeonsoft(ids number(3),name varchar2(15),adds
			// varchar2(25))");
			// for creating a table we used execute(String) method;

			// System.out.println("One Table Created successfully");

			// executeUpdate(String) method used to insert data in table

			stmt.executeUpdate("insert into zeonsoft values(106,'Rajnish ','Patna' )");
			System.out.println("Record Inserted Succesfully");
		} catch (Exception e)

		{
			System.err.print(e);

		}

	}


}
