package com.lwt.wx.dto;

import java.util.List;
import java.util.UUID;

import com.lwt.wx.entity.Product;
import com.lwt.wx.util.enums.ProStatus;

public class ProductDTO {
	private Long id;
	private String productNo;
	private String name;
	private ProStatus proStatus;
	private Double marketPrice;
	private Double price;
    private Integer store;
    
    private String[] attName;
    private String[] patternNo;
    private Long categoryId;
    
    
    
    
    public ProductDTO() {
		
	}
    
    
    public ProductDTO(Product product) {
		this.id=product.getId();
		this.marketPrice=product.getMarketPrice();
		this.name=product.getName();
		this.price=product.getPrice();
		this.productNo=this.getProductNo();
		this.proStatus=product.getProStatus();
		this.store=product.getStore();
	}
    public ProductDTO(Product product,List<String> attNewNames) {
		this.id=product.getId();
		this.marketPrice=product.getMarketPrice();
		this.name=product.getName();
		this.price=product.getPrice();
		this.productNo=this.getProductNo();
		this.proStatus=product.getProStatus();
		this.store=product.getStore();
		this.attName=new String[attNewNames.size()];
		attNewNames.toArray(this.attName);
	}


	public Product DTO2Product(){
    	Product product=new Product();
    	product.setId(id);
    	product.setMarketPrice(this.marketPrice);
    	product.setName(this.name);
    	product.setPrice(this.price);
    	product.setProductNo(UUID.randomUUID().toString().replaceAll("-", ""));
    	product.setProStatus(this.proStatus);
    	product.setStore(this.store);
    	
		return product;
    	
    	
    }
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
	public String[] getAttName() {
		return attName;
	}
	public void setAttName(String[] attName) {
		this.attName = attName;
	}
	public String[] getPatternNo() {
		return patternNo;
	}
	public void setPatternNo(String[] patternNo) {
		this.patternNo = patternNo;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
    
	
    
}
