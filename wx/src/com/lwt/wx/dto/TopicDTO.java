package com.lwt.wx.dto;

import java.util.Date;

import com.lwt.wx.entity.Topic;


public class TopicDTO {

	private Long id;

	private String title;
	
	private String keyword;

	private Integer status;
	
	private Integer recommend;
	
	private String content;

	private String summary;

	private Date publishDate;
    
	private Date createDate;
    
	private String author;

	private String cname;
	
	private Long  cid;

	private Long uid;
    
	private Long[] attid;
	
	private String attName;
	
	private Integer[] isImage;
	//接收前台是主页图片附件
	private Long[] indexPicId;
	
	private Long channelPicId;
	//接收前台是文章附件的附件
	private Long[] attachId;
	
	public Topic dto2entity(){
		Topic topic=new Topic();
		topic.setAuthor(this.getAuthor());
		topic.setChannelPicId(this.channelPicId);
		topic.setCname(this.cname);
		topic.setContent(this.content);
		topic.setKeyword(this.keyword);
		topic.setCreateDate(this.createDate);
		topic.setAuthor(this.author);
		topic.setPublishDate(this.publishDate);
		topic.setRecommend(this.recommend);
		topic.setStatus(this.status);
		topic.setSummary(this.summary);
		topic.setTitle(this.title);

		return topic;
	}
	
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


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}



	public String getAttName() {
		return attName;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	public Integer[] getIsImage() {
		return isImage;
	}

	public void setIsImage(Integer[] isImage) {
		this.isImage = isImage;
	}





	public Long getChannelPicId() {
		return channelPicId;
	}

	public void setChannelPicId(Long channelPicId) {
		this.channelPicId = channelPicId;
	}



	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long[] getAttid() {
		return attid;
	}

	public void setAttid(Long[] attid) {
		this.attid = attid;
	}

	public Long[] getAttachId() {
		return attachId;
	}

	public void setAttachId(Long[] attachId) {
		this.attachId = attachId;
	}

	public Long[] getIndexPicId() {
		return indexPicId;
	}

	public void setIndexPicId(Long[] indexPicId) {
		this.indexPicId = indexPicId;
	}
	
	
}
