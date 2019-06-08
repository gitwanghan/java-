package com.bdqn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Todb {
	String name="root";
	String pwd="root";
	String url="jdbc:mysql://localhost:3306/personnel??useSSL=false&serverTimezone=UTC";
	String driver="com.mysql.jdbc.Driver";
	
	public Connection getConnection()
	{
		
		Connection con=null;
		//¼ÓÔØÇý¶¯
		try {
			Class.forName(driver);
			try {
				con=DriverManager.getConnection(url, name, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
