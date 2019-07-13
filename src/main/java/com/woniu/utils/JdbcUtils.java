package com.woniu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String pwd = "woniu";
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn = tl.get();
		if(conn == null) {
			conn = DriverManager.getConnection(url,user,pwd);
			tl.set(conn);
		}
		
		return conn;
	}
	
	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if(conn != null) {
						conn.close();
						tl.remove();  // һ������д���д��룬���������"�ڴ�й¶"
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
	}
	
}
