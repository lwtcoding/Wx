package com.lwt.wx.dao;

import java.util.List;

import com.lwt.wx.entity.Channel;
import com.lwt.wx.entity.ChannelTree;
import com.lwt.wx.util.dao.IBaseDao;

public interface IChannelDao extends IBaseDao<Channel> {
	public Integer getMaxOrders(Long pid);

	public List<ChannelTree> generateTree();

	public List<Channel> listByParent(Long pid);

	public void updateOrder(Long id, int orders);

}
