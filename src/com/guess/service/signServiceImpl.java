package com.guess.service;

import com.guess.dao.signDao;
import com.guess.dao.signDaoImpl;
import com.guess.domain.Sign;

public class signServiceImpl implements signServic {

	@Override
	public void addSign(Sign sign) {
		signDao sign_dao=new signDaoImpl();
		sign_dao.addSign(sign);
	}

	@Override
	public void removeSign(String user_email) {

	}

	@Override
	public void updateSign(Sign sign) {
		signDao sign_dao=new signDaoImpl();
		sign_dao.updateSign(sign);
	}

	@Override
	public Sign loadSign(String user_email) {
		signDao sign_dao=new signDaoImpl();
		return sign_dao.loadSign(user_email);
	}

}
