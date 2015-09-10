package com.lwt.wx.service;

import java.util.List;

import com.lwt.wx.dto.ScartItemDTO;
import com.lwt.wx.entity.Scart;
import com.lwt.wx.entity.ScartItem;

public interface IScartItemService {

	void add(Scart scart, ScartItemDTO scartItemDTO);

	List<ScartItem> findScartItems(Long id);

	Scart findScart(Long id);

	List<ScartItemDTO> findScartItemDTOs(Long id);

}
