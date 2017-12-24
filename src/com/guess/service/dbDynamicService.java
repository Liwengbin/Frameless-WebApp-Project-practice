package com.guess.service;

import java.util.ArrayList;

import com.guess.domain.Dynamic_content;
import com.guess.domain.Interaction_content;

public interface dbDynamicService {

	/**
	 * ��Ӷ�̬
	 * @param Dynamic_content
	 */
	void addDynamic_content(Dynamic_content dynamic);
	
	/**
	 * ɾ����̬
	 * @param Dynamic_content
	 */
	void removeDynamic_content(Dynamic_content dynamic);
	
	/**
	 * �������ж�̬������
	 * @return ArrayList<Dynamic_content>
	 */
	ArrayList<Dynamic_content> loadAllDynamic_content();
	
	/**
	 * ����һ�����嶯̬������
	 * @param dynamic
	 * @return Dynamic_content
	 */
	Dynamic_content loadDynamic_content(Dynamic_content dynamic);
	
	
	/*--------------------------------------------------------------------------------------------------------------*/
	/**
	 * �������ۻ���
	 * @param Interaction_content
	 */
	void addInteraction_content(Interaction_content interaction);
	
	/**
	 * ɾ�����ۻ���
	 * @param Interaction_content
	 */
	void removeInteraction_content(Interaction_content interaction);

	/**
	 * �������пռ䶯̬�Ļ������ݣ��м�����̬��
	 * @param user_email
	 * @param Dynamic_id
	 * @return ArrayList<Interaction_content>
	 */
	ArrayList<Interaction_content> loadAllInteraction_content(String user_email,String Dynamic_id);

	/**
	 * ���ؾ�����һ���ռ䶯̬�ͻ����Ļ�������
	 * @param interaction
	 * @return Interaction_content
	 */
	Interaction_content loadInteraction_content(Interaction_content interaction);
	
}
