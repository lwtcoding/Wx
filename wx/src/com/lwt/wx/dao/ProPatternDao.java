package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class ProPatternDao extends BaseDao<ProPattern> implements
		IProPatternDao {

	public List<ProPattern> findPatternsByNos(Map<String , Object> alias) {
		String hql="select p from ProPattern p where p.patternNo in (:patternNo)";
		return this.findByAlias(hql, alias);
	}

	public void deleteByNo(String patternNo) {
      String hql="delete  ProPattern p where p.patternNo=?";
		this.executeHql(hql, new Object[]{patternNo});
	}

	public List<ProPattern> fingByProductId(Long id) {
	String hql="from ProPattern pp left join fetch pp.product p where p.id=? ";
		return this.find(hql, id);
	}

	public List<String> findProPatternsNos(Long id) {
		String hql="select pp.patternNo from ProPattern pp where pp.product.id=? ";
		return  this.getCurrentSession().createQuery(hql).setParameter(0, id).list();
	}

	public void deleteByProId(Long id) {
		String hql="delete from ProPattern pp where pp.product.id=?";
		this.executeHql(hql, new Object[]{id});
		
	}



}
