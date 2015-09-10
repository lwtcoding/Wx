package com.lwt.wx.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.entity.Channel;
import com.lwt.wx.entity.ChannelTree;
import com.lwt.wx.service.IChannelService;
import com.lwt.wx.util.ModelAttribute;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.Exception.WxException;
import com.lwt.wx.util.enums.ChannelType;
import com.lwt.wx.util.enums.util.EnumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class ChannelAction extends ActionSupport implements ModelDriven<Channel>{
	@Resource
	private IChannelService channelService;
	private Channel channel;
	private Long[] ids;
	
	public String list(){
		Pager<Channel> channelPager=channelService.list();
		ModelAttribute.addAttribute("channels", channelPager.getObjectsList());
		return SUCCESS;	
	}
	public String listByParent(){
		String pidString=ServletActionContext.getRequest().getParameter("pid");
		if(pidString==null)
			throw new WxException("pid参数错误");
		Long pid= Long.parseLong(pidString);
		List<Channel> channels=channelService.listByParent(pid);
		ModelAttribute.addAttribute("pc", channelService.findById(pid));
		ModelAttribute.addAttribute("channels", channels);
		return SUCCESS;	
	}
	
    public String addInput(){
    	String pidString=ServletActionContext.getRequest().getParameter("pid");
    	if(pidString==null||pidString.trim().equals(""))
    		pidString="0";
    	Channel pc=null;
    
    	Long pid=Long.parseLong(pidString);
  	
    	if(pid==null||pid==0){
    		pc=new Channel();
    		pc.setId(Channel.ROOT_ID);
    		pc.setName(Channel.ROOT_NAME);
    	}else{
    		pc=channelService.findById(pid);
    	}
    
    	ModelAttribute.addAttribute("pc", pc);
    	ModelAttribute.addAttribute("types", EnumUtils.EnumProp2NameMap(ChannelType.class, "name"));
    	
		return INPUT;		
	}
	public String add(){
		String pidString=ServletActionContext.getRequest().getParameter("pid");	
    	Long pid=Long.parseLong(pidString);
    	
    	channelService.add(channel,pid);
		ModelAttribute.addAttribute("url", "channel_asd");
		return "redirect";	
	}
	public void generateTree() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<ChannelTree> cts=channelService.generateTree();
		JSONArray object=JSONArray.fromObject(cts);
		System.out.println(object);
		out.print(object.toString());
		out.close();
	}
	
	public String updateInput(){
		channel=channelService.findById(channel.getId());
		Channel pc=channel.getParent();		
    	if(pc==null){
    		pc=new Channel();
    		pc.setId(Channel.ROOT_ID);
    		pc.setName(Channel.ROOT_NAME);
    	}

    	ModelAttribute.addAttribute("pc", pc);
		ModelAttribute.addAttribute("types", EnumUtils.EnumProp2NameMap(ChannelType.class, "name"));
		return SUCCESS;
		
	}
	public String update(){
		String pidString=ServletActionContext.getRequest().getParameter("pid");
		Long pid=Long.parseLong(pidString);
		Channel pc=null;
		if(pid!=0)
			pc=channelService.findById(pid);
		channel.setParent(pc);
		channelService.update(channel);
		return SUCCESS;
		
	}
	public String delete(){
		channelService.delete(channel.getId());
		return null;
	}
	public void saveOrders() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		JSONObject object=new JSONObject();
		if(ids==null||ids.length==0)
			throw new WxException("参数错误");
		int order=1;
		for(Long id:ids){
			channelService.updateOrders(id,order++);
		}
		object.put("result", "success");
		out.print(object);
		out.close();
	}
	public Channel getModel() {
		if(channel==null){channel=new Channel();}
		return channel;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}

}
