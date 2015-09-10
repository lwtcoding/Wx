package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.dto.ProductDTO;
import com.lwt.wx.entity.Product;
import com.lwt.wx.util.Pager;

public interface IProductService {

	void save(ProductDTO productDTO);

	Pager<Product> fingByPager();

	ProductDTO findById(Long id);

	void delete(Long id);

	Pager<ProductDTO> findByPager();

	

}
