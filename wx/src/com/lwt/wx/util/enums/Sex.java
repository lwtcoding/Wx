package com.lwt.wx.util.enums;

public enum Sex {
FEMALE("Ů"),MALE("��");
private String name;


private Sex(){}
private Sex(String name){
	this.setName(name);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
