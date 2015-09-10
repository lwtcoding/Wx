package com.lwt.wx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IRoleDao;
import com.lwt.wx.entity.Role;

@Service
public class RoleService implements IRoleService {
@Resource
private IRoleDao roleDao;
	public List<Role> findAllRoles() {
		
		return roleDao.find("from Role");
	}

}
