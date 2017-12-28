/*
 * *****************************************************************************
 *  达飞金融，机密
 *  __________________
 * Copyright@2015-2016 DAFY CREDIT ALL Rights Reserved 达飞金融旗下品牌即有分期 版权所有
 * 备案号：粤ICP备17014188号
 *
 * 注意：
 * 	此处包含的所有信息均为深圳前海达飞金融服务有限公司的财产。知识和技术理念包含在内为深圳前
 * 	海达飞金融服务有限公司所有，可能受中国和国际专利，以及商业秘密或版权法保护。严格禁止传播
 * 	此信息或复制此材料，除非事先获得来自深圳前海达飞金融服务有限公司的书面许可。
 */

package com.dafycredit.giveu.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <br>TODO(描述该类的作用)</br>
 *
 * @author  102051
 * @email   email
 * @date    2017年7月28日 上午11:03:31
 * @version 1.0
 * @since   1.0
 */
public class maintest {
	public static Map<String,Object> localmap = Appium_Util.localmap;
	
	public static void main(String[] args) throws Exception{
		List<Map<String, Object>> st = new ArrayList<>();
		Map<String,Object> map = new HashMap();
		map.put("A", "1");
		map.put("B", "2");
		
		Map<String,Object> map1 = new HashMap();
		map1.put("C", "3");
		map1.put("D", "4");
		
		Map<String,Object> map2 = new HashMap();
		map2.put("E", "3");
		map2.put("F", "4");
		map2.put("G", map1);
		
		st.add(map);
		st.add(map2);
		
		List<String> p = new ArrayList<>();
		p.add("5");
		p.add("6");
		
		localmap.put("RR", p);
		localmap.put("SS", "ok");
		localmap.put("TT",st);
		
		System.out.println(Appium_Util.parseStringHasEls("rr[1]}"));
		System.out.println(Appium_Util.parseStringHasEls("${rr[1]}"));
		System.out.println(Appium_Util.parseStringHasEls("${ss}"));
		System.out.println(Appium_Util.parseEL("${tt[0]}"));
		System.out.println(Appium_Util.parseEL("${tt}"));
		System.out.println(Appium_Util.parseEL("${tt[0].a}"));
		System.out.println(Appium_Util.parseEL("${tt.g.c}"));
	}
}