package com.lwt.wx.dao;

import com.lwt.wx.entity.Topic;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.IBaseDao;

public interface ITopicDao extends IBaseDao<Topic> {
    /**
     * ͨ�����ݼ���ȫ�����£����ڱ��⣬���ݣ�ժҪ�ϼ���
     */
	Pager<Topic> searchTopic(String content);
	 /**
     * ͨ�����¹ؼ��ּ���ȫ������
     */
	Pager<Topic> searchTopicByKeyword(String keyword);
	 /**
     * ͨ����Ŀ�����⣬����״̬����������
     */
	Pager<Topic> find(Long cid, String title, Integer status);
	/**
     * ͨ�������ߣ���Ŀ�����⣬����״̬����������
     */
	Pager<Topic> find(Long uid, Long cid, String title, Integer status);
	/**
     * ����ָ����Ŀ�ĵ��Ƽ����£����cidΪnull�����ȫ����Ŀ
     */
	Pager<Topic> findRecommendTopics( Long cid);
	

}
