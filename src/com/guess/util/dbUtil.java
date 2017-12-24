package com.guess.util;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 
 * @author 数据库链接
 * @author DB_USERNAME="root"
 * @author DB_URL="jdbc:mysql://127.0.0.1:3306/db_exchangestu?useUnicode=true&characterEncoding=utf-8&useSSL=false";
 */
public class dbUtil 
{
	private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/guess_db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="12345678";
	private static final String JDBC_NAME="com.mysql.jdbc.Driver";
	private static final dbUtil DB_UTIL = new dbUtil();
	/**
	 * 返回私有构造方法
	 * @return
	 */
	public static dbUtil getInstance()
	{
		return DB_UTIL;
	}
	
	private dbUtil()
	{	
	}
	
	/**
	 * 打开链接
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getCon()
	{
		try {
			Class.forName(JDBC_NAME);
		} catch (Exception e) {
		System.out.println("驱动包加载失败");
		}
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 释放空间
	 * @param Connection
	 * @param PreparedStatement
	 * @param ResultSet
	 */
	public void release(Connection con,PreparedStatement pstmt,ResultSet res)
	{
			try {
				if(res!=null)res.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}		
}
