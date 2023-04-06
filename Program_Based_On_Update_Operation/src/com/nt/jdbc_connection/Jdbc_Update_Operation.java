package com.nt.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Jdbc_Update_Operation{
	
	public static void main(String[] args) {
		try {
			//for loading jdbc driver we need forName method which is belong to  
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");

			//for loading jdbc driver we need forName method which is belong to 
			//public static Class forName(String) throws java.lang.ClassNotFoundException; 
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");
		
		
			Statement stmt = con.createStatement(); 
			
			/// Code for delete any row from table BOOK

			// stmt.executeUpdate(" DELETE FROM BOOK WHERE NAME= 'BB' ");

			///// Code for changing data value from table BOOK

			stmt.executeUpdate(" UPDATE  BOOK SET  PRICE=150  WHERE NAME='HALF GIRLFRIEND' ");

			//// code for fetching data from database

			ResultSet rs = stmt.executeQuery(" SELECT * FROM BOOK  ");

			ResultSetMetaData rm = rs.getMetaData();

			int n = rm.getColumnCount();

			for (int i = 1; i <= n; i++) {
				System.out.print(rm.getColumnName(i) + " \t");

			}
			System.out.println();
			while (rs.next()) {

				for (int i = 1; i <= n; i++) {

					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();

			}

		} catch (Exception e) {

			System.err.println();

		}

	}
}

