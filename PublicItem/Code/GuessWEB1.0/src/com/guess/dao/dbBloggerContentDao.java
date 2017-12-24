/**
 * 
 */
package com.guess.dao;

import java.util.ArrayList;

import com.guess.domain.Blogger_content;

/**
 * @author ���ı�
 * ����
 */
public interface dbBloggerContentDao {
	/**
	 * ��Ӳ�����Ϣ
	 * @param Blogger_content
	 */
	void addBlogger_content(Blogger_content blogger_content);
	
	/**
	 * ɾ������
	 * @param Blogger_content
	 */
	void removeBlogger_content(Blogger_content blogger_content);
	
	/**
	 * �������в���
	 * @return ArrayList<Blogger_content>
	 */
	ArrayList<Blogger_content> loadAllBlogger_content();
	
	/**
	 * ����һ������Ĳ���
	 * @param Blogger_content
	 * @return blogger_content
	 */
	Blogger_content loadBlogger_content(Blogger_content blogger_content);
}
