package com.lwt.wx.dao;

import com.lwt.wx.entity.Customer;
import com.lwt.wx.util.dao.IBaseDao;

public interface ICustomerDao extends IBaseDao<Customer> {

	Customer findByUserName(String userName);

}
