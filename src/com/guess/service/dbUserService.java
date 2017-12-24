/**
 * 
 */
package com.guess.service;

import java.util.ArrayList;

import com.guess.domain.User_basic;
import com.guess.domain.User_minute;

/**
 * @author 李文兵
 *
 */
public interface dbUserService {
	void addUser_basic(User_basic user);
	void removeUser_basic(String user_email);
	void updateUser_basic(User_basic user);
	ArrayList<User_basic> loadAlluser_basic();
	User_basic loaduser_basic(String user_email);
	
	void addUser_minute(User_minute user);
	void removeUser_minute(String user_email);
	void updateUser_minute(User_minute user);
	ArrayList<User_minute> loadAlluser_minute();
	User_minute loaduser_minute(String user_email);
	
	/**
	 * 验证用户
	 * @param Email
	 * @param Pwd
	 * @return
	 */
	User_basic checkUser(String Email,String Pwd);
}
