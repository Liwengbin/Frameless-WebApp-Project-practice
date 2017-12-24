package com.guess.service;

import java.util.ArrayList;

import com.guess.dao.dbBloggerContentDao;
import com.guess.dao.dbBloggerContentDaoImpl;
import com.guess.domain.Blogger_content;

public class dbBloggerContentServiceImpl implements dbBloggerContentService {

	@Override
	public void addBlogger_content(Blogger_content blogger_content) {
		// TODO Auto-generated method stub
		dbBloggerContentDao blogger_content_dao =new dbBloggerContentDaoImpl();
		blogger_content_dao.addBlogger_content(blogger_content);
	}

	@Override
	public void removeBlogger_content(Blogger_content blogger_content) {
		// TODO Auto-generated method stub
		dbBloggerContentDao blogger_content_dao =new dbBloggerContentDaoImpl();
		blogger_content_dao.removeBlogger_content(blogger_content);
	}

	@Override
	public ArrayList<Blogger_content> loadAllBlogger_content() {
		// TODO Auto-generated method stub
		dbBloggerContentDao blogger_content_dao =new dbBloggerContentDaoImpl();
		return blogger_content_dao.loadAllBlogger_content();
	}

	@Override
	public Blogger_content loadBlogger_content(Blogger_content blogger_content) {
		// TODO Auto-generated method stub
		dbBloggerContentDao blogger_content_dao =new dbBloggerContentDaoImpl();
		return blogger_content_dao.loadBlogger_content(blogger_content);
	}

}
