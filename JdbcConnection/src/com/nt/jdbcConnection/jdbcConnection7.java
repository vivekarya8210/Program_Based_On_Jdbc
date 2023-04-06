package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class jdbcConnection7 {

	public static void main(String[] args) {
		Scanner sc;
		/// code for loading driver
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver ");
			sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "xe");

			PreparedStatement pmt = con.prepareStatement("   INSERT INTO BOOK VALUES(?,?,?) ");

			System.out.println("Enter Book Name");
			pmt.setString(1, sc.next());
			System.out.println("Enter Book's Auther Name");
			pmt.setString(2, sc.next());
			System.out.print("Enter Book Price");
			pmt.setInt(3, sc.nextInt());

			System.out.println("Record inserted successfully");
			ResultSet rs = pmt.executeQuery(" SELECT * FROM BOOK ");

			ResultSetMetaData rm = rs.getMetaData();

			int n = rm.getColumnCount();

			for (int i = 1; i <= n; i++) {

				System.out.println(rm.getColumnName(i) + "\t");
			}
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <= n; i++) {
					System.out.print(rs.getString(i) + "\t");

				}
				System.out.println();                  //for change the line for second row elements
			}
		} catch (Exception e) {

			System.err.println(e);

		}

	}

}
