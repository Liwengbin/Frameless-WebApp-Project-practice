/**
 * 
 */
package com.guess.domain;

/**
 * @author 用户详细信息
 *
 */
public class User_minute {
	private String user_email;
	private String user_sex;
	private Integer user_age=0;
	private String user_headimg;
	private String user_signature;
	
	public User_minute(String user_email, String user_sex, Integer user_age,
			String user_headimg, String user_signature) {
		super();
		this.user_email = user_email;
		this.user_sex = user_sex;
		this.user_age = user_age;
		this.user_headimg = user_headimg;
		this.user_signature = user_signature;
	}

	public User_minute() {
		super();
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public Integer getUser_age() {
		return user_age;
	}

	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}

	public String getUser_headimg() {
		return user_headimg;
	}

	public void setUser_headimg(String user_headimg) {
		this.user_headimg = user_headimg;
	}

	public String getUser_signature() {
		return user_signature;
	}

	public void setUser_signature(String user_signature) {
		this.user_signature = user_signature;
	}
	
}
