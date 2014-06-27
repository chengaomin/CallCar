package com.example.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataSource {

	public static List<Map<String,Object>> getDataSource(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "丁先生");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.mm_title_btn_contact_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "一键发布");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.flipper_head_publish);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "历史发布");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.icetweton);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "积分&等级");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.icotjsjn);
		list.add(map);
		

		
		map = new HashMap<String, Object>();
		map.put("title", "成交攻略");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.targetrange_icon);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "激活码");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.logmeinignition);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "呼叫客服");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.phicon);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "给我们评分");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.todo);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "关于");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.icc45on);
		list.add(map);

		return list;
		
	}
}
