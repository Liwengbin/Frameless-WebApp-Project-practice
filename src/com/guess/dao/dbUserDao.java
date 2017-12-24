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
	 * 数据添加(表User_minute)
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 */
	void addUser_minute(User_minute user);
	
	/**
	 * 删除用户详细信息（User_minute）
	 * @param String user_email
	 */
	void removeUser_minute(String user_email);
	
	/**
	 * 用户基本信息修改（表User_minute）
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 */
	void updateUser_minute(User_minute user);
	
	/**
	 * 查找User_minute表中所有的数据
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 * @return ArrayList<User_basic>类型
	 */
	
	ArrayList<User_minute> loadAlluser_minute();
	/**
	 * 查找User_minute表中具体的数据
	 * @param User_minute(String user_email, char user_sex, Integer user_age,
			String user_headimg, String user_signature)
	 * @return User_minute类型
	 */
	User_minute loaduser_minute(String user_email);
}
