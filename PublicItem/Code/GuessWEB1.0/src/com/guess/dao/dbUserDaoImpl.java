/**
 * 
 */
package com.guess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guess.domain.User_basic;
import com.guess.domain.User_minute;
import com.guess.exception.DataAccessException;
import com.guess.util.dbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author 李文兵
 *
 */
public class dbUserDaoImpl implements dbUserDao {

	static Connection con;
	static ResultSet res=null;
	static PreparedStatement pstmt=null;
	private static final String ADD_USER_BASIC="insert into user_basic values(?,?,?)";
	private static final String REMOVE_USER_BASIC="delete from user_basic where user_email=?";
	private static final String UPDATE_USER_BASIC="update user_basic set user_name=?,user_Password=? where user_email=?";
	private static final String LOADALL_USER_BASIC="select * from user_basic";
	private static final String LOAD_USER_BASIC="select * from user_basic where user_email=?";

	private static final String ADD_USER_MINUTE="insert into user_minute values(?,?,?,?,?)";
	private static final String REMOVE_USER_MINUTE="delete from user_minute where user_email=?";
	private static final String UPDATE_USER_MINUTE="update user_minute set user_sex=?,user_age=?,user_headimg=?,user_signature=? where user_email=?";
	private static final String LOADALL_USER_MINUTE="select * from user_minute";
	private static final String LOAD_USER_MINUTE="select * from user_minute where user_email=?";
	
	/**
	 * 数据添加（表User_basic）
	 * @param User_basic(String user_email,String user_name,String user_password)
	 */
	@Override
	public void addUser_basic(User_basic user)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_USER_BASIC);
			pstmt.setString(1, user.getUser_email());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_password());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	/**
	 * 用户基本信息修改（表User_basic）
	 * @param User_basic(String user_email,String user_name,String user_password)
	 */
	@Override
	public void updateUser_basic(User_basic user)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(UPDATE_USER_BASIC);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_email());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			if(e.getMessage().contains("Duplicate entry"))
				throw new RuntimeException("数据已经存在！");
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	/**
	 * 查找User_basic表中所有的数据
	 * @param User_basic user
	 * @return ArrayList<User_basic>类型
	 */
	@Override
	public ArrayList<User_basic> loadAlluser_basic()
	{
		dbUtil db=dbUtil.getInstance();
		ArrayList<User_basic> userList=new ArrayList<User_basic>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_USER_BASIC);
			res=pstmt.executeQuery();
			while (res.next()) {
				User_basic userlist=new User_basic();
				userlist.setUser_email(res.getString("user_email"));
				userlist.setUser_name(res.getString("user_name"));
				userlist.setUser_password(res.getString("user_password"));
				userList.add(userlist);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return userList;
	}	

	/**
	 * 查找User_basic表中的具体数据
	 * @param String user_email
	 * @return User_basic类型
	 */
	@Override
	public User_basic loaduser_basic(String user_email)
	{
		dbUtil db=dbUtil.getInstance();
		User_basic user=new User_basic();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_USER_BASIC);
			pstmt.setString(1, user_email);
			res=pstmt.executeQuery();
				if(res.next()) 
				{
					user.setUser_email(res.getString("user_email"));
					user.setUser_name(res.getString("user_name"));
					user.setUser_password(res.getString("user_password"));
				}
				else
				{
					throw new DataAccessException(user_email+"用户不存在,请注册!");
				}
			} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return user;
	}	
	
	/**
	 * 删除用户（User_basic）
	 * @param String user_email
	 */
	@Override
	public void removeUser_basic(String User_email)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_USER_BASIC);
			pstmt.setString(1, User_email);
			int num = pstmt.executeUpdate();
			if(num!=1)
			{
				throw new RuntimeException("删除失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	
	
	/**
	 * 数据添加(表User_minute)
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 */
	@Override
	public void addUser_minute(User_minute user)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_USER_MINUTE);
			pstmt.setString(1, user.getUser_email());
			pstmt.setString(2, user.getUser_sex());
			pstmt.setString(3,String.valueOf(user.getUser_age()));
			pstmt.setString(4, user.getUser_headimg());
			pstmt.setString(5, user.getUser_signature());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	/**
	 * 用户基本信息修改（表User_minute）
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 */
	@Override
	public void updateUser_minute(User_minute user)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(UPDATE_USER_MINUTE);
			pstmt.setString(1, user.getUser_sex());
			pstmt.setString(2,Integer.toString(user.getUser_age()));
			pstmt.setString(3, user.getUser_headimg());
			pstmt.setString(4, user.getUser_signature());
			pstmt.setString(5, user.getUser_email());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	/**
	 * 查找User_minute表中所有的数据
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 * @return ArrayList<User_basic>类型
	 */
	@Override
	public ArrayList<User_minute> loadAlluser_minute()
	{
		dbUtil db=dbUtil.getInstance();
		ArrayList<User_minute> userList=new ArrayList<User_minute>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_USER_MINUTE);
			res=pstmt.executeQuery();
			while (res.next()) {
				User_minute userlist=new User_minute();
				userlist.setUser_email(res.getString("user_email"));
				userlist.setUser_sex(res.getString("user_sex"));
				userlist.setUser_age(Integer.parseInt(res.getString("user_age")));//Integer.parseInt(str);
				userlist.setUser_headimg(res.getString("user_headimg"));
				userlist.setUser_signature(res.getString("user_signature"));
				userList.add(userlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return userList;
	}	
	
	
	/**
	 * 查找User_minute表中具体的数据
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 * @return User_minute类型
	 */
	@Override
	public User_minute loaduser_minute(String user_email)
	{
		dbUtil db=dbUtil.getInstance();
		User_minute userlist=new User_minute();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_USER_MINUTE);
			pstmt.setString(1, user_email);
			res=pstmt.executeQuery();
			while (res.next()) {
				userlist.setUser_email(res.getString("user_email"));
				userlist.setUser_sex(res.getString("user_sex"));
				userlist.setUser_age(Integer.parseInt(res.getString("user_age")));//Integer.parseInt(str);
				userlist.setUser_headimg(res.getString("user_headimg"));
				userlist.setUser_signature(res.getString("user_signature"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return userlist;
	}	
	
	/**
	 * 删除用户详细信息（User_minute）
	 * @param String user_email
	 */
	@Override
	public void removeUser_minute(String user_email)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_USER_MINUTE);
			pstmt.setString(1, user_email);
			int num = pstmt.executeUpdate();
			if(num!=1)
			{
				throw new RuntimeException("删除失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
}
