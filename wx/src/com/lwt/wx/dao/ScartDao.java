package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Scart;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class ScartDao extends BaseDao<Scart> implements IScartDao {

	public Scart findCustomerScart(Long id) {
		String hql="from Scart s where s.customer.id=?";
		return this.get(hql, id);
	}

	

}
