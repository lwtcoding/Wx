package com.lwt.wx.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.dto.TopicDTO;
import com.lwt.wx.entity.Attachment;
import com.lwt.wx.entity.Topic;
import com.lwt.wx.entity.User;
import com.lwt.wx.service.IAttachmentService;
import com.lwt.wx.service.IKeywordService;
import com.lwt.wx.service.ITopicService;
import com.lwt.wx.util.ModelAttribute;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.Exception.WxException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class TopicAction extends ActionSupport implements ModelDriven<TopicDTO>{
	@Resource
	private ITopicService topicService;
	@Resource
	private IAttachmentService attachmentService;
	
	private TopicDTO topicDTO;
	private File[] att;
	private String[] attFileName;
	private String[] attContentType;
	
	public String list(){
		System.out.println(topicDTO.getStatus());
		Pager<Topic> topics=topicService.find(topicDTO.getCid(), topicDTO.getTitle(), topicDTO.getStatus());
		ModelAttribute.addAttribute("topics", topics.getObjectsList());
		return SUCCESS;
		
	}
	
	
	
	public String addInput(){
		return INPUT;
	}
	public String add(){
		User user=(User) ActionContext.getContext().getSession().get("loginUser");
	  System.out.println("add1..");
		//if(user==null) throw new WxException("ÏÈµÇÂ¼");
		Topic topic=topicDTO.dto2entity();
		topicService.add(topic,topicDTO.getCid(),null,topicDTO.getAttid(),topicDTO.getKeyword());
		attachmentService.updateIndexPic(topicDTO.getIndexPicId());
		attachmentService.updateIsAttach(topicDTO.getAttachId());
		ModelAttribute.addAttribute("url", "topic_addInput");
		return "redirect";
	}
	
	public void upload() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Attachment a=new Attachment();
		a.setCreateTime(new Date());
		a.setContentType(FilenameUtils.getExtension(attFileName[0]));
		a.setIsAttach(0);
		a.setIsImage(0);
		if(".jpg.gif.png.jpg.jpeg".contains(a.getContentType()))
		a.setIsImage(1);
		a.setIsIndexPic(0);
		a.setSize(att[0].getTotalSpace());
		a.setNewName((new Date().getTime())+"."+FilenameUtils.getExtension(attFileName[0]));
		a.setOldName(attFileName[0]);
		a.setTopic(null);
		attachmentService.add(a, new FileInputStream(att[0]), ServletActionContext.getServletContext().getRealPath("/")+"upload\\topic\\");
		out.print(JSONObject.fromObject(a));
		out.close();
	}
	
	public void delAtt() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String path=ServletActionContext.getServletContext().getRealPath("/")+"upload\\topic\\";
		JSONObject object=new JSONObject();
		if(topicDTO.getAttName()!=null)
			attachmentService.deleteByName(topicDTO.getAttName(),path,topicDTO.getIsImage()[0] );
		out.print(object.put("result", "success"));
		out.close();
		
	}

	public TopicDTO getModel() {
	if(topicDTO==null) topicDTO=new TopicDTO();
		return topicDTO;
	}

	public TopicDTO getTopicDTO() {
		return topicDTO;
	}

	public void setTopicDTO(TopicDTO topicDTO) {
		this.topicDTO = topicDTO;
	}
	public ITopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}
	public IAttachmentService getAttachmentService() {
		return attachmentService;
	}
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	public File[] getAtt() {
		return att;
	}
	public void setAtt(File[] att) {
		this.att = att;
	}
	public String[] getAttFileName() {
		return attFileName;
	}
	public void setAttFileName(String[] attFileName) {
		this.attFileName = attFileName;
	}
	public String[] getAttContentType() {
		return attContentType;
	}
	public void setAttContentType(String[] attContentType) {
		this.attContentType = attContentType;
	}

	
	
}
