package com.lwt.wx.dao;

import java.util.List;



import com.lwt.wx.entity.Department;
import com.lwt.wx.util.dao.IBaseDao;

public interface IDepartmentDao extends IBaseDao<Department> {

	public List<Department> findByPid(Long pId);

	public Department findById(Long pId);

	public List<Department> findAll();

}
