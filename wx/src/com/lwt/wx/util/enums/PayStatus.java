package com.lwt.wx.util.enums;

public enum PayStatus {
NONE_PAID("δ֧��"),HAVE_PAID("��֧��"),PAID_FALSE("֧��ʧ��");
private String name;

private PayStatus(String name) {
	this.setName(name);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
