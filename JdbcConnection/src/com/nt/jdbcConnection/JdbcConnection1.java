package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection1 {

	public static void main(String[] args) {

		// for loading jdbc driver we need forName method which is belong to
		// public static Class forName(String) throws java.lang.ClassNotFoundException;
		try {

			Class c = Class.forName("oracle.jdbc.driver.OracleDriver"); // Code for loading jdbc driver
			// for loading jdbc driver we need forName method which is belong to
			// public static Class forName(String) throws java.lang.ClassNotFoundException;

			// Connection
			// con=DriverManager.getConnection("jdbc:oracle:oci8:@xe","xe","XEE");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");

			System.out.println("Connection established succesfully");
			Statement stmt = con.createStatement(); // for writing static query for creating table we need
			// createStatement() method which is belong to
			// Statement interface and createStatement() method return type is
			// Statement

			// stmt.execute("create table zeonsoft(ids number(3),name varchar2(15),adds
			// varchar2(25))");
			// for creating a table we used execute(String) method;

			// System.out.println("One Table Created successfully");

			// executeUpdate(String) method used to insert data in table

			stmt.executeUpdate("insert into zeonsoft values(103,'Raju ','Patna' )");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
