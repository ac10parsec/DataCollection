package com.java.web.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.java.web.bean.QueryBean;

@Component
public class QueryInfo {
	
	public HashMap<String, QueryBean> QueryInfo(String url) {
		HashMap<String, QueryBean> resultMap = new HashMap<String, QueryBean>();
		if ("https://www.genie.co.kr/genre/M0200?genreCode=M0200&pg=".equals(url)) {
			resultMap = queryInfo1();
		} else if ("http://www.gdu.co.kr/process/process_010100.html".equals(url)) {
			resultMap = queryInfo2();
		}
		return resultMap;
	}
	
	public HashMap<String, QueryBean> queryInfo1() {
		HashMap<String, QueryBean> resultMap = new HashMap<String, QueryBean>();
		String select = "t1_select";
		String insert = "t1_insert";
		String delete = "t1_delete";
		String update = "t1_update";
		resultMap.put("queryTarget", new QueryBean(select, insert, delete, update));
		return resultMap; 
	}
	
	public HashMap<String, QueryBean> queryInfo2() {
		HashMap<String, QueryBean> resultMap = new HashMap<String, QueryBean>();
		String select = "t2_select";
		String insert = "t2_insert";
		String delete = "t2_delete";
		String update = "t2_update";
		resultMap.put("queryTarget", new QueryBean(select, insert, delete, update));
		return resultMap; 
	}
}
