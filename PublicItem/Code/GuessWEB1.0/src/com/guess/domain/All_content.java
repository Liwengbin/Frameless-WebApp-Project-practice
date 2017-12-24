/**
 * 
 */
package com.guess.domain;

import java.util.ArrayList;

/**
 * 
 * @author 封装输出到表单内容的实体（4个参数）
 *
 */
public class All_content {
	private User_basic user_basic;
	private User_minute user_minute;
	private Dynamic_content dynamic_content;
	private ArrayList<Interaction_content> interaction_content;
	
	/**
	 * 封装输出到表单内容的实体的构造方法
	 * @param user_basic
	 * @param user_minute
	 * @param dynamic_content
	 * @param interaction_content
	 */
	

	public All_content() {
		super();
	}

	public All_content(User_basic user_basic, User_minute user_minute,
			Dynamic_content dynamic_content,
			ArrayList<Interaction_content> interaction_content) {
		super();
		this.user_basic = user_basic;
		this.user_minute = user_minute;
		this.dynamic_content = dynamic_content;
		this.interaction_content = interaction_content;
	}



	public User_basic getUser_basic() {
		return user_basic;
	}

	public void setUser_basic(User_basic user_basic) {
		this.user_basic = user_basic;
	}

	public User_minute getUser_minute() {
		return user_minute;
	}

	public void setUser_minute(User_minute user_minute) {
		this.user_minute = user_minute;
	}

	public Dynamic_content getDynamic_content() {
		return dynamic_content;
	}

	public void setDynamic_content(Dynamic_content dynamic_content) {
		this.dynamic_content = dynamic_content;
	}

	public ArrayList<Interaction_content> getInteraction_content() {
		return interaction_content;
	}

	public void setInteraction_content(
			ArrayList<Interaction_content> interaction_content) {
		this.interaction_content = interaction_content;
	}
	
}
