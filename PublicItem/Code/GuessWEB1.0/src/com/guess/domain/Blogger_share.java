/**
 * 
 */
package com.guess.domain;

/**
 * @author ÀîÎÄ±ø
 *
 */
public class Blogger_share {
	private String user_email;
	private String share_web_url;
	private String share_describe;//ÃèÊö
	private String share_time;
	private String share_number;
	private String share_page;//ä¯ÀÀÁ¿
	
	
	public Blogger_share(String user_email, String share_web_url, String share_describe, String share_time,
			String share_number, String share_page) {
		super();
		this.user_email = user_email;
		this.share_web_url = share_web_url;
		this.share_describe = share_describe;
		this.share_time = share_time;
		this.share_number = share_number;
		this.share_page = share_page;
	}


	public Blogger_share() {
		super();
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getShare_web_url() {
		return share_web_url;
	}


	public void setShare_web_url(String share_web_url) {
		this.share_web_url = share_web_url;
	}


	public String getShare_describe() {
		return share_describe;
	}


	public void setShare_describe(String share_describe) {
		this.share_describe = share_describe;
	}


	public String getShare_time() {
		return share_time;
	}


	public void setShare_time(String share_time) {
		this.share_time = share_time;
	}


	public String getShare_number() {
		return share_number;
	}


	public void setShare_number(String share_number) {
		this.share_number = share_number;
	}


	public String getShare_page() {
		return share_page;
	}


	public void setShare_page(String share_page) {
		this.share_page = share_page;
	}
	
	
}
