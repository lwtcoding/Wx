package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.ProCategory;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class ProCategoryDao extends BaseDao<ProCategory> implements
		IProCategoryDao {

	public List<ProCategory> findAll() {
	String hql="from ProCategory";
		return this.find(hql);
	}

	

}
