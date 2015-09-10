package com.lwt.wx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IProPatternDao;
import com.lwt.wx.entity.ProPattern;

@Service
public class ProPatternService implements IProPatternService {
@Resource IProPatternDao proPatternDao;
	public void save(ProPattern pattern) {
		proPatternDao.save(pattern);
		
	}
	public void deleteByNo(String patternNo) {
		proPatternDao.deleteByNo(patternNo);
		
	}
	public List<ProPattern> findByProductId(Long id) {
	
		return proPatternDao.fingByProductId(id);
	}

}
