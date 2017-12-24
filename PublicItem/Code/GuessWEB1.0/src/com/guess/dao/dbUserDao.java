package com.guess.dao;

import java.util.ArrayList;

import com.guess.domain.User_basic;
import com.guess.domain.User_minute;

public interface dbUserDao {
	void addUser_basic(User_basic user);
	void removeUser_basic(String user_email);
	void updateUser_basic(User_basic user);
	ArrayList<User_basic> loadAlluser_basic();
	User_basic loaduser_basic(String user_email);
	
/*-----------------------------------------------------------------------------------------------------------------------*/
	/**
	 * �������(��User_minute)
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 */
	void addUser_minute(User_minute user);
	
	/**
	 * ɾ���û���ϸ��Ϣ��User_minute��
	 * @param String user_email
	 */
	void removeUser_minute(String user_email);
	
	/**
	 * �û�������Ϣ�޸ģ���User_minute��
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 */
	void updateUser_minute(User_minute user);
	
	/**
	 * ����User_minute�������е�����
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 * @return ArrayList<User_basic>����
	 */
	
	ArrayList<User_minute> loadAlluser_minute();
	/**
	 * ����User_minute���о��������
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 * @return User_minute����
	 */
	User_minute loaduser_minute(String user_email);
}
