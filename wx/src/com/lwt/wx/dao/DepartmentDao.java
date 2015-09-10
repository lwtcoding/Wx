package com.lwt.wx.dao;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import com.lwt.wx.entity.Department;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class DepartmentDao extends BaseDao<Department> implements
		IDepartmentDao {

	public List<Department> findByPid(Long pId) {

		String hql=null;
		if(pId==null||pId==0){
			hql="select dp from Department dp where dp.parent is null";
		return this.find(hql);
		}else {
			hql="select dp from Department dp left join fetch dp.parent dparent where dparent.id=?";
			return this.find(hql,new Object[]{pId});
		}
	}

	public Department findById(Long pId) {

		return get(Department.class, pId);
	}

	public List<Department> findAll() {
		String hql="from Department";
		return this.find(hql);
	}

	

}
