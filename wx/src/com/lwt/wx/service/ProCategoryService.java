package com.lwt.wx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IProCategoryDao;
import com.lwt.wx.entity.ProCategory;

@Service
public class ProCategoryService implements IProCategoryService {
@Resource
 private IProCategoryDao proCategoryDao;

    public void save(ProCategory proCategory){
    	proCategoryDao.save(proCategory);
    }
    
    public void saveOrUpdate(ProCategory proCategory){
    	proCategoryDao.saveOrUpdate(proCategory);
    }
	public List<ProCategory> findAll() {
		
		return proCategoryDao.findAll();
	}

}
