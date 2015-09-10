package com.lwt.wx.dao;

import java.util.List;

import com.lwt.wx.entity.Order;
import com.lwt.wx.util.dao.IBaseDao;

public interface IOrderDao extends IBaseDao<Order> {
	public List<Order> findAll();

}
