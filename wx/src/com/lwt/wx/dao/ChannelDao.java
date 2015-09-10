package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Channel;
import com.lwt.wx.entity.ChannelTree;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {

	public Integer getMaxOrders(Long pid) {
		if(pid!=null&&pid!=0){
		String hql="select max(c.orders) from Channel c where c.parent.id=?";
		return (Integer) this.getCurrentSession().createQuery(hql).setParameter(0, pid).list().get(0);
	}else{
		String hql="select max(c.orders) from Channel c where c.parent.id is null";
		return (Integer) this.getCurrentSession().createQuery(hql).list().get(0);
	}

	}

	public List<ChannelTree> generateTree() {
		String hql="select id, name ,pid from channel  order by orders";
		SQLQuery sq=getCurrentSession().createSQLQuery(hql);
		sq.setResultTransformer(Transformers.aliasToBean(ChannelTree.class));
		List<ChannelTree> ct= sq.list();
	  return null;
	}

	public List<Channel> listByParent(Long pid) {
		if(pid==null||pid==0){
			String hql="from Channel c where c.parent.id is null order by orders";
			return this.find(hql);
		}else{
			String hql="from Channel c where c.parent.id = ? order by orders";
			return this.find(hql, pid);
		}
			
	
	}

	public void updateOrder(Long id, int orders) {
		String hql="update Channel c set c.orders=? where c.id=? ";
		this.executeHql(hql, new Object[]{orders,id});
		
	}



}
