package com.lwt.wx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
private Long id;
private User user;
private Role role;

@Id
@GeneratedValue
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@ManyToOne
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@ManyToOne
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}


}
