package com.lwt.wx.dao;

import com.lwt.wx.entity.Scart;
import com.lwt.wx.util.dao.IBaseDao;

public interface IScartDao extends IBaseDao<Scart> {

	Scart findCustomerScart(Long id);

}
