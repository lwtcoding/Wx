package com.lwt.wx.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IAttachmentDao;
import com.lwt.wx.dao.IProPatternDao;
import com.lwt.wx.dao.IProductDao;
import com.lwt.wx.dao.IScartDao;
import com.lwt.wx.dao.IScartItemDao;
import com.lwt.wx.dto.ScartItemDTO;
import com.lwt.wx.entity.Attachment;
import com.lwt.wx.entity.ProPattern;
import com.lwt.wx.entity.Product;
import com.lwt.wx.entity.Scart;
import com.lwt.wx.entity.ScartItem;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

@Service
public class ScartItemService implements IScartItemService {
	@Resource
	private IScartItemDao scartItemDao;
	@Resource 
	private IProPatternDao patternDao;
	@Resource
	private IProductDao productDao;
	@Resource
	private IScartDao scartDao;
	@Resource
	private IAttachmentDao attachmentDao;

	public void add(Scart scart, ScartItemDTO scartItemDTO) {
		ProPattern pattern=patternDao.get(ProPattern.class, scartItemDTO.getPatternId());
		Product product=productDao.get(Product.class, scartItemDTO.getProductId());
		
		
	List<Long> scartPatternIds=scartItemDao.findScartProPattern(scart.getId());
		if(scartPatternIds.contains(scartItemDTO.getPatternId())){	
			ScartItem scartItem=scartItemDao.findPatternIterm(scartItemDTO.getPatternId(),scart.getId());
			scartItem.setQuantity(scartItem.getQuantity()+scartItemDTO.getQuantity());
			scartItem.setCharge((pattern.getUnitPrice())*scartItem.getQuantity());
			
			scartItemDao.saveOrUpdate(scartItem);
		}else{
		ScartItem scartItem=new ScartItem();
		scartItem.setScart(scart);
		scartItem.setPattern(pattern);
		scartItem.setProduct(product);
		scartItem.setQuantity(scartItemDTO.getQuantity());
		System.out.println(pattern.getUnitPrice()+":"+scartItemDTO.getQuantity());
		scartItem.setCharge(pattern.getUnitPrice()*scartItemDTO.getQuantity());
	
		scartItemDao.save(scartItem);
		}
		if(scart.getItemNum()==null)
			scart.setItemNum(0);
		scart.setItemNum(scart.getItemNum()+scartItemDTO.getQuantity());
		
		scartDao.merge(scart);
	}

	public List<ScartItem> findScartItems(Long scartId) {
		
		return scartItemDao.findScartItems(scartId);
	}

	public Scart findScart(Long id) {
		
		return scartDao.get(Scart.class, id);
	}

	public List<ScartItemDTO> findScartItemDTOs(Long id) {
		List<ScartItem> items=scartItemDao.findScartItems(id);
		List<ScartItemDTO> itemDTOs=new ArrayList<ScartItemDTO>();
		for(ScartItem item:items){
			
		List<String> attNames=attachmentDao.findProAttachmentNames(item.getProduct().getId());
		ScartItemDTO itemDTO=new ScartItemDTO(item,attNames);
		itemDTOs.add(itemDTO);
		}
		return itemDTOs;
	}
	

}
