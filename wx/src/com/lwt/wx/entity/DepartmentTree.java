package com.lwt.wx.entity;

public class DepartmentTree {
	private Long id;
	private String name;
	private Long pid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public DepartmentTree(){}
	public DepartmentTree(Long id,String name,Long pid ){
		super();
		this.id=id;
		this.name=name;
		if(pid==null)
			pid=0l;
		this.pid=pid;
	}

}
