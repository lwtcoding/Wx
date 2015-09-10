package com.lwt.wx.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.Customer;
import com.lwt.wx.service.ICustomerService;
import com.lwt.wx.util.ModelAttribute;
import com.lwt.wx.util.enums.Sex;
import com.lwt.wx.util.enums.util.EnumUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class CustomerAction  extends ActionSupport implements ModelDriven<Customer>{
	@Resource
	private ICustomerService customerService;
	private Customer customer;
	
	
	public String list(){
		return SUCCESS;
	}
	public String addInput(){
		
		ModelAttribute.addAttribute("sexMap", EnumUtils.EnumProp2NameMap(Sex.class, "name"));
		return INPUT;
		}
	public String add(){
		customerService.save(customer);
		customerService.addCustomerScart(customer);
		ModelAttribute.addAttribute("url", "customer_list");
		return "redirect";
		}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getModel() {
		if(customer==null)
			customer=new Customer();
		return customer;
	}

}
