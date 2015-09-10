package com.lwt.wx.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.service.IProPatternService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ProPatternAction extends ActionSupport{
	@Resource
	private IProPatternService patternService;
	private ProPattern pattern;
	
	public String addInput(){
		return SUCCESS;
	}
	
	
	public void addProPattern() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		if(pattern!=null){
		PrintWriter out=response.getWriter();      
		pattern.setProduct(null);
		pattern.setPatternNo(UUID.randomUUID().toString().replaceAll("-", ""));
		
		patternService.save(pattern);
		JSONObject obj=JSONObject.fromObject(pattern);
		out.print(obj);
		out.close();
		}
	}
	
	public void deleteByNo() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter(); 
		JSONObject obj=new JSONObject();
		String patternNo=ServletActionContext.getRequest().getParameter("patternNo");
		if (patternNo!=null&&!"".equals(patternNo)){ 
		patternService.deleteByNo(patternNo);
		obj.put("result", "1");
		}else {
			obj.put("result", "0");
		}
		out.print(obj);
		out.close();
		
	}
	public ProPattern getPattern() {
		return pattern;
	}
	public void setPattern(ProPattern pattern) {
		this.pattern = pattern;
	}

}
