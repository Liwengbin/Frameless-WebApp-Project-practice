package com.guess.dao;

import java.util.ArrayList;

import com.guess.domain.Blogger_share;

public interface dbBloggerShareDao {
	void addBlogger_share(Blogger_share blogger_share);
	void removeBlogger_share(Blogger_share blogger_share);
	ArrayList<Blogger_share> loadAllBlogger_share();
}
