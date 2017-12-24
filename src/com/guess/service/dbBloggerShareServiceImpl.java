package com.guess.service;

import java.util.ArrayList;

import com.guess.dao.dbBloggerShareDao;
import com.guess.dao.dbBloggerShareDaoImpl;
import com.guess.domain.Blogger_share;

public class dbBloggerShareServiceImpl implements dbBloggerShareService {

	@Override
	public void addBlogger_share(Blogger_share blogger_share) {
		dbBloggerShareDao blogger_sharedao=new dbBloggerShareDaoImpl();
		blogger_sharedao.addBlogger_share(blogger_share);
	}

	@Override
	public void removeBlogger_share(Blogger_share blogger_share) {
		dbBloggerShareDao blogger_sharedao=new dbBloggerShareDaoImpl();
		blogger_sharedao.removeBlogger_share(blogger_share);

	}

	@Override
	public ArrayList<Blogger_share> loadAllBlogger_share() {
		dbBloggerShareDao blogger_sharedao=new dbBloggerShareDaoImpl();
		return blogger_sharedao.loadAllBlogger_share();
	}

}
