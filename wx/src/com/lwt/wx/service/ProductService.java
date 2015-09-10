package com.lwt.wx.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IAttachmentDao;
import com.lwt.wx.dao.IProCategoryDao;
import com.lwt.wx.dao.IProPatternDao;
import com.lwt.wx.dao.IProductDao;
import com.lwt.wx.dto.ProductDTO;
import com.lwt.wx.entity.Attachment;
import com.lwt.wx.entity.ProCategory;
import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.entity.Product;
import com.lwt.wx.util.Pager;

@Service
public class ProductService implements IProductService{
@Resource
private IProductDao productDao;
@Resource
private IProPatternDao proPatternDao;
@Resource
private IProCategoryDao proCategoryDao;
@Resource
private IAttachmentDao attachmentDao;
	public void save(ProductDTO productDTO) {
	    Product product=productDTO.DTO2Product();
	    if(productDTO.getCategoryId()!=null)
	    	product.setCategory(proCategoryDao.get(ProCategory.class, productDTO.getCategoryId()));
	    productDao.saveOrUpdate(product);
	    
	    //将数据库中产品样式设置产品外键
	    //别名查询
	    if(productDTO.getPatternNo()!=null){
	//更新前把修改的样式删除掉
	  List<String> proPatternsNos=Arrays.asList(productDTO.getPatternNo());
	  if(product.getId()!=null&&product.getId()!=0){
	  List<String> proPatternsNoList=proPatternDao.findProPatternsNos(product.getId());
	  if( proPatternsNoList!=null&& proPatternsNoList.size()>0){
		  for(String patternNo: proPatternsNoList){
			  if(!proPatternsNos.contains(patternNo))
				  proPatternDao.deleteByNo(patternNo);
		  }
	  }
	  }
	  //save
	  Map<String ,Object> alias =new HashMap<String, Object>();
	  alias.put("patternNo", Arrays.asList(productDTO.getPatternNo()));
	    List<ProPattern> proPatterns=proPatternDao.findPatternsByNos(alias);    
	    for(ProPattern pattern:proPatterns){
	    	pattern.setProduct(product);
	    	proPatternDao.saveOrUpdate(pattern);
	    }
	    }
	    //?查询
	    if(productDTO.getAttName()!=null){
	    	//更新前把修改的图片删除掉
	  	  List<String> proAttachmentNames=Arrays.asList(productDTO.getAttName());
	  	  if(product.getId()!=null&&product.getId()!=0){
	  	  List<String> proAttachmentNamesList=attachmentDao.findProAttachmentNames(product.getId());
	  	  if(proAttachmentNamesList!=null&& proAttachmentNamesList.size()>0){
	  		  for(String attName: proAttachmentNamesList){
	  			  if(! proAttachmentNames.contains(attName))
	  				  proPatternDao.deleteByNo(attName);
	  		  }
	  	  }
	  	  }
	    	 Map<String ,Object> alias =new HashMap<String, Object>();
	   	  alias.put("newName", Arrays.asList(productDTO.getAttName()));
	    List<Attachment> attachments=attachmentDao.findAttsByNewNames(alias);
	    for(Attachment att:attachments){
	    	att.setProduct(product);
	    	attachmentDao.saveOrUpdate(att);
	    }
	    }
	}
	public Pager<Product> fingByPager() {
		
		return productDao.list("from Product");
	}
	public ProductDTO findById(Long id) {
		
		Product product=productDao.get(Product.class, id);
		List<String> attNames=attachmentDao.findProAttachmentNames(id);
		ProductDTO dto=new ProductDTO(product,attNames);
        
		return dto;
	}
	public void delete(Long id) {
		attachmentDao.deleteByProId(id);
		proPatternDao.deleteByProId(id);
		productDao.deleteById(id);
		
	}
	public Pager findByPager() {
		Pager productPager=productDao.list("from Product");
		List<Product> products=productPager.getObjectsList();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		for(Product product:products){
			List<String> attNewNames=attachmentDao.findProAttachmentNames(product.getId());
			ProductDTO dto=new ProductDTO(product, attNewNames);
			productDTOs.add(dto);
		}
		productPager.setObjectsList(productDTOs);
		return productPager;
	}
	
}
