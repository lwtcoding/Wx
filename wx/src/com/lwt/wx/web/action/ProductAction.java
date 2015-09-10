package com.lwt.wx.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;


import com.lwt.wx.dto.ProductDTO;
import com.lwt.wx.entity.Attachment;
import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.entity.Product;
import com.lwt.wx.service.IAttachmentService;
import com.lwt.wx.service.IProCategoryService;
import com.lwt.wx.service.IProPatternService;
import com.lwt.wx.service.IProductService;
import com.lwt.wx.util.Pager;
import com.lwt.wx.util.enums.ProStatus;
import com.lwt.wx.util.enums.util.EnumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ProductAction extends ActionSupport implements ModelDriven<ProductDTO>{
	@Resource
	private IProductService productService;
	@Resource
	private IAttachmentService attachmentService;
	@Resource
	private IProCategoryService proCategoryService;
	@Resource
	private IProPatternService patternService;
	private File att;
	private String attFileName;
	private String attContentType;
	private ProductDTO productDTO;
	private List<ProductDTO> productDTOs;
  public String  list(){
	  Pager<Product> productPager=productService.fingByPager();
	 ModelAttribute("products", productPager.getObjectsList());
	// ModelAttribute("statusMap", EnumUtils.EnumProp2NameMap(ProStatus.class, "name"));
	  return SUCCESS;
  }
  public String listCategory(){
	return SUCCESS;
	  
  }
  public String show(){
	  System.out.println(productDTO);
	  productDTO=productService.findById(productDTO.getId());
	  List<Attachment> atts=attachmentService.findByProductId(productDTO.getId());
	  List<ProPattern> patterns=patternService.findByProductId(productDTO.getId());
	  ModelAttribute("atts", atts);
	  ModelAttribute("patterns", patterns);
	  ModelAttribute("proStatus", EnumUtils.EnumProp2NameMap(ProStatus.class, "name"));
	  ModelAttribute("categorys", proCategoryService.findAll());
	  return SUCCESS;
  }
  public String delete(){
	  if(productDTO.getId()!=null){
		  productService.delete(productDTO.getId());
	  }
	  ModelAttribute("url", "product_list");
	  return "redirect";
  }
  public String addInput(){
	  ModelAttribute("statusMap",EnumUtils.EnumProp2NameMap(ProStatus.class, "name"));
	  ModelAttribute("categorys", proCategoryService.findAll());
	  return SUCCESS;
  }
  public String add(){
	  if(productDTO!=null)
	 productService.save(productDTO);	
	  ModelAttribute("url","product_list");
	  return "redirect";

  }
  
  public void upload() throws IOException {
	  HttpServletResponse resp=ServletActionContext.getResponse();
	  resp.setCharacterEncoding("utf-8");
	  PrintWriter out=resp.getWriter();
	  JSONObject obj=new JSONObject();
	  System.out.println(att+"||"+att);
	  if(att!=null){
		  Attachment attachment=new Attachment();
		  attachment.setIsImage(1);
		  attachment.setCreateTime(new Date());
		  attachment.setContentType(FilenameUtils.getExtension(attFileName));
		  attachment.setNewName((new Date().getTime()+"."+FilenameUtils.getExtension(attFileName)));
		  attachment.setOldName(attFileName);
		  attachment.setProduct(null);
		  try{
			  String path=ServletActionContext.getServletContext().getRealPath("/")+"upload\\";
		  attachmentService.add(attachment, new FileInputStream(att),path);
		  //hibernate保存对象后能获取对象的主键值
			 // System.out.println("-----id:---"+attachment.getId());
		  obj.put("result", attachment);
		  out.print(obj);
		  out.close();
		  }catch (Exception e) {
			e.printStackTrace();
		}
	  }else{
		  obj.put("result", "false");
		  out.print(obj);
		  out.close();
	  }
	  
  }
  public String shopping(){
	
	  Pager<ProductDTO> productDTOPager=productService.findByPager();
	  productDTOs=productDTOPager.getObjectsList();
	  
	  return SUCCESS;
  }
  public String showShop(){
		
	  productDTO=productService.findById(productDTO.getId());
	//  System.out.println(productDTO.getAttName()[0]);
	  List<Attachment> atts=attachmentService.findByProductId(productDTO.getId());
	  List<ProPattern> patterns=patternService.findByProductId(productDTO.getId());
	  ModelAttribute("atts", atts);
	  ModelAttribute("patterns", patterns);
	  return SUCCESS;
  }
private void ModelAttribute(String o1, Object o2) {
	ActionContext.getContext().put(o1, o2);
	
}

public File getAtt() {
	return att;
}

public void setAtt(File att) {
	this.att = att;
}

public String getAttFileName() {
	return attFileName;
}

public void setAttFileName(String attFileName) {
	this.attFileName = attFileName;
}

public String getAttContentType() {
	return attContentType;
}

public void setAttContentType(String attContentType) {
	this.attContentType = attContentType;
}
public ProductDTO getModel() {
if (productDTO==null)  productDTO=new ProductDTO();
	return productDTO;
}
public ProductDTO getProductDTO() {
	return productDTO;
}
public void setProductDTO(ProductDTO productDTO) {
	this.productDTO = productDTO;
}
public List<ProductDTO> getProductDTOs() {
	return productDTOs;
}
public void setProductDTOs(List<ProductDTO> productDTOs) {
	this.productDTOs = productDTOs;
}

  
}
