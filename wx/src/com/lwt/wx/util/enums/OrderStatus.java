package com.lwt.wx.util.enums;

public enum OrderStatus {
	COMPLETE("�����"),CLOSED("�ر�");
private  String name;

private OrderStatus(String name) {
	this.setName(name);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
