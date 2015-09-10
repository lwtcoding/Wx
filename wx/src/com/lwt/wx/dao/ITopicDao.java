package com.lwt.wx.dao;

import com.lwt.wx.entity.Topic;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.IBaseDao;

public interface ITopicDao extends IBaseDao<Topic> {
    /**
     * 通过内容检索全部文章，会在标题，内容，摘要上检索
     */
	Pager<Topic> searchTopic(String content);
	 /**
     * 通过文章关键字检索全部文章
     */
	Pager<Topic> searchTopicByKeyword(String keyword);
	 /**
     * 通过栏目，标题，文章状态来检索文章
     */
	Pager<Topic> find(Long cid, String title, Integer status);
	/**
     * 通过发布者，栏目，标题，文章状态来检索文章
     */
	Pager<Topic> find(Long uid, Long cid, String title, Integer status);
	/**
     * 搜索指定栏目的的推荐文章，如果cid为null则检索全部栏目
     */
	Pager<Topic> findRecommendTopics( Long cid);
	

}
