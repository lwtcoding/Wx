package com.lwt.wx.dao;

import java.util.List;
import java.util.Map;

import com.lwt.wx.entity.Attachment;
import com.lwt.wx.util.dao.IBaseDao;

public interface IAttachmentDao extends IBaseDao<Attachment> {

public	List<Attachment> findAttsByNewNames(Map<String, Object> alias);

public List<Attachment> findByProductId(Long id);

public List<String> findProAttachmentNames(Long id);

public void deleteByProId(Long id);

public void deleteByName(String newName);



}
