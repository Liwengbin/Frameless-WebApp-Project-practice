/**
 * 
 */
package com.guess.domain;

/**
 * @author 用户互动的内容实体
 *
 */
public class Interaction_content {
	private String user_email;
	private String dynamic_id;
	private String interaction_email;
	private String interaction_praise;
	private String interaction_txt;
	private String interaction_time;
	private User_basic user_basic;
	private User_minute user_minute;
	private User_basic user_basic_interaction;
	private User_minute user_minute_interaction;
	
	public Interaction_content() {
		super();
	}
	/**
	 * 用户互动的内容构造函数
	 * @param user_email
	 * @param dynamic_id
	 * @param interaction_email
	 * @param interaction_praise
	 * @param interaction_txt
	 * @param interaction_time
	 * @param user_basic
	 * @param user_minute
	 * @param user_basic_interaction
	 * @param user_minute_interaction
	 */
	public Interaction_content(String user_email, String dynamic_id,
			String interaction_email, String interaction_praise,
			String interaction_txt, String interaction_time,
			User_basic user_basic, User_minute user_minute,
			User_basic user_basic_interaction,
			User_minute user_minute_interaction) {
		super();
		this.user_email = user_email;
		this.dynamic_id = dynamic_id;
		this.interaction_email = interaction_email;
		this.interaction_praise = interaction_praise;
		this.interaction_txt = interaction_txt;
		this.interaction_time = interaction_time;
		this.user_basic = user_basic;
		this.user_minute = user_minute;
		this.user_basic_interaction = user_basic_interaction;
		this.user_minute_interaction = user_minute_interaction;
	}



	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getDynamic_id() {
		return dynamic_id;
	}

	public void setDynamic_id(String dynamic_id) {
		this.dynamic_id = dynamic_id;
	}

	public String getInteraction_email() {
		return interaction_email;
	}

	public void setInteraction_email(String interaction_email) {
		this.interaction_email = interaction_email;
	}

	public String getInteraction_praise() {
		return interaction_praise;
	}

	public void setInteraction_praise(String interaction_praise) {
		this.interaction_praise = interaction_praise;
	}

	public String getInteraction_txt() {
		return interaction_txt;
	}

	public void setInteraction_txt(String interaction_txt) {
		this.interaction_txt = interaction_txt;
	}

	public String getInteraction_time() {
		return interaction_time;
	}

	public void setInteraction_time(String interaction_time) {
		this.interaction_time = interaction_time;
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
	public User_basic getUser_basic_interaction() {
		return user_basic_interaction;
	}
	public void setUser_basic_interaction(User_basic user_basic_interaction) {
		this.user_basic_interaction = user_basic_interaction;
	}
	public User_minute getUser_minute_interaction() {
		return user_minute_interaction;
	}
	public void setUser_minute_interaction(User_minute user_minute_interaction) {
		this.user_minute_interaction = user_minute_interaction;
	}	
}
