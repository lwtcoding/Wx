package com.lwt.wx.service;

import com.lwt.wx.entity.Customer;
import com.lwt.wx.entity.Scart;

public interface ICustomerService {

	void save(Customer customer);

	void addCustomerScart(Customer customer);

	Customer findCustomerByName(String userName);

	Scart findCustomerScart(Customer customer);

}
