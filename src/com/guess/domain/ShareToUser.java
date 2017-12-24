package com.guess.domain;

public class ShareToUser {
	private Blogger_share blogger_share =new Blogger_share();
	private User_all user_all =new User_all();
	
	public ShareToUser(Blogger_share blogger_share, User_all user_all) {
		super();
		this.blogger_share = blogger_share;
		this.user_all = user_all;
	}
	
	public ShareToUser() {
		super();
	}
	
	public Blogger_share getBlogger_share() {
		return blogger_share;
	}
	public void setBlogger_share(Blogger_share blogger_share) {
		this.blogger_share = blogger_share;
	}
	public User_all getUser_all() {
		return user_all;
	}
	public void setUser_all(User_all user_all) {
		this.user_all = user_all;
	}
	
}
