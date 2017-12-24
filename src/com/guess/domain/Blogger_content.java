/**
 * 
 */
package com.guess.domain;

/**
 * @author 李文兵
 * 博客内容实体类
 */
public class Blogger_content {
	private String user_email;
	private String blogger_id;
	private String blogger_name;
	private String blogger_txt;
	private int blogger_praise;
	private String blogger_time;
	private String blogger_type;
	
	public Blogger_content() {
		super();
	}
	

	public Blogger_content(String user_email, String blogger_id,
			String blogger_name, String blogger_txt, int blogger_praise,
			String blogger_time, String blogger_type) {
		super();
		this.user_email = user_email;
		this.blogger_id = blogger_id;
		this.blogger_name = blogger_name;
		this.blogger_txt = blogger_txt;
		this.blogger_praise = blogger_praise;
		this.blogger_time = blogger_time;
		this.blogger_type = blogger_type;
	}


	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getBlogger_id() {
		return blogger_id;
	}

	public void setBlogger_id(String blogger_id) {
		this.blogger_id = blogger_id;
	}

	public String getBlogger_name() {
		return blogger_name;
	}

	public void setBlogger_name(String blogger_name) {
		this.blogger_name = blogger_name;
	}

	public String getBlogger_txt() {
		return blogger_txt;
	}

	public void setBlogger_txt(String blogger_txt) {
		this.blogger_txt = blogger_txt;
	}

	public int getBlogger_praise() {
		return blogger_praise;
	}

	public void setBlogger_praise(int blogger_praise) {
		this.blogger_praise = blogger_praise;
	}

	public String getBlogger_time() {
		return blogger_time;
	}

	public void setBlogger_time(String blogger_time) {
		this.blogger_time = blogger_time;
	}

	public String getBlogger_type() {
		return blogger_type;
	}

	public void setBlogger_type(String blogger_type) {
		this.blogger_type = blogger_type;
	}
	
}
