package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcConnection3 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");
			// code for static query

			Statement stmt = con.createStatement();

			// stmt.execute(" CREATE TABLE ZEONSOFTS(IDS NUMBER(3),NAME VARCHAR2(20),ADDS
			// VARCHAR2(20)) ");

			// stmt.executeUpdate(" INSERT INTO ZEONSOFTS VALUES(102,'RAJEEV','RANCHI ') ");
			/// stmt.executeUpdate(" INSERT INTO ZEONSOFTS VALUES(103,'RAJEEVIR','GAYA ')
			// ");
			/// stmt.executeUpdate(" INSERT INTO ZEONSOFTS VALUES(104,'RAUSHAN','RAJGIR ')
			// ");

			/// System.out.println("Data inserted into zeonsoft table");

			ResultSet rs = stmt.executeQuery("SELECT * FROM ZEONSOFTS ");

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

		} catch (Exception e)

		{

			System.err.println(e);
		}

	}

}
