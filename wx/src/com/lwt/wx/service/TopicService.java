package com.lwt.wx.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IKeywordDao;
import com.lwt.wx.dao.ITopicDao;
import com.lwt.wx.dao.KeywordDao;
import com.lwt.wx.entity.Channel;
import com.lwt.wx.entity.Keyword;
import com.lwt.wx.entity.Topic;
import com.lwt.wx.entity.User;
import com.lwt.wx.util.Pager;

@Service
public class TopicService implements ITopicService {
	@Resource
	private ITopicDao topicDao;
	@Resource
	private IUserService userService;
	@Resource
	private IChannelService channelService;
	@Resource
	private IAttachmentService attachmentService;
	@Resource 
	private IKeywordDao keywordDao;
	
	public Pager<Topic> find(String content) {
	  
		return topicDao.searchTopic( content);
	}

	public Pager<Topic> find(Long cid, String title, Integer status) {

		return topicDao.find(cid, title, status);
	}

	public Pager<Topic> find(Long uid, Long cid, String title, Integer status) {

		return topicDao.find(uid, cid, title, status);
	}

	public void add(Topic topic, Long cid, Long uid, Long[] attid, String keyword) {
		User u= null;
			if(uid!=null)	u=userService.load(uid);
		Channel c=null;
			if(cid!=null) c=channelService.load(cid);	
		if(u==null||c==null){}
		topic.setCreateDate(new Date());
		if(u!=null)
		topic.setAuthor(u.getUserName());
		topic.setChannel(c);
		topic.setUser(u);
		topicDao.save(topic);
		attachmentService.addTopicAttachs(topic, attid);
		if(keyword!=null&&!"".equals(keyword.trim())){
		String[] keywords=keyword.split("|");
//		for(String kw:keywords){
//			kw=kw.trim();
//			Keyword keyw=KeywordDao.findByName();
//			if(keyw==null){
//				keyw=new Keyword();
//				keyw.setName(kw);
//				keyw.setTimes(1);
//				keyw.setNameShortPy("");
//				keyw.setNameFullPy("");
//				keywordDao.save(keyw);
//			}else{
//				keyw.setTimes(keyw.getTimes()+1);
//				keywordDao.merge(keyw);
//			}
//		}
		}
		
	}

}
