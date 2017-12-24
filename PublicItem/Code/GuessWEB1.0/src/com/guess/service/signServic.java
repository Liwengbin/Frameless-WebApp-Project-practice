package com.guess.service;

import com.guess.domain.Sign;

public interface signServic {
	void addSign(Sign sign);
	void removeSign(String user_email);
	void updateSign(Sign sign);
	Sign loadSign(String user_email);
}
