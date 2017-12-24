/**
 * 
 */
package com.guess.domain;


/**
 * @author 李文兵
 *
 */
public class Information_minute {
	private String user_email;
	private String information_id;
	private String information_filename;
	private String information_size;
	private String information_type;
	private String information_txt;
	private int information_praise;
	private String information_time;
	private String information_address;
	
	/**
	 * 构造函数
	 */
	public Information_minute() {
		super();
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getInformation_id() {
		return information_id;
	}

	public void setInformation_id(String information_id) {
		this.information_id = information_id;
	}

	public String getInformation_filename() {
		return information_filename;
	}

	public void setInformation_filename(String information_filename) {
		this.information_filename = information_filename;
	}
	
	public String getInformation_size() {
		return information_size;
	}

	public void setInformation_size(String information_size) {
		this.information_size = information_size;
	}

	public String getInformation_type() {
		return information_type;
	}

	public void setInformation_type(String information_type) {
		this.information_type = information_type;
	}

	public String getInformation_txt() {
		return information_txt;
	}

	public void setInformation_txt(String information_txt) {
		this.information_txt = information_txt;
	}

	public int getInformation_praise() {
		return information_praise;
	}

	public void setInformation_praise(int information_praise) {
		this.information_praise = information_praise;
	}

	public String getInformation_time() {
		return information_time;
	}

	public void setInformation_time(String information_time) {
		this.information_time = information_time;
	}

	public String getInformation_address() {
		return information_address;
	}

	public void setInformation_address(String information_address) {
		this.information_address = information_address;
	}
	
	
}
