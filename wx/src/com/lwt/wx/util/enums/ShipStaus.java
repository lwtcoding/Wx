package com.lwt.wx.util.enums;

public enum ShipStaus {
	Y("已发货"),N("未发货");
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
