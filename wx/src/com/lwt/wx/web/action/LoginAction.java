package com.lwt.wx.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.Customer;
import com.lwt.wx.entity.Scart;
import com.lwt.wx.service.ICustomerService;
import com.lwt.wx.util.ModelAttribute;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<Customer>{
	@Resource
	private ICustomerService customerService;
  private Customer loginUser;
  
  public String login(){
	Customer customer=customerService.findCustomerByName(loginUser.getUserName());
	if(customer==null) {
		System.out.println("用户不存在");
		ModelAttribute.addAttribute("url", "/page/login/addInput.jsp");
		return "redirect";
	}else {
		if(!customer.getPassword().equals(loginUser.getPassword())){
			System.out.println("用户不存在或密码错误");
			ModelAttribute.addAttribute("url", "/page/login/addInput.jsp");
			return "redirect";
		}else {
			Scart scart=customerService.findCustomerScart(customer);
//			ModelAttribute.addAttribute("loginUser", customer);
//			ModelAttribute.addAttribute("myScart", scart);
			ActionContext.getContext().getSession().put("loginUser", customer);
			ActionContext.getContext().getSession().put("myScart", scart);
		ModelAttribute.addAttribute("url", "product_shopping");
			return "redirect";
		}
	}

  }

public Customer getLoginUser() {
	return loginUser;
}

public void setLoginUser(Customer loginUser) {
	this.loginUser = loginUser;
}

public Customer getModel() {
	if(loginUser==null)
		loginUser=new Customer();
	return loginUser;
}
}
