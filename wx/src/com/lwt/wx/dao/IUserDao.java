package com.lwt.wx.dao;

import java.util.List;


import com.lwt.wx.entity.User;
import com.lwt.wx.util.dao.IBaseDao;

public interface IUserDao extends IBaseDao<User> {

	List<User> findUserByDepartment(Long pId);

}
