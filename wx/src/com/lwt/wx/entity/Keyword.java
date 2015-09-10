package com.lwt.wx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Keyword {
	private int id;
	/**
	 * �ؼ�������
	 */
	private String name;
	/**
	 * �ؼ������ô���
	 */
	private Integer times;
	/**
	 * �ؼ���ȫƴ
	 */
	private String nameFullPy;
	/**
	 * �ؼ��ּ�ƴ
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
