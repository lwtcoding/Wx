package com.lwt.wx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Topic {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 文章关键字，用|分割
	 */
	private String keyword;
	/**
	 * 文章发布状态，0代表未发布，1代表发布
	 */
	private int status;
	/**
	 * 是否推荐，0不推荐，1推荐
	 */
	private int recommend;
	/**
	 * 文章内容
	 */
	private String content;
	/**
	 * 文章摘要
	 */
	private String summary;
	/**
	 * 文章的创建时间
	 */
	private Date createDate;
	/**
	 * 文章的发布时间
	 */
	private Date publishDate;
	/**
	 * 栏目图片的id，如果所在栏目是图片类型栏目，会显示这个图片
	 */
	private Long channelPicId;
	/**
	 * 冗余字段，作者名字
	 */
	private String author;
	/**
	 * 冗余字段，栏目名称
	 */
	private String cname;
	/**
	 * 文章所在栏目，多对一
	 */
	private Channel channel;
	/**
	 * 文章发布者，多对一
	 */
	private User user;
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@ManyToOne
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Long getChannelPicId() {
		return channelPicId;
	}
	public void setChannelPicId(Long channelPicId) {
		this.channelPicId = channelPicId;
	}
	
	

}
