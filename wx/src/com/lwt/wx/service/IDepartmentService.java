package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.entity.Department;
import com.lwt.wx.entity.DepartmentTree;

public interface IDepartmentService {

	public  Department findById(Long pId);

	public void save(Department department);
	
	public List<DepartmentTree> generateDeparmentTree() ;

	public List<Department> findByPid(Long pId);

	public List<Department> findAll();



}
