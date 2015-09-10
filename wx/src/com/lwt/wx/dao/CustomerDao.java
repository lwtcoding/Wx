package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Customer;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class CustomerDao extends BaseDao<Customer> implements ICustomerDao {

	public Customer findByUserName(String userName) {
		String hql="from Customer c where c.userName=?";
		return this.get(hql, userName);
	}

	

}
