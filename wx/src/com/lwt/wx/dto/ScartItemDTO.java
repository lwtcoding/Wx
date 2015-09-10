package com.lwt.wx.dto;

import java.util.List;

import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.entity.Product;
import com.lwt.wx.entity.Scart;
import com.lwt.wx.entity.ScartItem;

public class ScartItemDTO {
	//dto2entity
   private Long productId;
   private Long patternId;
   private Integer quantity;
   //entity2dto
    private Long id;
	private Product product;
	private ProPattern pattern;
	private Double charge;
	private List<String> attNames;
	
	public ScartItemDTO(){}
	public ScartItemDTO(ScartItem item,List<String> attNames){
		this.id=item.getId();
		this.product=item.getProduct();
		this.pattern=item.getPattern();
		this.charge=item.getCharge();
		this.attNames=attNames;
		this.quantity=item.getQuantity();
	}
public Long getProductId() {
	return productId;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
public Long getPatternId() {
	return patternId;
}
public void setPatternId(Long patternId) {
	this.patternId = patternId;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public ProPattern getPattern() {
	return pattern;
}
public void setPattern(ProPattern pattern) {
	this.pattern = pattern;
}
public Double getCharge() {
	return charge;
}
public void setCharge(Double charge) {
	this.charge = charge;
}

public List<String> getAttNames() {
	return attNames;
}
public void setAttNames(List<String> attNames) {
	this.attNames = attNames;
}

   
   
}
