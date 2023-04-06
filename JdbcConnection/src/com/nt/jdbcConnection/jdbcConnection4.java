package com.nt.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class jdbcConnection4 {

	public static void main(String[] args) {
		
		//code for loading driver class
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//code for establish connection with database
		
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","xe","XEE");
		
		
		
		    Statement stmt=con.createStatement();
		    
		    ResultSet rs=stmt.executeQuery("SELECT *FROM ZEONSOFTS");
		    
		    ResultSetMetaData rm=rs.getMetaData();
		     int n=rm.getColumnCount();
		     for(int i=1;i<=n;i++) {
		    	 
		    	 
		    	 System.out.print(rm.getColumnName(i)+"\t");
		    	 
		     }
	        System.out.println();
	        
	        while(rs.next()) {
	        	
	        	
	        	for(int i=1;i<=n;i++) {
	        		
	        		System.out.print(rs.getString(i)+"\t");
	        		
	        	}
	        	System.out.println();
	        }
		
		}catch(Exception e)
		{
			System.err.println(e);
		}

	}

}
