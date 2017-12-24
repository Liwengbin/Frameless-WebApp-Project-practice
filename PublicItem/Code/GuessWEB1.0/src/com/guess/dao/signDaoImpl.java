package com.guess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.guess.domain.Sign;
import com.guess.util.dbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class signDaoImpl implements signDao {

	
	static Connection con;
	static ResultSet res=null;
	static PreparedStatement pstmt=null;
	private static final String ADD_SIGN="insert into guess_sign values(?,?,?,?,?)";
	//private static final String REMOVE_SIGN="delete from guess_sign where user_email=?";
	private static final String UPDATE_SIGN="update guess_sign set sign_dynamic=?,sign_share=?,sign_information=?,sign_blogger=? where user_email=?";
	private static final String LOAD_SIGN="select * from guess_sign where user_email=?";
	@Override
	public void addSign(Sign sign) {
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_SIGN);
			pstmt.setString(1, sign.getUser_email());
			pstmt.setString(2, Long.toString(sign.getSign_dynamic()));
			pstmt.setString(3, Long.toString(sign.getSign_share()));
			pstmt.setString(4, Long.toString(sign.getSign_information()));
			pstmt.setString(5, Long.toString(sign.getSign_blogger()));
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}

	}

	@Override
	public void removeSign(String user_email) {

	}

	@Override
	public void updateSign(Sign sign) {
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(UPDATE_SIGN);
			pstmt.setString(1, Long.toString(sign.getSign_dynamic()));
			pstmt.setString(2, Long.toString(sign.getSign_share()));
			pstmt.setString(3, Long.toString(sign.getSign_information()));
			pstmt.setString(4, Long.toString(sign.getSign_blogger()));
			pstmt.setString(5, sign.getUser_email());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}

	}

	@Override
	public Sign loadSign(String user_email) {
		dbUtil db=dbUtil.getInstance();
		Sign sign=new Sign();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_SIGN);
			pstmt.setString(1, user_email);
			res=pstmt.executeQuery();
			while (res.next()) {
				sign.setUser_email(res.getString("user_email"));
				sign.setSign_dynamic(Long.valueOf(res.getString("sign_dynamic")).longValue());
				sign.setSign_share(Long.valueOf(res.getString("sign_share")).longValue());
				sign.setSign_information(Long.valueOf(res.getString("sign_information")).longValue());
				sign.setSign_blogger(Long.valueOf(res.getString("sign_blogger")).longValue());
			 }
			} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return sign;
	}
	
	
}
