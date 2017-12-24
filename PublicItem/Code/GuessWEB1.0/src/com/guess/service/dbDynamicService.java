package com.guess.service;

import java.util.ArrayList;

import com.guess.domain.Dynamic_content;
import com.guess.domain.Interaction_content;

public interface dbDynamicService {

	/**
	 * 添加动态
	 * @param Dynamic_content
	 */
	void addDynamic_content(Dynamic_content dynamic);
	
	/**
	 * 删除动态
	 * @param Dynamic_content
	 */
	void removeDynamic_content(Dynamic_content dynamic);
	
	/**
	 * 查找所有动态的内容
	 * @return ArrayList<Dynamic_content>
	 */
	ArrayList<Dynamic_content> loadAllDynamic_content();
	
	/**
	 * 查找一条具体动态的内容
	 * @param dynamic
	 * @return Dynamic_content
	 */
	Dynamic_content loadDynamic_content(Dynamic_content dynamic);
	
	
	/*--------------------------------------------------------------------------------------------------------------*/
	/**
	 * 新增评论互动
	 * @param Interaction_content
	 */
	void addInteraction_content(Interaction_content interaction);
	
	/**
	 * 删除评论互动
	 * @param Interaction_content
	 */
	void removeInteraction_content(Interaction_content interaction);

	/**
	 * 返回所有空间动态的基本内容（有几条动态）
	 * @param user_email
	 * @param Dynamic_id
	 * @return ArrayList<Interaction_content>
	 */
	ArrayList<Interaction_content> loadAllInteraction_content(String user_email,String Dynamic_id);

	/**
	 * 返回具体那一条空间动态和互动的基本内容
	 * @param interaction
	 * @return Interaction_content
	 */
	Interaction_content loadInteraction_content(Interaction_content interaction);
	
}
