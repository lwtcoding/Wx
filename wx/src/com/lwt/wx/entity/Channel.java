package com.lwt.wx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lwt.wx.util.enums.ChannelType;

@Entity
public class Channel {
	public static final String ROOT_NAME="网站系统栏目"; 
	public static final Long ROOT_ID=0l;
	/**
	 * 主键 
	 */
	private Long id;
    /**
     * 栏目名称
     */
	private String name;
	/**
	 * 是否自定义链接，0表示否，1表示是
	 */
	private int customLink;
	/**
	 * 自定义链接的地址
	 * 
	 */
	private String customLinkURL;
	/**
	 * 栏目类型，枚举类
	 */
	private ChannelType channelType;
	/**
	 * 是否主页栏目，0表示否，1表示是
	 */
	private int isIndex;
	/**
	 * 是否首页的顶部导航栏目，0表示否，1表示是
	 */
	private int isTopNav;
	/**
	 * 是否推荐栏目，0表示否，1表示是
	 */
	private int recommend;
	/**
	 * 栏目的状态，0表示停用，1表示启用
	 */
	private int status;
	/**
	 * 栏目的序号
	 */
	private int orders;
	/**
	 * 父类栏目
	 */
	private Channel parent;
	/**
	 * 导航的序号
	 */
	private int navOrder;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustomLink() {
		return customLink;
	}
	public void setCustomLink(int customLink) {
		this.customLink = customLink;
	}
	public String getCustomLinkURL() {
		return customLinkURL;
	}
	public void setCustomLinkURL(String customLinkURL) {
		this.customLinkURL = customLinkURL;
	}
	@Enumerated(EnumType.STRING)
	public ChannelType getChannelType() {
		return channelType;
	}
	public void setChannelType(ChannelType channelType) {
		this.channelType = channelType;
	}
	public int getIsIndex() {
		return isIndex;
	}
	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}
	public int getIsTopNav() {
		return isTopNav;
	}
	public void setIsTopNav(int isTopNav) {
		this.isTopNav = isTopNav;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	@ManyToOne
	@JoinColumn(name="pid")
	public Channel getParent() {
		return parent;
	}
	public void setParent(Channel parent) {
		this.parent = parent;
	}
	public int getNavOrder() {
		return navOrder;
	}
	public void setNavOrder(int navOrder) {
		this.navOrder = navOrder;
	}
	

}
