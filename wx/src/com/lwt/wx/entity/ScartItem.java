package com.lwt.wx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ScartItem {
	private Long id;
	private Scart scart;
	private Product product;
	private ProPattern pattern;
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
	public Scart getScart() {
		return scart;
	}
	public void setScart(Scart scart) {
		this.scart = scart;
	}
	@ManyToOne
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne
	public ProPattern getPattern() {
		return pattern;
	}
	public void setPattern(ProPattern pattern) {
		this.pattern = pattern;
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
