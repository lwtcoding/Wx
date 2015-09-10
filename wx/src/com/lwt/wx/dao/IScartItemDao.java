package com.lwt.wx.dao;

import java.util.List;

import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.entity.ScartItem;
import com.lwt.wx.util.dao.IBaseDao;

public interface IScartItemDao extends IBaseDao<ScartItem> {

	ScartItem findPatternIterm(Long id,Long sid);

	List<Long> findScartProPattern(Long id);

	List<ScartItem> findScartItems(Long scartId);

}
