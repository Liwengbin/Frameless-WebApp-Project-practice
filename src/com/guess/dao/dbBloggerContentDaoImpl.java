/**
 * 
 */
package com.guess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guess.domain.Blogger_content;
import com.guess.util.dbUtil;
import com.guess.util.toolsUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author ÀîÎÄ±ø
 *
 */
public class dbBloggerContentDaoImpl implements dbBloggerContentDao {

	static Connection con;
	static ResultSet res=null;
	static PreparedStatement pstmt=null;
	
	private static final String ADD_BLOGGER_CONTENT="insert into blogger_content values(?,?,?,?,?,?,?)";
	private static final String REMOVE_BLOGGER_CONTENT="delete from blogger_content where user_email=? and blogger_id=?";
	private static final String LOADALL_BLOGGER_CONTENT="select * from blogger_content order by blogger_praise DESC";
	private static final String LOAD_BLOGGER_CONTENT="select * from blogger_content where user_email=? and blogger_id=?";
	
	/* (non-Javadoc)
	 * @see com.guess.dao.dbBloggerContentDao#addBlogger_content(com.guess.domain.Blogger_content)
	 */
	@Override
	public void addBlogger_content(Blogger_content blogger_content) {
		// TODO Auto-generated method stub
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_BLOGGER_CONTENT);
			pstmt.setString(1, blogger_content.getUser_email());
			pstmt.setString(2, blogger_content.getBlogger_id());
			pstmt.setString(3, blogger_content.getBlogger_name());
			pstmt.setString(4, blogger_content.getBlogger_txt());
			pstmt.setInt(5, blogger_content.getBlogger_praise());
			pstmt.setString(6, blogger_content.getBlogger_time());
			pstmt.setString(7, blogger_content.getBlogger_type());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}

	/* (non-Javadoc)
	 * @see com.guess.dao.dbBloggerContentDao#removeBlogger_content(com.guess.domain.Blogger_content)
	 */
	@Override
	public void removeBlogger_content(Blogger_content blogger_content) {
		// TODO Auto-generated method stub
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_BLOGGER_CONTENT);
			pstmt.setString(1, blogger_content.getUser_email());
			pstmt.setString(2, blogger_content.getBlogger_id());
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

	/* (non-Javadoc)
	 * @see com.guess.dao.dbBloggerContentDao#loadAllBlogger_content()
	 */
	@Override
	public ArrayList<Blogger_content> loadAllBlogger_content() {
		// TODO Auto-generated method stub
		dbUtil db=dbUtil.getInstance();
		ArrayList<Blogger_content> bloggercontentlist=new ArrayList<Blogger_content>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_BLOGGER_CONTENT);
			res=pstmt.executeQuery();
			while (res.next()) {
				Blogger_content list=new Blogger_content();
				list.setUser_email(res.getString("user_email"));
				list.setBlogger_id(res.getString("blogger_id"));
				list.setBlogger_name(res.getString("blogger_name"));
				list.setBlogger_txt(res.getString("blogger_txt"));
				list.setBlogger_praise(res.getInt("blogger_praise"));
				list.setBlogger_time(toolsUtil.getDate(res.getString("blogger_time")));
				list.setBlogger_type(res.getString("blogger_type"));
				bloggercontentlist.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return bloggercontentlist;
	}

	/* (non-Javadoc)
	 * @see com.guess.dao.dbBloggerContentDao#loadBlogger_content(com.guess.domain.Blogger_content)
	 */
	@Override
	public Blogger_content loadBlogger_content(Blogger_content blogger_content) {
		// TODO Auto-generated method stub
		dbUtil db=dbUtil.getInstance();
		Blogger_content list=new Blogger_content();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_BLOGGER_CONTENT);
			pstmt.setString(1, blogger_content.getUser_email());
			pstmt.setString(2, blogger_content.getBlogger_id());
			/*pstmt.setString(3, information.getInformation_filename());*/
			res=pstmt.executeQuery();
			while (res.next()) {
				list.setUser_email(res.getString("user_email"));
				list.setBlogger_id(res.getString("blogger_id"));
				list.setBlogger_name(res.getString("blogger_name"));
				list.setBlogger_txt(res.getString("blogger_txt"));
				list.setBlogger_praise(res.getInt("blogger_praise"));
				list.setBlogger_time(toolsUtil.getDate(res.getString("blogger_time")));
				list.setBlogger_type(res.getString("blogger_type"));
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
