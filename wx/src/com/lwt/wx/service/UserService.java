package com.lwt.wx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IUserDao;
import com.lwt.wx.entity.User;

@Service
public class UserService implements IUserService{
	@Resource
 private IUserDao userDao;

	public void save(User user) {
	userDao.saveOrUpdate(user);
		
	}

	public List<User> findAllUser() {
		
		return userDao.find("from User");
	}

	public List<User> findUserByDeparment(Long pId) {

		return userDao.findUserByDepartment(pId);
	}

	public User load(Long uid) {
		
		return userDao.get(User.class, uid);
	}
}
