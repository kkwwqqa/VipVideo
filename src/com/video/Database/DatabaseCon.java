package com.video.Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

  
public class DatabaseCon {
	
	private String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private String DADABASE_URL="jdbc:mysql://localhost:3306/video";
	private String DADABASE_USER = "root";
	private String DADABASE_PASSWORD = "root";


	
	public Connection getConnection() {
		// 声明一个数据库连接
		Connection con = null;
		try {
			// 加载驱动
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 连接数据库，输入连接数据库的地址，用户名，密码。
			con = (Connection) DriverManager.getConnection(DADABASE_URL, DADABASE_USER, DADABASE_PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	// 关闭Connection
	public void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭ResultSetF
	public void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭Statement
	public void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}