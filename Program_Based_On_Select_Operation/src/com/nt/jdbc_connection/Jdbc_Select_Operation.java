package com.nt.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Jdbc_Select_Operation{
	
	public static void main(String[] args) {
		try {
			//for loading jdbc driver we need forName method which is belong to  
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");

			//for loading jdbc driver we need forName method which is belong to 
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");
		
		
			Statement stmt = con.createStatement(); 
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM ZEONSOFT ");

			ResultSetMetaData rm = rs.getMetaData();

			int n = rm.getColumnCount();

			for (int i = 1; i <= n; i++) {

				System.out.print(rm.getColumnName(i) + " \t\t ");
			}
			System.out.println();
			while (rs.next()) {

				for (int i = 1; i <= n; i++) {

					System.out.print(rs.getString(i) + "\t\t");

				}
				System.out.println();
		}
		}catch (Exception e) {
			System.err.print(e);

		}

	

	}
}

