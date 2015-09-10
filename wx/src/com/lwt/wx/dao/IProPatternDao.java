package com.lwt.wx.dao;

import java.util.List;
import java.util.Map;

import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.util.dao.IBaseDao;

public interface IProPatternDao extends IBaseDao<ProPattern> {

public List<ProPattern> findPatternsByNos(Map<String , Object> alias);

public void deleteByNo(String patternNo);

public List<ProPattern> fingByProductId(Long id);

public List<String> findProPatternsNos(Long id);

public void deleteByProId(Long id);

}
