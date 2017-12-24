package com.guess.service;

import java.util.ArrayList;

import com.guess.dao.dbDynamicDao;
import com.guess.dao.dbDynamicDaoImpl;
import com.guess.domain.Dynamic_content;
import com.guess.domain.Interaction_content;

public class dbDynamicServiceImpl implements dbDynamicService {

	@Override
	public void addDynamic_content(Dynamic_content dynamic) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		dynamic_dao.addDynamic_content(dynamic);

	}

	@Override
	public void removeDynamic_content(Dynamic_content dynamic) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		dynamic_dao.removeDynamic_content(dynamic);

	}

	@Override
	public ArrayList<Dynamic_content> loadAllDynamic_content() {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		return dynamic_dao.loadAllDynamic_content();
	}

	@Override
	public Dynamic_content loadDynamic_content(Dynamic_content dynamic) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		return dynamic_dao.loadDynamic_content(dynamic);
	}

	@Override
	public void addInteraction_content(Interaction_content interaction) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		dynamic_dao.addInteraction_content(interaction);

	}

	@Override
	public void removeInteraction_content(Interaction_content interaction) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		dynamic_dao.removeInteraction_content(interaction);

	}

	@Override
	public ArrayList<Interaction_content> loadAllInteraction_content(
			String user_email, String Dynamic_id) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		return dynamic_dao.loadAllInteraction_content(user_email, Dynamic_id);
	}


	@Override
	public Interaction_content loadInteraction_content(
			Interaction_content interaction) {
		dbDynamicDao dynamic_dao=new dbDynamicDaoImpl();
		return dynamic_dao.loadInteraction_content(interaction);
	}
}
