package com.lwt.wx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	private Long id;
	private Product product;
	private ProPattern proPattern;
	private Integer quantity;
	private Double charge;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne
	public ProPattern getProPattern() {
		return proPattern;
	}
	public void setProPattern(ProPattern proPattern) {
		this.proPattern = proPattern;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getCharge() {
		return charge;
	}
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	
	
}
