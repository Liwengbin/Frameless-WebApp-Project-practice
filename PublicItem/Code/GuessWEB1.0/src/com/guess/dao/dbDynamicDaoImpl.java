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
	 * ������ӣ���Dynamic_content��
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
			/*��string����תΪstringBuffer�ַ����ԡ�|���ָ�*/
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
	 * ����Dynamic_content���о��������
	 * @param Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv,String dynamic_img, String dynamic_time)
	 * @return ArrayList<Dynamic_content>����
	 * @author dynamic_tv������Ƶ·��
	 * @author dynamic_img����ͼƬ·��		 
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
				list.setDynamic_img(res.getString("dynamic_img").split("\\|"));/** �����ݿ��ж�ȡ�ַ�������|Ϊ�и�����и�Ϊ�ַ�����*/
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
	 * ����Dynamic_content���е���������
	 * @return ArrayList<Dynamic_content>����Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv,String dynamic_img, String dynamic_time)
	 * @author dynamic_tv������Ƶ·��
	 * @author dynamic_img����ͼƬ·��		 
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
				list.setDynamic_img(res.getString("dynamic_img").split("\\|"));/** �����ݿ��ж�ȡ�ַ�������|Ϊ�и�����и�Ϊ�ַ�����*/
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
	 * ɾ����̬��Dynamic_content��
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
				throw new RuntimeException("ɾ��ʧ�ܣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
	/**
	 * ������ӣ���Interaction_content��
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
	 * ����Interaction_content���е�������������
	 * @param Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time)
	 * @return ArrayList<Interaction_content>����
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
			System.out.println("�쳣");
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, res);
		}
		return userList;
	}	

	/**
	 * ����Interaction_content���е�������������
	 * @param Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time)
	 * @return ArrayList<Interaction_content>����
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
	 * ɾ�����ۻ�����Interaction_content��
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
				throw new RuntimeException("ɾ��ʧ�ܣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			db.release(con, pstmt, null);
		}
	}
	
}
