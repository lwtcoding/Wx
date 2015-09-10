package com.lwt.wx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attachment {
	private Long id;
	private String oldName;
	private String newName;
	private Date createTime;
	private String contentType;
	private Long size;
	private Integer isImage;
	private Product product;
	private Topic topic;
	/**
	 * 该附件是否主页图片
	 */
	private Integer isIndexPic;
	/**
	 * 该附件是否附件信息，如果是则在文章的附件栏显示
	 */
	private Integer isAttach;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	@Temporal(TemporalType.TIME)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	@ManyToOne
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getIsImage() {
		return isImage;
	}
	public void setIsImage(Integer isImage) {
		this.isImage = isImage;
	}
	public Integer getIsIndexPic() {
		return isIndexPic;
	}
	public void setIsIndexPic(Integer isIndexPic) {
		this.isIndexPic = isIndexPic;
	}
	public Integer getIsAttach() {
		return isAttach;
	}
	public void setIsAttach(Integer isAttach) {
		this.isAttach = isAttach;
	}
	@ManyToOne
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}

	
	

}
