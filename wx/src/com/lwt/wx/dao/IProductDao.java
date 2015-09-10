package com.lwt.wx.dao;

import com.lwt.wx.entity.Product;
import com.lwt.wx.util.dao.IBaseDao;

public interface IProductDao extends IBaseDao<Product> {

	void deleteById(Long id);

}
