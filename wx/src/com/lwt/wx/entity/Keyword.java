package com.lwt.wx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Keyword {
	private int id;
	/**
	 * 关键字名称
	 */
	private String name;
	/**
	 * 关键字引用次数
	 */
	private Integer times;
	/**
	 * 关键字全拼
	 */
	private String nameFullPy;
	/**
	 * 关键字简拼
	 */
	private String nameShortPy;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public String getNameFullPy() {
		return nameFullPy;
	}
	public void setNameFullPy(String nameFullPy) {
		this.nameFullPy = nameFullPy;
	}
	public String getNameShortPy() {
		return nameShortPy;
	}
	public void setNameShortPy(String nameShortPy) {
		this.nameShortPy = nameShortPy;
	}
	
	
}
