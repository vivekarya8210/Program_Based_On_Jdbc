package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class jdbcConnection6 {

	public static void main(String[] args) {

		/// code for loading driver
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver ");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");

			Statement stmt = con.createStatement();

			/// stmt.execute(" CREATE TABLE BANK(NAME VARCHAR2(20) ,IFSC NUMBER(10),ADDS
			/// VARCHAR2(20))");

			/// stmt.executeUpdate("INSERT INTO BANK VALUES('SBI',52864975,'AMEERPET' ) ");

			/// stmt.executeUpdate("INSERT INTO BANK VALUES('PNB',52823564,'PUNJAGUTTA' )
			/// ");

			ResultSet rs = stmt.executeQuery("SELECT * FROM BANK ");

			ResultSetMetaData rm = rs.getMetaData();

			int n = rm.getColumnCount();
			for (int i = 1; i <= n; i++) {

				System.out.print(rm.getColumnName(i) + " \t");

			}
			System.out.println();

			while (rs.next()) {

				for (int i = 1; i <= n; i++) {
					System.out.print(rs.getString(i) + " \t");
				}
				System.out.println();
			}

		} catch (Exception e) {

			System.err.println(e);

		}

	}

}
