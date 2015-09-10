package com.lwt.wx.util.enums;

public enum ChannelType {
	NAV_CHANNEL("������Ŀ"),TOPIC_LIST("�����б���Ŀ"),TOPIC_CONTENT("����������Ŀ"),TOPIC_IMG("ͼƬ�б���Ŀ");
	private String name;

	private ChannelType(String name) {
		this.setName(name);
	}

	private ChannelType() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
