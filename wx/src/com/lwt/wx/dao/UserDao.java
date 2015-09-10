package com.lwt.wx.dao;

import java.util.List;


import org.springframework.stereotype.Repository;



import com.lwt.wx.entity.Department;
import com.lwt.wx.entity.User;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

	public static List<Department> findByPid(Long pId) {
	
		return null;
	}

	public List<User> findUserByDepartment(Long pId) {
		String hql="from User u where u.department.id=?";
		return this.find(hql,new Object[]{pId});
	}

}
