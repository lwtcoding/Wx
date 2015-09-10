package com.lwt.wx.util;

import com.opensymphony.xwork2.ActionContext;

public class ModelAttribute {
	public static void addAttribute(String key,Object value){
		ActionContext.getContext().put(key, value);
	}

}
