package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.entity.ScartItem;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class ScartItemDao extends BaseDao<ScartItem> implements
		IScartItemDao {

	public ScartItem findPatternIterm(Long id,Long sid) {
		String hql="from ScartItem si where si.pattern.id=? and si.scart.id=?";
		return this.get(hql, new Object[]{id , sid});
	}

	public List<Long> findScartProPattern(Long id) {
	String hql="select si.pattern.id from ScartItem si where si.scart.id=?";
		return this.getCurrentSession().createQuery(hql).setParameter(0, id).list();
	}

	public List<ScartItem> findScartItems(Long scartId) {
	String hql="from ScartItem si where si.scart.id=?";
		return this.find(hql, scartId);
	}

}
