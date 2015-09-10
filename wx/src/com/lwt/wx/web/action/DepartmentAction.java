package com.lwt.wx.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.Department;
import com.lwt.wx.entity.DepartmentTree;
import com.lwt.wx.entity.User;
import com.lwt.wx.service.IDepartmentService;
import com.lwt.wx.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	@Resource
	private IDepartmentService departmentService;
	@Resource
	private IUserService userService;
	
	private List<User> users;
	private Department department;
	
	
	private List<Department> departments;
	
	public String list(){
		return SUCCESS;
	}
	public String listChildern(){
		Long pId=null;
		String pIdString=ServletActionContext.getRequest().getParameter("pid");	
	
		if (pIdString!=null&&!"".equals(pIdString.trim())) 
			pId=Long.parseLong(pIdString);
       ActionContext.getContext().put("pId", pId);
	departments=departmentService.findByPid(pId);
      
		return SUCCESS;
	}
	
	public String addInput(){
		Long pId=null;
		String pIdString=ServletActionContext.getRequest().getParameter("pid");
		if (pIdString!=null&&!"".equals(pIdString.trim())) 
			pId=Long.parseLong(pIdString);
		  ActionContext.getContext().put("pId", pId);
		

		return INPUT;
	}
	
	public String add(){
		String idString=ServletActionContext.getRequest().getParameter("pId");
		Long pId=null;
		if(idString!=null&&!idString.trim().equals(""))
           pId=Long.parseLong(idString);
		if(pId!=null){
			Department parent=departmentService.findById(pId);
		    department.setParent(parent);
		}
		departmentService.save(department);
		ActionContext.getContext().put("url", "department_listChildern?pid="+pId);
		return "redirect";
	}
	public void generateTree() throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<DepartmentTree> departmentTrees=departmentService.generateDeparmentTree();
		JSONArray jsonObject=JSONArray.fromObject(departmentTrees);
		System.out.println(jsonObject.toString());
		out.print(jsonObject.toString());
		out.close();
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getModel() {
		if(department==null)
			department=new Department();
		return department;
	}

	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}





	

}
