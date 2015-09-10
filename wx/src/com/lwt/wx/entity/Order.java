package com.lwt.wx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lwt.wx.util.enums.OrderStatus;
import com.lwt.wx.util.enums.PayStatus;
import com.lwt.wx.util.enums.ShipStaus;

@Entity
public class Order {
	private Long id;
	private Customer  coustomer;
	private String orderNo;
	private Date beginTime;
	private Date endTime;
	private PayStatus payStatus;
	private ShipStaus shipStatus;
	private OrderStatus orderstatus;
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
	public Customer getCoustomer() {
		return coustomer;
	}
	public void setCoustomer(Customer coustomer) {
		this.coustomer = coustomer;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Temporal(TemporalType.TIME)
	public Date getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	@Temporal(TemporalType.TIME)
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Enumerated(EnumType.STRING)
	public PayStatus getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(PayStatus payStatus) {
		this.payStatus = payStatus;
	}
	@Enumerated(EnumType.STRING)
	public ShipStaus getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(ShipStaus shipStatus) {
		this.shipStatus = shipStatus;
	}
	@Enumerated(EnumType.STRING)
	public OrderStatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	public Double getCharge() {
		return charge;
	}
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	
	
	

}
