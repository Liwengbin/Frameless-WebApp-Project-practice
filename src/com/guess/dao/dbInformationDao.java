/**
 * 
 */
package com.guess.dao;

import java.util.ArrayList;

import com.guess.domain.Information_minute;

/**
 * @author 李文兵
 *
 */
public interface dbInformationDao {
	/**
	 * 添加资料信息
	 * @param Information_minute
	 */
	void addInformation_minute(Information_minute information);
	
	/**
	 * 删除资料
	 * @param Information_minute
	 */
	void removeInformation_minute(Information_minute information);
	
	/**
	 * 查找所有资料
	 * @return ArrayList<Information_minute>
	 */
	ArrayList<Information_minute> loadAllInformation_minute();
	
	/**
	 * 查找一条具体的资料
	 * @param information
	 * @return Information_minute
	 */
	Information_minute loadInformation_minute(Information_minute information);
}
