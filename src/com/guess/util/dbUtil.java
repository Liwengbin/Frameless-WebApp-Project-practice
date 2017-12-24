package com.guess.util;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 
 * @author ���ݿ�����
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
	 * ����˽�й��췽��
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
	 * ������
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getCon()
	{
		try {
			Class.forName(JDBC_NAME);
		} catch (Exception e) {
		System.out.println("����������ʧ��");
		}
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * �ͷſռ�
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
