package com.lwt.wx.service;

import java.io.InputStream;
import java.util.List;

import com.lwt.wx.entity.Attachment;
import com.lwt.wx.entity.Topic;

public interface IAttachmentService {
    public void add(Attachment att, InputStream in ,String path);

	public List<Attachment> findByProductId(Long id);

	public void deleteByName(String newName,String path,Integer isImage);

	public void addTopicAttachs(Topic topic, Long[] attid);

	public void updateIndexPic(Long[] indexPicId);

	public void updateIsAttach(Long[] attachId);

}
