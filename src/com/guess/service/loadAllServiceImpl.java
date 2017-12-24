package com.guess.service;

import java.util.ArrayList;

import com.guess.dao.dbUserDao;
import com.guess.dao.dbUserDaoImpl;
import com.guess.domain.All_content;
import com.guess.domain.Blogger_share;
import com.guess.domain.Dynamic_content;
import com.guess.domain.Interaction_content;
import com.guess.domain.ShareToUser;
import com.guess.domain.User_all;

public class loadAllServiceImpl implements loadAllService {

	@Override
	public ArrayList<Interaction_content> loadAllInteraction(String user_email,
			String Dynamic_id) {
		dbDynamicService dynamic_service=new dbDynamicServiceImpl();
		
		ArrayList<Interaction_content> load=dynamic_service.loadAllInteraction_content(user_email,Dynamic_id);
        for(Interaction_content tmp:load)  
        {
			dbUserService user_service=new dbUserServiceImpl();
			tmp.setUser_basic(user_service.loaduser_basic(tmp.getUser_email()));
			tmp.setUser_minute(user_service.loaduser_minute(tmp.getUser_email()));
			tmp.setUser_basic_interaction(user_service.loaduser_basic(tmp.getInteraction_email()));
			tmp.setUser_minute_interaction(user_service.loaduser_minute(tmp.getInteraction_email()));
        }
        return load;
	}
	
	/**
	 * 查找动态的所有数据，包括动态内容+评论
	 * @return ArrayList<All_content>类型
	 */
	@Override
	public ArrayList<All_content> returnDynamicToInteractionContentList()
	{
		loadAllService loadallinteraction_service=new loadAllServiceImpl();
		dbDynamicService dynamic_service=new dbDynamicServiceImpl();
		
		dbUserDao user_dao=new dbUserDaoImpl();
		ArrayList<All_content> list =new ArrayList<All_content>();
		ArrayList<Dynamic_content> DynamicList = dynamic_service.loadAllDynamic_content();
		 
		 for(Dynamic_content content:DynamicList)
		 {
			 All_content all_list=new All_content();
			 all_list.setUser_basic(user_dao.loaduser_basic(content.getUser_email()));
			 all_list.setUser_minute(user_dao.loaduser_minute(content.getUser_email()));
			 all_list.setDynamic_content(dynamic_service.loadDynamic_content(content));
			 all_list.setInteraction_content(loadallinteraction_service.loadAllInteraction(content.getUser_email(), content.getDynamic_id()));
			 list.add(all_list);
		 }
		return list;
	}
	
	/**
	 * 返回用户的信息
	 * @param user_email
	 * @return User_all (User_basic user_basic, User_minute user_minute)
	 */
	@Override
	public User_all loadUserAll(String user_email)
	{
		dbUserService user_service=new dbUserServiceImpl();
		User_all user_all=new User_all(user_service.loaduser_basic(user_email),user_service.loaduser_minute(user_email));
		return user_all;
	}

	/**
	 * 返回分享页面的信息(包括用户的基本信息，分享的内容)
	 * @return ArrayList<ShareToUser>
	 */
	@Override
	public ArrayList<ShareToUser> loadShareToUser() {
		ArrayList<ShareToUser> share_to_userlist=new ArrayList<ShareToUser>();
		ArrayList<Blogger_share> blogger_sharelist=new ArrayList<Blogger_share>();
		
		dbBloggerShareService blogger_sharedservice=new dbBloggerShareServiceImpl();
		blogger_sharelist=blogger_sharedservice.loadAllBlogger_share();
		for(Blogger_share share:blogger_sharelist)
		{		
			ShareToUser share_to_user=new ShareToUser();
			share_to_user.setUser_all(loadUserAll(share.getUser_email()));
			share_to_user.setBlogger_share(share);
			share_to_userlist.add(share_to_user);
		}
		return share_to_userlist;
	}
	
	
}
