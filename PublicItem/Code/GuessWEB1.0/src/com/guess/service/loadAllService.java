/**
 * 
 */
package com.guess.service;

import java.util.ArrayList;

import com.guess.domain.All_content;
import com.guess.domain.Interaction_content;
import com.guess.domain.ShareToUser;
import com.guess.domain.User_all;

/**
 * @author 李文兵
 *
 */
public interface loadAllService {
	/**
	 * 查询用户的一篇动态，获取这篇动态的所有评论信息
	 * @author Interaction_content() 
	 * user_basic
	 * user_minute
	 * user_basic_interaction
	 * user_minute_interaction
	 * @param user_email
	 * @param Dynamic_id
	 * @return
	 */
	ArrayList<Interaction_content> loadAllInteraction(String user_email,String Dynamic_id);
	
	/**
	 * 用于输出到网页的list空间，查找动态的所有数据，包括动态内容+评论
	 * @return ArrayList<All_content>
	 */
	ArrayList<All_content> returnDynamicToInteractionContentList();
	
	/**
	 * 返回用户的信息
	 * @param user_email
	 * @return User_all  (User_basic user_basic, User_minute user_minute)
	 */
	User_all loadUserAll(String user_email);
	
	/**
	 * 返回分享页面的信息(包括用户的基本信息，分享的内容)
	 * @return ArrayList<ShareToUser>
	 */
	ArrayList<ShareToUser> loadShareToUser();
}	
