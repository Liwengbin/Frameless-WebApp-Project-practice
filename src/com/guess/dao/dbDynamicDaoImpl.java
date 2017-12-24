package com.guess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guess.domain.Dynamic_content;
import com.guess.domain.Interaction_content;
import com.guess.util.dbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class dbDynamicDaoImpl implements dbDynamicDao {

	static Connection con;
	static ResultSet res=null;
	static PreparedStatement pstmt=null;
	
	private static final String ADD_DYNAMIC_CONTENT="insert into dynamic_content values(?,?,?,?,?,?)";
	private static final String REMOVE_DYNAMIC_CONTENT="delete from dynamic_content where user_email=? and dynamic_id=?";
	private static final String LOADALL_DYNAMIC_CONTENT="select * from dynamic_content order by dynamic_time DESC";
	private static final String LOAD_DYNAMIC_CONTENT="select * from dynamic_content where user_email=? and dynamic_id=?";
	
	private static final String ADD_INTERACTION_CONTENT="insert into interaction_content values(?,?,?,?,?,?)";
	private static final String REMOVE_INTERACTION_CONTENT="delete from interaction_content where user_email=? and dynamic_id=? and interaction_email=? and interaction_time=?";
	private static final String LOADALL_INTERACTION_CONTENT="select * from interaction_content where user_email=? and dynamic_id=?";
	private static final String LOAD_INTERACTION_CONTENT="select * from interaction_content where user_email=? and dynamic_id=? and interaction_email=? and interaction_time=?";
	
	/**
	 * 数据添加（表Dynamic_content）
	 * @param Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv,String dynamic_img, String dynamic_time)
	 */
	@Override
	public void addDynamic_content(Dynamic_content dynamic)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_DYNAMIC_CONTENT);
			pstmt.setString(1, dynamic.getUser_email());
			pstmt.setString(2, dynamic.getDynamic_id());
			pstmt.setString(3, dynamic.getDynamic_txt());
			pstmt.setString(4, dynamic.getDynamic_tv());
			if(dynamic.getDynamic_img()!=null)
			{
			/*将string数组转为stringBuffer字符串以“|”分割*/
			StringBuffer imgpath=new StringBuffer();
			for(String img:dynamic.getDynamic_img())
				imgpath.append(img).append("|");
			imgpath.deleteCharAt(imgpath.length()-1);
			pstmt.setString(5, imgpath.toString());
			}
			else
			{
			pstmt.setString(5, null);
			}
			pstmt.setString(6, dynamic.getDynamic_time());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
		
	/**
	 * 查找Dynamic_content表中具体的数据
	 * @param Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv,String dynamic_img, String dynamic_time)
	 * @return ArrayList<Dynamic_content>类型
	 * @author dynamic_tv储存视频路径
	 * @author dynamic_img储存图片路径		 
	 */
	@Override
	public Dynamic_content loadDynamic_content(Dynamic_content dynamic)
	{
		dbUtil db=dbUtil.getInstance();
		Dynamic_content list=new Dynamic_content();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_DYNAMIC_CONTENT);
			pstmt.setString(1, dynamic.getUser_email());
			pstmt.setString(2, dynamic.getDynamic_id());
			res=pstmt.executeQuery();
			while (res.next()) {
				list.setUser_email(res.getString("user_email"));
				list.setDynamic_id(res.getString("dynamic_id"));
				list.setDynamic_txt(res.getString("dynamic_txt"));
				list.setDynamic_tv(res.getString("dynamic_tv"));
				if(res.getString("dynamic_img")!=null)
				{
				list.setDynamic_img(res.getString("dynamic_img").split("\\|"));/** 从数据库中读取字符串，以|为切割符，切割为字符数组*/
				}
				else
				{
				list.setDynamic_img(null);
				}
				list.setDynamic_time(res.getString("dynamic_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return list;
	}	
	
	/**
	 * 查找Dynamic_content表中的所有数据
	 * @return ArrayList<Dynamic_content>类型Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv,String dynamic_img, String dynamic_time)
	 * @author dynamic_tv储存视频路径
	 * @author dynamic_img储存图片路径		 
	 */
	@Override
	public ArrayList<Dynamic_content> loadAllDynamic_content()
	{
		dbUtil db=dbUtil.getInstance();
		ArrayList<Dynamic_content> dynamicList=new ArrayList<Dynamic_content>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_DYNAMIC_CONTENT);
			res=pstmt.executeQuery();
			while (res.next()) {
				Dynamic_content list=new Dynamic_content();
				list.setUser_email(res.getString("user_email"));
				list.setDynamic_id(res.getString("dynamic_id"));
				list.setDynamic_txt(res.getString("dynamic_txt"));
				list.setDynamic_tv(res.getString("dynamic_tv"));
				if(res.getString("dynamic_img")!=null)
				{
				list.setDynamic_img(res.getString("dynamic_img").split("\\|"));/** 从数据库中读取字符串，以|为切割符，切割为字符数组*/
				}
				else
				{
				list.setDynamic_img(null);
				}
				list.setDynamic_time(res.getString("dynamic_time"));
				dynamicList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return dynamicList;
	}
	
	
	/**
	 * 删除动态（Dynamic_content）
	 * @param Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv,String dynamic_img, String dynamic_time)
	 */
	@Override
	public void removeDynamic_content(Dynamic_content dynamic)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_DYNAMIC_CONTENT);
			pstmt.setString(1, dynamic.getUser_email());
			pstmt.setString(2, dynamic.getDynamic_id());
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
	 * 数据添加（表Interaction_content）
	 * @param Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time)
	 */
	@Override
	public void addInteraction_content(Interaction_content interaction)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(ADD_INTERACTION_CONTENT);
			pstmt.setString(1, interaction.getUser_email());
			pstmt.setString(2, interaction.getDynamic_id());
			pstmt.setString(3, interaction.getInteraction_email());
			pstmt.setString(4, interaction.getInteraction_praise());
			pstmt.setString(5, interaction.getInteraction_txt());
			pstmt.setString(6, interaction.getInteraction_time());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	/**
	 * 查找Interaction_content表中的所有数据数据
	 * @param Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time)
	 * @return ArrayList<Interaction_content>类型
	 */
	@Override
	public ArrayList<Interaction_content> loadAllInteraction_content(String user_email,String Dynamic_id)
	{
		dbUtil db=dbUtil.getInstance();
		ArrayList<Interaction_content> userList=new ArrayList<Interaction_content>();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOADALL_INTERACTION_CONTENT);
			pstmt.setString(1, user_email);
			pstmt.setString(2, Dynamic_id);
			res=pstmt.executeQuery();
			while (res.next()) {
				Interaction_content list=new Interaction_content();
				list.setUser_email(res.getString("user_email"));
				list.setDynamic_id(res.getString("dynamic_id"));
				list.setInteraction_email(res.getString("interaction_email"));
				list.setInteraction_praise(res.getString("interaction_praise"));
				list.setInteraction_txt(res.getString("interaction_txt"));
				list.setInteraction_time(res.getString("interaction_time"));
				userList.add(list);
			}
		} catch (SQLException e) {
			System.out.println("异常");
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return userList;
	}	

	/**
	 * 查找Interaction_content表中的所有数据数据
	 * @param Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time)
	 * @return ArrayList<Interaction_content>类型
	 */
	@Override
	public Interaction_content loadInteraction_content(Interaction_content interaction)
	{
		dbUtil db=dbUtil.getInstance();
		Interaction_content list=new Interaction_content();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(LOAD_INTERACTION_CONTENT);
			pstmt.setString(1, interaction.getUser_email());
			pstmt.setString(2, interaction.getDynamic_id());
			pstmt.setString(3, interaction.getInteraction_email());
			pstmt.setString(4, interaction.getInteraction_time());
			res=pstmt.executeQuery();
			while (res.next()) {
				list.setUser_email(res.getString("user_email"));
				list.setDynamic_id(res.getString("dynamic_id"));
				list.setInteraction_email(res.getString("interaction_email"));
				list.setInteraction_praise(res.getString("interaction_praise"));
				list.setInteraction_txt(res.getString("interaction_txt"));
				list.setInteraction_time(res.getString("interaction_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return list;
	}
	
	/**
	 * 删除评论互动（Interaction_content）
	 * @param Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time)
	 */
	@Override
	public void removeInteraction_content(Interaction_content interaction)
	{
		dbUtil db=dbUtil.getInstance();
		try {
			con=db.getCon();
			pstmt=(PreparedStatement) con.prepareStatement(REMOVE_INTERACTION_CONTENT);
			pstmt.setString(1,interaction.getUser_email());
			pstmt.setString(2,interaction.getDynamic_id());
			pstmt.setString(3,interaction.getInteraction_email());
			pstmt.setString(4,interaction.getInteraction_time());
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
