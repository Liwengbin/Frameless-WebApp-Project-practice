/**
 * 
 */
package com.guess.domain;

/**
 * @author 用户的基本信息
 * @author String email, String name,String password
 */
public class User_basic {
	private String user_email;
	private String user_name;
	private String user_password;
	public User_basic() {
		super();
	}

	/**
	 * User_basic(String user_email, String user_name, String user_password)
	 * @param user_email
	 * @param user_name
	 * @param user_password
	 */
	public User_basic(String user_email, String user_name, String user_password) {
		super();
		this.user_email = user_email;
		this.user_name = user_name;
		this.user_password = user_password;
	}

	
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
}
