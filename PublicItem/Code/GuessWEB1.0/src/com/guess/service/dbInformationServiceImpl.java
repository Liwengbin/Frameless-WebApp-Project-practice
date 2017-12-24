/**
 * 
 */
package com.guess.service;

import java.util.ArrayList;

import com.guess.dao.dbInformationDao;
import com.guess.dao.dbInformationDaoImpl;
import com.guess.domain.Information_minute;

/**
 * @author ÀîÎÄ±ø
 *
 */
public class dbInformationServiceImpl implements dbInformationService {

	/* (non-Javadoc)
	 * @see com.guess.service.dbInformationService#addInformation_minute(com.guess.domain.Information_minute)
	 */
	@Override
	public void addInformation_minute(Information_minute information) {
		dbInformationDao information_dao=new dbInformationDaoImpl();
		information_dao.addInformation_minute(information);
	}

	/* (non-Javadoc)
	 * @see com.guess.service.dbInformationService#removeInformation_minute(com.guess.domain.Information_minute)
	 */
	@Override
	public void removeInformation_minute(Information_minute information) {
		dbInformationDao information_dao=new dbInformationDaoImpl();
		information_dao.removeInformation_minute(information);
	}

	/* (non-Javadoc)
	 * @see com.guess.service.dbInformationService#loadAllInformation_minute()
	 */
	@Override
	public ArrayList<Information_minute> loadAllInformation_minute() {
		dbInformationDao information_dao=new dbInformationDaoImpl();		
		return information_dao.loadAllInformation_minute();
	}

	/* (non-Javadoc)
	 * @see com.guess.service.dbInformationService#loadInformation_minute(com.guess.domain.Information_minute)
	 */
	@Override
	public Information_minute loadInformation_minute(Information_minute information) {
		dbInformationDao information_dao=new dbInformationDaoImpl();
		return information_dao.loadInformation_minute(information);
	}

}
