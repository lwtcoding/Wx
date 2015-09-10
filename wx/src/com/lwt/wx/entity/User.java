package com.lwt.wx.entity;



import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lwt.wx.util.enums.Sex;



@Entity
public class User {
private Long id;
private String  userName;
private String password;
private String email;
private Integer phone;
private Sex sex;
private Department department;
@Id
@GeneratedValue
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getPhone() {
	return phone;
}
public void setPhone(Integer phone) {
	this.phone = phone;
}
@Enumerated(EnumType.STRING)
public Sex getSex() {
	return sex;
}
public void setSex(Sex sex) {
	this.sex = sex;
}
@ManyToOne
@JoinColumn(name="dpId")
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}

}
