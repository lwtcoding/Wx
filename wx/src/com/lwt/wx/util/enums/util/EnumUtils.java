package com.lwt.wx.util.enums.util;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.lwt.wx.util.enums.Sex;


public class EnumUtils {
	public static List<Integer> Enum2Ordinal(Class<? extends Enum> clazz){
		if(!clazz.isEnum())
			return null;
		Enum[] enums=clazz.getEnumConstants();
		List<Integer> rels=new ArrayList<Integer>();
		for(Enum en:enums){
			rels.add(en.ordinal());
		}
		return rels;
		
	}
	public static List<String> Enum2Name(Class<? extends Enum> clazz){
		if(!clazz.isEnum())
			return null;
		Enum[] enums=clazz.getEnumConstants();
		List<String> rels=new ArrayList<String>();
		for(Enum en:enums){
			rels.add(en.name());
		}
		return rels;
		
	}
	public static Map<Integer,String> Enum2BaiscMap(Class<? extends Enum> clazz){
		if(!clazz.isEnum())
			return null;
		Enum[] enums=clazz.getEnumConstants();
		Map<Integer,String> rels=new HashMap<Integer,String>();
		for(Enum en:enums){
			rels.put(en.ordinal(), en.name());
		}
		return rels;
		
	}
	/**
	 * 将属性转换为map
	 * */
	public static Map<String,String> EnumProp2NameMap(Class<? extends Enum> clazz,String propName){
		if(!clazz.isEnum())
			return null;
		Enum[] enums=clazz.getEnumConstants();
		Map<String,String> rels=new HashMap<String,String>();
		try {
		for(Enum en:enums){
			
				rels.put(en.name(), (String) PropertyUtils.getProperty(en, propName));
				
			}
		return rels;
			} catch (IllegalAccessException e) {
			
				e.printStackTrace();
			} catch (InvocationTargetException e) {
			
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				
				e.printStackTrace();
			}
			return null;
		
	}
	public static void main(String[] args) {
		Map map=EnumUtils.Enum2BaiscMap(Sex.class);
		Map map1=EnumUtils.EnumProp2NameMap(Sex.class, "name");
		System.out.println(map1.toString());
	}

}
