package com.lwt.wx.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lwt.wx.dao.ScartDao;
import com.lwt.wx.dto.ScartItemDTO;
import com.lwt.wx.entity.Scart;
import com.lwt.wx.entity.ScartItem;
import com.lwt.wx.service.IScartItemService;
import com.lwt.wx.util.ModelAttribute;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class ScartItemAction extends ActionSupport implements ModelDriven<ScartItemDTO>{
	@Resource
	private IScartItemService scartItemService;
	private ScartItemDTO scartItemDTO;
	
	
	public String showScart(){
		Scart scart=(Scart) ServletActionContext.getContext().getSession().get("myScart");
		List<ScartItemDTO> scartItemDTOs=scartItemService.findScartItemDTOs(scart.getId());
		ModelAttribute.addAttribute("scartItemDTOs", scartItemDTOs);
		return SUCCESS;
		
	}
	public void addItem() throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		JSONObject json=null;
		Scart scart=(Scart) ServletActionContext.getContext().getSession().get("myScart");
		//Scart scart=scartItemService.findScart(cart.getId());
		
				
		scartItemService.add(scart,scartItemDTO);
		List<ScartItem> scartItems=scartItemService.findScartItems(scart.getId());
		
		ServletActionContext.getContext().getSession().put("myScart", scart);
		//
		System.out.println(scart.getItemNum());
		out.print("asd");
		out.close();
		
	}

	public ScartItemDTO getModel() {
		if(scartItemDTO==null) scartItemDTO=new ScartItemDTO();
		return null;
	}

	public ScartItemDTO getScartItemDTO() {
		return scartItemDTO;
	}

	public void setScartItemDTO(ScartItemDTO scartItemDTO) {
		this.scartItemDTO = scartItemDTO;
	}

}
