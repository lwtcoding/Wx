package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Order;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class OrderDao extends BaseDao<Order> implements IOrderDao {

	public List<Order> findAll(){
		String hql="from Order";
		return this.find(hql);
	}

}
