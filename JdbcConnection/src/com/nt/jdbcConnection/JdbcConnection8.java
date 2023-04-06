package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcConnection8 {
	
	public static void main(String[] args) {
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","xe","xe");
		
		PreparedStatement pmt=con.prepareStatement(" CREATE TABLE TEMP( NAME VARCHAR2(20),ADDS VARCHAR2(20))"); 
		ResultSet rs=pmt.executeQuery();
		
		System.out.println("one table created successfully");
		
        pmt=con.prepareStatement("INSERT INTO TEMP VALUES( ?,?) ");
		
		pmt.setString(1,args[0]);
		pmt.setString(2,args[1]);
		 rs=pmt.executeQuery();
		System.out.println("One record inserted successfully");
		}catch(Exception e)
		
		{
			System.err.print(e);
		}
		}

}
