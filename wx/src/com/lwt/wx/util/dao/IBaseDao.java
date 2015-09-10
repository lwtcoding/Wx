package com.lwt.wx.util.dao;

import java.io.Serializable;

import java.util.List;
import java.util.Map;


import com.lwt.wx.util.Pager;

public interface IBaseDao<T> {
	/** 
     *保存
     *  
     * @param o 
     */ 
	 public Serializable save(T o);  
	  
	    /** 
	     * 删除
	     *  
	     * @param o 
	     */  
	    public void delete(T o);  
	  
	    /** 
	     * 更新
	     *  
	     * @param o 
	     */  
	    public void merge(T o);  
	  
	    /** 
	     * 更新或保存
	     *  
	     * @param o 
	     */  
	    public void saveOrUpdate(T o);  
	  
	    /** 
	     * find
	     *  
	     * @param hql 
	     * @return 
	     */  
	    public List<T> find(String hql);  	  	  	    
	    public List<T> find(String hql, Object[] param);  
	  

	    public List<T> findByAlias(String hql, Map<String,Object> alias);
	    public List<T> find(String hql, Map<String,Object> alias , Object[] params);
	
	    public Pager<T> list(String hql); 
	    public Pager<T> list(String hql, Object[] params);  
	    public Pager<T> listByAlias(String hql, Map<String,Object> alias);
	    public Pager<T> listByAlias(String hql, Map<String,Object> alias , Object[] params);
	    /** 
	     * 鏌ヨ闆嗗悎(甯﹀垎椤� 
	     *  
	     * @param hql 
	     * @param param 
	     * @param page 
	     * @param rows 
	     * @return 
	     */  
	    
	  
	    /** 
	     * 查询一个对象
	     *  
	     * @param c 
	     *           clazz
	     * @param id 
	     * @return Object 
	     */  
	    public T get(Class<T> c, Serializable id);  

	    public T get(String hql, Object[] param);  
	    public T get(String hql, Map<String,Object> alias); 
	    public T get(String hql, Map<String,Object> alias,Object[] params); 
	    /** 
	     * select count(*) from 绫�
	     *  
	     * @param hql 
	     * @param param 
	     * @return 
	     */  
	    public Long count(String hql);  

	    public Long count(String hql, Object[] param);  
	    public Long count(String hql, Map<String,Object> alias); 
	    public Long count(String hql, Map<String,Object> alias,Object[] params);

	  

	    public Integer executeHql(String hql);  
	 
	    public Integer executeHql(String hql, Object[] params);  
	  	   
	    public Integer executeAliasHql(String hql, Map<String,Object> alias);
	    
	    public Integer executeHql(String hql, Map<String,Object> alias, Object[] params);

}
