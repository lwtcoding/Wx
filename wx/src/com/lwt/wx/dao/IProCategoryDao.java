package com.lwt.wx.dao;

import java.util.List;

import com.lwt.wx.entity.ProCategory;
import com.lwt.wx.util.dao.IBaseDao;

public interface IProCategoryDao extends IBaseDao<ProCategory> {

	public List<ProCategory> findAll();

}
