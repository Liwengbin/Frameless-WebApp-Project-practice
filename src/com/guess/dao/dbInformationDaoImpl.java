/**
 * 
 */
package com.guess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guess.domain.Information_minute;
import com.guess.util.dbUtil;
import com.guess.util.toolsUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author ÀîÎÄ±ø
 *
 */
public class dbInformationDaoImpl implements dbInformationDao {
	
	static Connection con;
	static ResultSet res=null;
	static PreparedStatement pstmt=null;
	
	private static final String ADD_INFORMATION_MINUTE="insert into information_minute values(?,?,?,?,?,?,?,?,?)";
	private static final String REMOVE_INFORMATION_MINUTE="delete from information_minute where user_email=? and information_id=?";
	private static final String LOADALL_INFORMATION_MINUTE="select * from information_minute order by information_time DESC";
	private static final String LOAD_INFORMATION_MINUTE="select * from information_minute where user_email=? and information_id=?";
	
	@Override
	public void addInformation_minute(Information_minute information) {
		
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_INFORMATION_MINUTE);
			pstmt.setString(1, information.getUser_email());
			pstmt.setString(2, information.getInformation_id());
			pstmt.setString(3, information.getInformation_filename());
			pstmt.setString(4, information.getInformation_size());
			pstmt.setString(5, information.getInformation_type());
			pstmt.setString(6, information.getInformation_txt());
			pstmt.setLong(7, information.getInformation_praise());
			pstmt.setString(8, information.getInformation_time());
			pstmt.setString(9, information.getInformation_address());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	@Override
	public void removeInformation_minute(
			Information_minute information) {
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_INFORMATION_MINUTE);
			pstmt.setString(1, information.getUser_email());
			pstmt.setString(2, information.getInformation_id());
			int num = pstmt.executeUpdate();
			if(num!=1)
			{
				throw new RuntimeException("É¾³ýÊ§°Ü£¡");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
		
	}
	
	@Override
	public ArrayList<Information_minute> loadAllInformation_minute() {
		
		dbUtil db=dbUtil.getInstance();
		ArrayList<Information_minute> informationList=new ArrayList<Information_minute>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_INFORMATION_MINUTE);
			res=pstmt.executeQuery();
			while (res.next()) {
				Information_minute list=new Information_minute();
				list.setUser_email(res.getString("user_email"));
				list.setInformation_id(res.getString("information_id"));
				list.setInformation_filename(res.getString("information_filename"));
				list.setInformation_size(res.getString("information_size"));
				list.setInformation_type(res.getString("information_type"));
				list.setInformation_txt(res.getString("information_txt"));
				list.setInformation_praise(res.getInt("information_praise"));
				list.setInformation_time(toolsUtil.getDate(res.getString("information_time")));
				list.setInformation_address(res.getString("information_address"));
				informationList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return informationList;
	}
	
	@Override
	public Information_minute loadInformation_minute(
			Information_minute information) {
		
		dbUtil db=dbUtil.getInstance();
		Information_minute list=new Information_minute();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_INFORMATION_MINUTE);
			pstmt.setString(1, information.getUser_email());
			pstmt.setString(2, information.getInformation_id());
			/*pstmt.setString(3, information.getInformation_filename());*/
			res=pstmt.executeQuery();
			while (res.next()) {
				list.setUser_email(res.getString("user_email"));
				list.setInformation_id(res.getString("information_id"));
				list.setInformation_filename(res.getString("information_filename"));
				list.setInformation_size(res.getString("information_size"));
				list.setInformation_type(res.getString("information_type"));
				list.setInformation_txt(res.getString("information_txt"));
				list.setInformation_praise(res.getInt("information_praise"));
				list.setInformation_time(toolsUtil.getDate(res.getString("information_time")));
				list.setInformation_address(res.getString("information_address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return list;
	}
	
}
