package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class jdbcConnection5 {

	public static void main(String[] args) {

		try {

			/// code for loading jdbc driver

			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");

			//// Code for establish connection with database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");

			//// code for execute static query

			Statement stmt = con.createStatement();

			// stmt.execute("CREATE TABLE BOOK( NAME VARCHAR2(25),AUTHER VARCHAR2(20),PRICE
			// NUMBER(5))");

			/// code for insert values in table

			// stmt.executeUpdate("INSERT INTO BOOK( 'HALF GIRLFRIEND','CHETAN BHAGAT',850)
			// ");

			/// Code for delete any row from table BOOK

			// stmt.executeUpdate(" DELETE FROM BOOK WHERE NAME= 'BB' ");

			///// Code for changing data value from table BOOK

			stmt.executeUpdate(" UPDATE  BOOK SET  PRICE=50  WHERE NAME='HALF GIRLFRIEND' ");

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
