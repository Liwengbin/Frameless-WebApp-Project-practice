package com.guess.domain;

public class Sign {
	private String user_email;
	private long sign_dynamic;
	private long sign_share;
	private long sign_information;
	private long sign_blogger;
	

	
	



	public Sign(String user_email, long sign_dynamic, long sign_share,
			long sign_information, long sign_blogger) {
		super();
		this.user_email = user_email;
		this.sign_dynamic = sign_dynamic;
		this.sign_share = sign_share;
		this.sign_information = sign_information;
		this.sign_blogger = sign_blogger;
	}


	public Sign() {
		super();
	}
	
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public long getSign_dynamic() {
		return sign_dynamic;
	}
	public void setSign_dynamic(long sign_dynamic) {
		this.sign_dynamic = sign_dynamic;
	}
	public long getSign_share() {
		return sign_share;
	}
	public void setSign_share(long sign_share) {
		this.sign_share = sign_share;
	}


	public long getSign_information() {
		return sign_information;
	}


	public void setSign_information(long sign_information) {
		this.sign_information = sign_information;
	}


	public long getSign_blogger() {
		return sign_blogger;
	}
	
	public void setSign_blogger(long sign_blogger) {
		this.sign_blogger = sign_blogger;
	}	
}
