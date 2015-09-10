package com.lwt.wx.service;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IChannelDao;
import com.lwt.wx.entity.Channel;
import com.lwt.wx.entity.ChannelTree;
import com.lwt.wx.util.Pager;

@Service
public class ChannelService implements IChannelService {
@Resource
  private IChannelDao channelDao;
	public Pager<Channel> list() {
		
		return channelDao.list("from Channel c order by c.orders");
	}
	public Channel findById(Long id) {
	
		return channelDao.get(Channel.class, id);
	}
	public void add(Channel channel, Long pid) {
		Channel parent=this.findById(pid);
		channel.setParent(parent);
		Integer maxOrder=channelDao.getMaxOrders(pid);
		if(maxOrder==null)
			maxOrder=0;
		channel.setOrders(maxOrder+1);
		channelDao.save(channel);
		
	}
	
	public List<ChannelTree> generateTree(){
		List<Channel> channels=channelDao.find("from Channel c order by orders");
		List<ChannelTree> cts=new ArrayList<ChannelTree>();
		for(Channel c:channels){
			ChannelTree tree=new ChannelTree();
			BeanUtils.copyProperties(c, tree);
			tree.setPid(0L);
			if(c.getParent()!=null)
			tree.setPid(c.getParent().getId());
			cts.add(tree);
		}
		ChannelTree root=new ChannelTree(Channel.ROOT_ID,Channel.ROOT_NAME,-1l);
		cts.add(root);
		return cts;	
	}
	public List<Channel> listByParent(Long pid) {
	return	channelDao.listByParent(pid);
		
	}
	public void update(Channel channel) {
	channelDao.merge(channel);	
	}
	public void delete(Long id) {
		//先判断是否有文章和子栏目未删除
		channelDao.delete(channelDao.get(Channel.class, id));
		
	}
	public void updateOrders(Long id, int orders) {
		channelDao.updateOrder(id,orders);
		
	}
	public Channel load(Long cid) {
	
		return channelDao.get(Channel.class, cid);
	}

}
