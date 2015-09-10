package com.lwt.wx.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.lwt.wx.util.enums.ProStatus;
@Entity
public class Product {
	private Long id;
	private String productNo;
	private String name;
	private ProStatus proStatus;
	private Double marketPrice;
	private Double price;
    private Integer store;
    private ProCategory category;
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Enumerated(EnumType.STRING)
	public ProStatus getProStatus() {
		return proStatus;
	}
	public void setProStatus(ProStatus proStatus) {
		this.proStatus = proStatus;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStore() {
		return store;
	}
	public void setStore(Integer store) {
		this.store = store;
	}
	@ManyToOne
	public ProCategory getCategory() {
		return category;
	}
	public void setCategory(ProCategory category) {
		this.category = category;
	}
    
    
	
}
