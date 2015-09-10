package com.lwt.wx.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.DepartmentDao;
import com.lwt.wx.dao.IDepartmentDao;
import com.lwt.wx.dao.UserDao;
import com.lwt.wx.entity.Department;
import com.lwt.wx.entity.DepartmentTree;
import com.lwt.wx.util.Pager;
@Service
public class DepartmentService implements IDepartmentService {
@Resource
private IDepartmentDao departmentDao;

	public Department findById(Long pId) {
	
		return departmentDao.findById(pId);
	}

	public void save(Department department) {
		departmentDao.saveOrUpdate(department);
		
	}

	public List<DepartmentTree> generateDeparmentTree() {
		String hql="from Department";
		List<Department> departments=departmentDao.find(hql);
		List<DepartmentTree> departmentTrees=new ArrayList<DepartmentTree>();
		for(Department d:departments){
			DepartmentTree departmentTree=null;
			if(d.getParent()==null){
			 departmentTree=new DepartmentTree(d.getId(),d.getName(),0L);
			}else{
			departmentTree=new DepartmentTree(d.getId(),d.getName(),d.getParent().getId());
			}
			departmentTrees.add(departmentTree);
		}
		return departmentTrees;
	}

	public List<Department> findByPid(Long pId) {

		return departmentDao.findByPid(pId);
	}

	public List<Department> findAll() {
	
		return departmentDao.findAll();
	}


}
