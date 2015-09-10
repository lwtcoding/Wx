package com.lwt.wx.service;

import com.lwt.wx.entity.Topic;
import com.lwt.wx.util.Pager;

public interface ITopicService {
	Pager<Topic> find(String content);
	Pager<Topic> find(Long cid,String title, Integer status );
	Pager<Topic> find(Long uid,Long cid,String title, Integer status );
	void add(Topic topic, Long cid, Long id, Long[] attid, String keyword);

}
