package com.lwt.wx.util.dao;

import java.io.Serializable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import com.lwt.wx.util.Pager;
import com.lwt.wx.util.SystemContext;

public class BaseDao<T> implements IBaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	protected Session getCurrentSession() {  
		return sessionFactory.getCurrentSession();  
	}  


	public Serializable save(T o) {  
		return this.getCurrentSession().save(o);  
	}  
	
	public void delete(T o) {  
		this.getCurrentSession().delete(o);  
	}  

	public void merge(T o) {  
		this.getCurrentSession().merge(o);  
	}  

	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
		
	}


	public List<T> find(String hql) {

		return this.find(hql, null);
	}


	public List<T> find(String hql, Object param) {
		
		return this.find(hql, new Object[]{param});
	}


	public List<T> find(String hql, Object[] param) {
	
		return find(hql, null, param);
	}


	

public List<T> findByAlias(String hql, Map<String, Object> alias) {

		return find(hql, alias, null);
	}
public List<T> find(String hql, Map<String, Object> alias,
		Object[] params) {
	hql = hqlSort(hql);
	Query query=this.getCurrentSession().createQuery(hql);
	setAlias(alias, query);
	setParams(params, query);
		return query.list();
	
}


private void setParams(Object[] params, Query query) {
	if(params!=null&&params.length>0){
		int index=0;
	for(Object param: params){
		query.setParameter(index++, param);
	}
	}
}


private void setAlias(Map<String, Object> alias, Query query) {
	if(alias!=null&&alias.size()>0){
		Set<String> keys=alias.keySet();
		for(String key:keys){
			Object val=alias.get(key);
			if(val instanceof Collection){
				query.setParameterList(key, (Collection) val);
			}else{
				query.setParameter(key, val);
			}
		}
	}
}




	public T get(Class<T> c, Serializable id) {

		return (T) getCurrentSession().get(c, id);
	}

	public T get(String hql, Object param) {
	return this.get(hql, new Object[]{param});
	}
	public T get(String hql, Object[] param) {
	
		return this.get(hql, null, param);
	}


	public T get(String hql, List<Object> param) {
		
		return this.get(hql, null, param.toArray());
	}
	public T get(String hql, Map<String, Object> alias) {
		
		return this.get(hql, alias, null);
	}


	public T get(String hql, Map<String, Object> alias, Object[] params) {
		Query query=getCurrentSession().createQuery(hql);
		setParams(params, query);
		setAlias(alias, query);
			return (T) query.uniqueResult();
	}

	
	public Long count(String hql) {
		
		return this.count(hql, null,null);
	}


	public Long count(String hql, Object[] param) {

		return this.count(hql, null, param);
	}

	public Long count(String hql, Map<String, Object> alias) {
	
		return this.count(hql, alias, null);
	}


	public Long count(String hql, Map<String, Object> alias, Object[] params) {
		Query query=getCurrentSession().createQuery(hql);
		setParams(params, query);
		setAlias(alias, query);
			return (Long) query.uniqueResult();
	}








	private String hqlSort(String hql) {
		String sort=SystemContext.getSort();
	
			
		String order=SystemContext.getOrder();
		if(sort!=null&&!"".equals(sort.trim())){
			hql=hql+" order by "+sort;
		}
		if(order!=null){
		if("desc".equals(order.trim())){
			hql+=" desc";
		}else{
			hql+=" asc";
		}
		}
		return hql;
	}


	public Pager<T> list(String hql) {
	
		return list(hql, null);
	}


	public Pager<T> list(String hql, Object param) {
		
		return list(hql, new Object[]{param});
	}


	public Pager<T> list(String hql, Object[] params) {

		return listByAlias(hql, null, params);
	}


	public Pager<T> listByAlias(String hql, Map<String, Object> alias) {
		
		return listByAlias(hql, alias, null);
	}


	public Pager<T> listByAlias(String hql, Map<String, Object> alias,
			Object[] params) {
		hql=hqlSort(hql);
		System.out.println(hql);
	    String countHql=getCountHql(hql);
	    System.out.println(countHql);
	    Query query=getCurrentSession().createQuery(hql);
	    Query cquery=getCurrentSession().createQuery(countHql);
	    
	    setAlias(alias, query);
	    setAlias(alias, cquery);
	    
	    setParams(params, query);
	    setParams(params, cquery);
	    
	    Pager<T> pages= new Pager<T>();
	    Integer offset=SystemContext.getPageOffset();
	    Integer pageSize=SystemContext.getPageSize();
	    if(offset==null||offset<0)
	    	offset=0;
	    if(pageSize==null||pageSize<0)
	    	pageSize=15;
	    pages.setPageNumber(offset);
	    pages.setPageSize(pageSize);
	    query.setFirstResult((offset-1)*pageSize).setMaxResults(pageSize);
	    Long totalCount=(Long) cquery.uniqueResult();
	    if(totalCount<=0)
	    	return pages.EMPTY_PAGE;
	    pages.setTotalRecordsCount(totalCount);
	    List<T> Objects=query.list();
	    pages.setObjectsList(Objects);
	    
		return pages;
	}


	private String getCountHql(String hql) {
		String count="select count(*) ";
	    String cq=hql.substring(hql.indexOf("from"));
	    count+=cq;
	    if(count.contains("fecth"))
	    	count.replace("fecth", "");
	    return count;
	}


	public Integer executeHql(String hql) {
	
		return executeHql(hql, null);
	}


	public Integer executeHql(String hql, Object[] params) {
	
		return executeHql(hql, null, params);
	}


	public Integer executeAliasHql(String hql, Map<String, Object> alias) {
	
		return executeHql(hql, alias, null);
	}


	public Integer executeHql(String hql, Map<String, Object> alias,
			Object[] params) {
		Query query=getCurrentSession().createQuery(hql);
		setAlias(alias, query);
		setParams(params, query);
		
		return query.executeUpdate();
	}






}
