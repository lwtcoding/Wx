package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.entity.ProPattern;

public interface IProPatternService {

	public void save(ProPattern pattern);

	public void deleteByNo(String patternNo);

	public List<ProPattern> findByProductId(Long id);

}
