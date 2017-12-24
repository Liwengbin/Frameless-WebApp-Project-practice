/**
 * 
 */
package com.guess.dao;

import java.util.ArrayList;

import com.guess.domain.Blogger_content;

/**
 * @author 李文兵
 * 博客
 */
public interface dbBloggerContentDao {
	/**
	 * 添加博客信息
	 * @param Blogger_content
	 */
	void addBlogger_content(Blogger_content blogger_content);
	
	/**
	 * 删除博客
	 * @param Blogger_content
	 */
	void removeBlogger_content(Blogger_content blogger_content);
	
	/**
	 * 查找所有博客
	 * @return ArrayList<Blogger_content>
	 */
	ArrayList<Blogger_content> loadAllBlogger_content();
	
	/**
	 * 查找一条具体的博客
	 * @param Blogger_content
	 * @return blogger_content
	 */
	Blogger_content loadBlogger_content(Blogger_content blogger_content);
}
