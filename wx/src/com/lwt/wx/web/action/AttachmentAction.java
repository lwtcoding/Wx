package com.lwt.wx.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.Attachment;
import com.lwt.wx.service.IAttachmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class AttachmentAction extends ActionSupport implements ModelDriven<Attachment>{
	@Resource
	private IAttachmentService attachmentService;
	private Attachment attachment;
	
	public void deleteByName() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		JSONObject json=new JSONObject();
		json.put("result", "false");
	String newName=attachment.getNewName();
	
	if(newName!=null){
		String path=ServletActionContext.getServletContext().getRealPath("/")+"upload\\";
		attachmentService.deleteByName(newName,path,1);
		json.put("result", "success");
	}
	out.print(json);
	out.close();			
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Attachment getModel() {
		if(attachment==null)
			attachment=new Attachment();
		return attachment;
	}

}
