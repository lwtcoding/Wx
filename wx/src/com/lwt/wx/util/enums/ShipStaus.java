package com.lwt.wx.util.enums;

public enum ShipStaus {
	Y("�ѷ���"),N("δ����");
private String name;

private ShipStaus(String name) {
	this.setName(name);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
