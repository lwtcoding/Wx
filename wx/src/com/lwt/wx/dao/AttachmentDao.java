package com.lwt.wx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lwt.wx.entity.Attachment;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.dao.BaseDao;
@Repository
public class AttachmentDao extends BaseDao<Attachment> implements
		IAttachmentDao {

	public List<Attachment> findAttsByNewNames(Map<String, Object> alias) {
		String hql="select att from Attachment att where att.newName in (:newName)";
		return this.findByAlias(hql, alias);
	}

	public List<Attachment> findByProductId(Long id) {
	String hql="from Attachment a left join fetch a.product p where p.id=?";
		return this.find(hql, id);
	}

	public List<String> findProAttachmentNames(Long id) {
		String hql="select att.newName from Attachment att where att.product.id=?";
		return this.getCurrentSession().createQuery(hql).setParameter(0, id).list();
	}

	public void deleteByProId(Long id) {
		String hql="delete from Attachment att where att.product.id=?";
		this.executeHql(hql, new Object[]{id});
		
	}

	public void deleteByName(String newName) {
		String hql="delete from Attachment att where att.newName=?";
		this.executeHql(hql, new Object[]{newName});
	}

	

	

}
