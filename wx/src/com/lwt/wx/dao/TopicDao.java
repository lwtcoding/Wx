package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Topic;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class TopicDao extends BaseDao<Topic> implements ITopicDao {

	public Pager<Topic> searchTopic(String content) {
		String hql="from Topic t where t.status=1 and (t.title like '%"+content+"%' or t.content like '%"+content+"%' or t.summary like '%"+content+"%')";
		return this.list(hql);
	}

	public Pager<Topic> searchTopicByKeyword(String keyword) {
		String hql="from Topic t where t.status=1 and (t.keyword like '%"+keyword+"%')";
		return this.list(hql);
	}

	public Pager<Topic> find(Long cid, String title, Integer status) {
		
		return this.find(null, cid, title, status);
	}

	public Pager<Topic> find(Long uid, Long cid, String title, Integer status) {
		StringBuilder sb=new StringBuilder();
		sb.append("from Topic t where 1=1");
		if(uid!=null&&uid>0)
			sb.append("and t.user.id ="+uid);
		if(cid!=null&&cid>0)
			sb.append("and t.channel.id ="+cid);
		if(title!=null&&!"".equals(title.trim()))
			sb.append("and t.title like '%"+title+"%'");
		if(status!=null)
			sb.append("and t.status ="+status);
		return this.list(sb.toString());
	}

	public Pager<Topic> findRecommendTopics(Long cid) {
		String hql="from Topic t where t.status=1 and t.recommend=1 and t.channel.id="+cid;
		if(cid==null||cid==0)
		 hql="from Topic t where t.status=1 and t.recommend=1";
		return this.list(hql);
	}



	

}
