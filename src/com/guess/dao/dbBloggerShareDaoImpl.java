package com.guess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guess.domain.Blogger_share;
import com.guess.util.dbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class dbBloggerShareDaoImpl implements dbBloggerShareDao {

	static Connection con;
	static ResultSet res=null;
	static PreparedStatement pstmt=null;
	
	private static final String ADD_BLOGGER_SHARE="insert into blogger_share values(?,?,?,?,?,?)";
	private static final String REMOVE_BLOGGER_SHARE="delete from blogger_share where user_email=? and share_number=?";
	
	private static final String LOADALL_BLOGGER_SHARE="select * from blogger_share";
	
	@Override
	public void addBlogger_share(Blogger_share blogger_share) {
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_BLOGGER_SHARE);
			pstmt.setString(1, blogger_share.getUser_email());
			pstmt.setString(2, blogger_share.getShare_number());
			pstmt.setString(3, blogger_share.getShare_page());
			pstmt.setString(4, blogger_share.getShare_time());
			pstmt.setString(5, blogger_share.getShare_describe());
			pstmt.setString(6, blogger_share.getShare_web_url());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
		
	}

	@Override
	public void removeBlogger_share(Blogger_share blogger_share) {
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_BLOGGER_SHARE);
			pstmt.setString(1, blogger_share.getUser_email());
			pstmt.setString(2, blogger_share.getShare_number());
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
	public ArrayList<Blogger_share> loadAllBlogger_share() {
		dbUtil db=dbUtil.getInstance();
		ArrayList<Blogger_share> blogger_sharelist=new ArrayList<Blogger_share>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_BLOGGER_SHARE);
			res=pstmt.executeQuery();
			while (res.next()) {
				Blogger_share list=new Blogger_share();
				list.setShare_describe(res.getString("share_describe"));
				list.setShare_number(res.getString("share_number"));
				list.setShare_page(res.getString("share_page"));
				list.setShare_time(res.getString("share_time"));
				list.setUser_email(res.getString("user_email"));
				list.setShare_web_url(res.getString("share_web_url"));
				blogger_sharelist.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return blogger_sharelist;
	}

}
