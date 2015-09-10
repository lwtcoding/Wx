package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.entity.User;

public interface IUserService {

	public void save(User user);

	public List<User> findAllUser();

	public List<User> findUserByDeparment(Long pId);

	public User load(Long uid);

}
