package com.lwt.wx.web.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.Department;
import com.lwt.wx.entity.Role;
import com.lwt.wx.entity.User;
import com.lwt.wx.service.IDepartmentService;
import com.lwt.wx.service.IRoleService;
import com.lwt.wx.service.IUserService;
import com.lwt.wx.util.enums.Sex;
import com.lwt.wx.util.enums.util.EnumUtils;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	@Resource
	private IDepartmentService departmentService;
	
	private User user;
	private List<User> userlist;
    private Long dpId;
	public String list() throws IOException{
	
	userlist=userService.findAllUser();
	ActionContext.getContext().put("users", userlist);
	System.out.println(userlist.size());
          return SUCCESS;
	}
	public String addInput(){
	
		//if(user.getId()!=null)
			//user=userService.findById();
		    List<Department> departments=departmentService.findAll();
		    
			List<Role> roles=roleService.findAllRoles();
			ActionContext.getContext().put("departmentList", departments);
			ActionContext.getContext().put("roleList", roles);
			ActionContext.getContext().put("sexMap", EnumUtils.EnumProp2NameMap(Sex.class, "name"));
		return INPUT;
	}
	public String add(){
if(dpId!=null){
	Department department=departmentService.findById(dpId);
	user.setDepartment(department);
}
		userService.save(user);
		ActionContext.getContext().put("url", "user_list");
		return "redirect";
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getModel() {
	if(user==null)
		user=new User();
		return user;
	}
	public List<User> getUserlist() {
		System.out.println("getter userlist" );
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public Long getDpId() {
		return dpId;
	}
	public void setDpId(Long dpId) {
		this.dpId = dpId;
	}



}
