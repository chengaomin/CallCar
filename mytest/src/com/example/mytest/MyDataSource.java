package com.example.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataSource {

	public static List<Map<String,Object>> getDataSource(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "������");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.mm_title_btn_contact_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "һ������");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.flipper_head_publish);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "��ʷ����");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.icetweton);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "����&�ȼ�");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.icotjsjn);
		list.add(map);
		

		
		map = new HashMap<String, Object>();
		map.put("title", "�ɽ�����");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.targetrange_icon);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "������");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.logmeinignition);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "���пͷ�");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.phicon);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "����������");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.todo);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "����");
		map.put("info", R.drawable.mm_submenu_normal);
		map.put("img", R.drawable.icc45on);
		list.add(map);

		return list;
		
	}
}
