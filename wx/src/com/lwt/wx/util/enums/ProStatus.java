package com.lwt.wx.util.enums;

public enum ProStatus {
	SOLD_IN("ио╪э"),SOLD_OUT("об╪э");
	private String name;

	private ProStatus(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
