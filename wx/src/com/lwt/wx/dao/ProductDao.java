package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Product;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class ProductDao extends BaseDao<Product> implements IProductDao {

	public void deleteById(Long id) {
		String hql="delete from Product p where p.id=?";
		this.executeHql(hql, new Object[]{id});
		
	}

}
