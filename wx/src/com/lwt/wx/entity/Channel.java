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
	public static final String ROOT_NAME="��վϵͳ��Ŀ"; 
	public static final Long ROOT_ID=0l;
	/**
	 * ���� 
	 */
	private Long id;
    /**
     * ��Ŀ����
     */
	private String name;
	/**
	 * �Ƿ��Զ������ӣ�0��ʾ��1��ʾ��
	 */
	private int customLink;
	/**
	 * �Զ������ӵĵ�ַ
	 * 
	 */
	private String customLinkURL;
	/**
	 * ��Ŀ���ͣ�ö����
	 */
	private ChannelType channelType;
	/**
	 * �Ƿ���ҳ��Ŀ��0��ʾ��1��ʾ��
	 */
	private int isIndex;
	/**
	 * �Ƿ���ҳ�Ķ���������Ŀ��0��ʾ��1��ʾ��
	 */
	private int isTopNav;
	/**
	 * �Ƿ��Ƽ���Ŀ��0��ʾ��1��ʾ��
	 */
	private int recommend;
	/**
	 * ��Ŀ��״̬��0��ʾͣ�ã�1��ʾ����
	 */
	private int status;
	/**
	 * ��Ŀ�����
	 */
	private int orders;
	/**
	 * ������Ŀ
	 */
	private Channel parent;
	/**
	 * ���������
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
