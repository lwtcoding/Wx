package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.entity.Channel;
import com.lwt.wx.entity.ChannelTree;
import com.lwt.wx.util.Pager;

public interface IChannelService {

	Pager<Channel> list();

	Channel findById(Long pid);

	void add(Channel channel, Long pid);
	
	List<ChannelTree> generateTree();

	List<Channel> listByParent(Long pid);

	void update(Channel channel);

	void delete(Long id);

	void updateOrders(Long id, int i);

	Channel load(Long cid);

}
