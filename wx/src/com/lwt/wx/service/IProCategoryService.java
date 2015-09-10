package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.entity.ProCategory;

public interface IProCategoryService {

 public	List<ProCategory> findAll();

public void save(ProCategory category);


public void saveOrUpdate(ProCategory category);

}
