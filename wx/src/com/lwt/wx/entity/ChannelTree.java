package com.lwt.wx.entity;

public class ChannelTree {
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
	public ChannelTree(Long id, String name, Long pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	public ChannelTree() {
		super();
	}

	
  
	
}
