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
	 * ����
	 */
	private Long id;
	/**
	 * ���±���
	 */
	private String title;
	/**
	 * ���¹ؼ��֣���|�ָ�
	 */
	private String keyword;
	/**
	 * ���·���״̬��0����δ������1������
	 */
	private int status;
	/**
	 * �Ƿ��Ƽ���0���Ƽ���1�Ƽ�
	 */
	private int recommend;
	/**
	 * ��������
	 */
	private String content;
	/**
	 * ����ժҪ
	 */
	private String summary;
	/**
	 * ���µĴ���ʱ��
	 */
	private Date createDate;
	/**
	 * ���µķ���ʱ��
	 */
	private Date publishDate;
	/**
	 * ��ĿͼƬ��id�����������Ŀ��ͼƬ������Ŀ������ʾ���ͼƬ
	 */
	private Long channelPicId;
	/**
	 * �����ֶΣ���������
	 */
	private String author;
	/**
	 * �����ֶΣ���Ŀ����
	 */
	private String cname;
	/**
	 * ����������Ŀ�����һ
	 */
	private Channel channel;
	/**
	 * ���·����ߣ����һ
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
