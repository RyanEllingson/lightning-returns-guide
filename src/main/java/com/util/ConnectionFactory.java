package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private static Connection conn;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
				conn = ds.getConnection();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}
