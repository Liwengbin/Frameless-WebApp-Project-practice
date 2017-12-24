/**
 * 
 */
package com.guess.domain;

/**
 * @author 用户动态，内容实体
 *
 */
public class Dynamic_content {
	private String user_email;
	private String dynamic_id;
	private String dynamic_txt;
	private String dynamic_tv;
	private String[] dynamic_img;
	private String dynamic_time;
	/**
	 * 构造函数
	 * @param user_email
	 * @param dynamic_id
	 * @param dynamic_txt
	 * @param dynamic_img
	 * @param dynamic_time
	 */

	
	public Dynamic_content() {
		super();
	}
	
	
	public Dynamic_content(String user_email, String dynamic_id,
			String dynamic_txt, String dynamic_tv, String[] dynamic_img,
			String dynamic_time) {
		super();
		this.user_email = user_email;
		this.dynamic_id = dynamic_id;
		this.dynamic_txt = dynamic_txt;
		this.dynamic_tv = dynamic_tv;
		this.dynamic_img = dynamic_img;
		this.dynamic_time = dynamic_time;
	}


	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getDynamic_id() {
		return dynamic_id;
	}
	public void setDynamic_id(String dynamic_id) {
		this.dynamic_id = dynamic_id;
	}
	public String getDynamic_txt() {
		return dynamic_txt;
	}
	public void setDynamic_txt(String dynamic_txt) {
		this.dynamic_txt = dynamic_txt;
	}
	public String getDynamic_tv() {
		return dynamic_tv;
	}
	public void setDynamic_tv(String dynamic_tv) {
		this.dynamic_tv = dynamic_tv;
	}
	public String[] getDynamic_img() {
		return dynamic_img;
	}
	public void setDynamic_img(String[] dynamic_img) {
		this.dynamic_img = dynamic_img;
	}
	public String getDynamic_time() {
		return dynamic_time;
	}
	public void setDynamic_time(String dynamic_time) {
		this.dynamic_time = dynamic_time;
	}
	
}
