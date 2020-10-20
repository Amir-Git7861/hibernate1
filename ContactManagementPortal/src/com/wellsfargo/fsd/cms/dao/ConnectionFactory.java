package com.wellsfargo.fsd.cms.dao;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	
	private static DataSource datasource;
	
	public static java.sql.Connection getConnection() throws SQLException{
		
		
		if(datasource==null) {
			
			try {
				InitialContext context = new InitialContext();
				datasource=(DataSource) context.lookup("java:/comp/env/jdbc/MYDB");
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
			
		}
		return datasource.getConnection();
		
	}

}
