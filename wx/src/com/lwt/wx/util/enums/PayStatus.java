package com.lwt.wx.util.enums;

public enum PayStatus {
NONE_PAID("未支付"),HAVE_PAID("已支付"),PAID_FALSE("支付失败");
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
