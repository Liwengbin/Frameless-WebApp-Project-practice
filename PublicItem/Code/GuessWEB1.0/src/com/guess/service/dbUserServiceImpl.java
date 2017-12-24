package com.guess.service;

import java.util.ArrayList;

import com.guess.dao.dbUserDao;
import com.guess.dao.dbUserDaoImpl;
import com.guess.domain.User_basic;
import com.guess.domain.User_minute;
import com.guess.exception.GUESSException;

	/**
	 * 
	 * @author 业务层，数据库的操作
	 *
	 */
public class dbUserServiceImpl implements dbUserService {

	@Override
	public void addUser_basic(User_basic user) {
		dbUserDao user_dao=new dbUserDaoImpl();
		user_dao.addUser_basic(user);

	}

	@Override
	public void removeUser_basic(String user_email) {
		dbUserDao user_dao=new dbUserDaoImpl();
		user_dao.removeUser_basic(user_email);

	}

	@Override
	public void updateUser_basic(User_basic user) {
		dbUserDao user_dao=new dbUserDaoImpl();
		user_dao.updateUser_basic(user);

	}

	@Override
	public ArrayList<User_basic> loadAlluser_basic() {
		dbUserDao user_dao=new dbUserDaoImpl();
		return user_dao.loadAlluser_basic();
	}

	@Override
	public User_basic loaduser_basic(String user_email) {
		dbUserDao user_dao=new dbUserDaoImpl();
		return user_dao.loaduser_basic(user_email);
	}

	@Override
	public void addUser_minute(User_minute user) {
		dbUserDao user_dao=new dbUserDaoImpl();
		user_dao.addUser_minute(user);

	}

	@Override
	public void removeUser_minute(String user_email) {
		dbUserDao user_dao=new dbUserDaoImpl();
		user_dao.removeUser_minute(user_email);

	}

	@Override
	public void updateUser_minute(User_minute user) {
		dbUserDao user_dao=new dbUserDaoImpl();
		User_minute User_minutelod=user_dao.loaduser_minute(user.getUser_email());
		
		if(User_minutelod.getUser_age()!=user.getUser_age())
		{
			User_minutelod.setUser_age(user.getUser_age());
		}
		if(User_minutelod.getUser_sex()!=user.getUser_sex())
		{
			User_minutelod.setUser_sex(user.getUser_sex());
		}
		if(user.getUser_headimg() !=null)
		{
			User_minutelod.setUser_headimg(user.getUser_headimg());
		}
		if(user.getUser_signature() != null)
		{
			User_minutelod.setUser_signature(user.getUser_signature());
		}
		user_dao.updateUser_minute(User_minutelod);

	}

	@Override
	public ArrayList<User_minute> loadAlluser_minute() {
		dbUserDao user_dao=new dbUserDaoImpl();
		return user_dao.loadAlluser_minute();
	}

	@Override
	public User_minute loaduser_minute(String user_email) {
		dbUserDao user_dao=new dbUserDaoImpl();
		return user_dao.loaduser_minute(user_email);
	}

	@Override
	public User_basic checkUser(String Email,String Pwd) {
		dbUserDao user_dao=new dbUserDaoImpl();
		User_basic user=user_dao.loaduser_basic(Email);
		
		if(!user.getUser_password().equals(Pwd))
		{
			throw new GUESSException("密码错误!");
		}
		return user;
	}

}
