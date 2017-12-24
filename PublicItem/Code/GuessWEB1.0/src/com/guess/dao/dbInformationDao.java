/**
 * 
 */
package com.guess.dao;

import java.util.ArrayList;

import com.guess.domain.Information_minute;

/**
 * @author ���ı�
 *
 */
public interface dbInformationDao {
	/**
	 * ���������Ϣ
	 * @param Information_minute
	 */
	void addInformation_minute(Information_minute information);
	
	/**
	 * ɾ������
	 * @param Information_minute
	 */
	void removeInformation_minute(Information_minute information);
	
	/**
	 * ������������
	 * @return ArrayList<Information_minute>
	 */
	ArrayList<Information_minute> loadAllInformation_minute();
	
	/**
	 * ����һ�����������
	 * @param information
	 * @return Information_minute
	 */
	Information_minute loadInformation_minute(Information_minute information);
}
