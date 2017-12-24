package com.guess.dao;

import com.guess.domain.Sign;

public interface signDao {
	void addSign(Sign sign);
	void removeSign(String user_email);
	void updateSign(Sign sign);
	Sign loadSign(String user_email);
}
