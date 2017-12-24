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
 * @author ���ı�
 *
 */
public interface loadAllService {
	/**
	 * ��ѯ�û���һƪ��̬����ȡ��ƪ��̬������������Ϣ
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
	 * �����������ҳ��list�ռ䣬���Ҷ�̬���������ݣ�������̬����+����
	 * @return ArrayList<All_content>
	 */
	ArrayList<All_content> returnDynamicToInteractionContentList();
	
	/**
	 * �����û�����Ϣ
	 * @param user_email
	 * @return User_all  (User_basic user_basic, User_minute user_minute)
	 */
	User_all loadUserAll(String user_email);
	
	/**
	 * ���ط���ҳ�����Ϣ(�����û��Ļ�����Ϣ�����������)
	 * @return ArrayList<ShareToUser>
	 */
	ArrayList<ShareToUser> loadShareToUser();
}	
