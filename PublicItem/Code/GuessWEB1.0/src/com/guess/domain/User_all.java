package com.guess.domain;

/**
 * 
 * @author 用户的信息
 *
 */
public class User_all 
{
	private User_basic user_basic;
	private User_minute user_minute;
	
	public User_all(User_basic user_basic, User_minute user_minute) {
		super();
		this.user_basic = user_basic;
		this.user_minute = user_minute;
	}
	
	public User_all() {
		super();
	}
	
	public User_basic getUser_basic() {
		return user_basic;
	}
	public void setUser_basic(User_basic user_basic) {
		this.user_basic = user_basic;
	}
	public User_minute getUser_minute() {
		return user_minute;
	}
	public void setUser_minute(User_minute user_minute) {
		this.user_minute = user_minute;
	}
}
