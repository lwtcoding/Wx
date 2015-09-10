package com.lwt.wx.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.ICustomerDao;
import com.lwt.wx.dao.IScartDao;
import com.lwt.wx.entity.Customer;
import com.lwt.wx.entity.Scart;

@Service
public class CustomerService implements ICustomerService{
  @Resource
	private ICustomerDao customerDao;
  @Resource
  private IScartDao scartDao;
	public void save(Customer customer) {
		customerDao.saveOrUpdate(customer);
		
	}
	public void addCustomerScart(Customer customer) {
		Scart scart=new Scart();
		scart.setCustomer(customer);
		scart.setCreateTime(new Date());
		scartDao.saveOrUpdate(scart);
		
	}
	public Customer findCustomerByName(String userName) {
		
		return customerDao.findByUserName(userName);
	}
	public Scart findCustomerScart(Customer customer) {
		
		return scartDao.findCustomerScart(customer.getId());
	}

}
