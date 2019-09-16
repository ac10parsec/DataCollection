package com.java.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.bean.QueryBean;
import com.java.web.bean.UrlBean;
import com.java.web.dao.SpringDaoInterface;

@Service
public class SpringServer implements SpringServerInterface {

	@Autowired
	UrlInfo ui;
	
	@Autowired
	QueryInfo qi;
	
	@Autowired
	SpringDaoInterface di;
	
	@Override
	public HashMap<String, Object> getData(String url) {
		HashMap<String, QueryBean> queryInfo = qi.QueryInfo(url);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("queryType", "selectList");
		paramMap.put("queryTarget", queryInfo.get("queryTarget").getSelect());
		paramMap.put("params", null);
		return di.DB(paramMap);
	}
	
	@Override
	public HashMap<String, Object> setData(String url) {
		HashMap<String, QueryBean> queryInfo = qi.QueryInfo(url);
		
		int tot = 0;
		int del = 0;
		HashMap<String, Object> paramMap1 = null;
		HashMap<String, Object> paramMap2 = null;
		List<HashMap<String, Object>> dataList = getHTMLData(url);

		// truncate
		paramMap1 = new HashMap<String, Object>();
		paramMap1.put("queryType", "update");
		paramMap1.put("queryTarget", queryInfo.get("queryTarget").getUpdate());
		paramMap1.put("params", null);
		di.DB(paramMap1);
		
		for (int i = 0; i < dataList.size(); i++) {
			// delete
			/*
			paramMap1 = new HashMap<String, Object>();
			paramMap1.put("queryType", "delete");
			paramMap1.put("queryTarget", queryInfo.get("queryTarget").getDelete());
			paramMap1.put("params", dataList.get(i));
			del += (Integer) di.DB(paramMap1).get("result");
			*/
			
			// insert
			paramMap2 = new HashMap<String, Object>();
			paramMap2.put("queryType", "insert");
			paramMap2.put("queryTarget", queryInfo.get("queryTarget").getInsert());
			paramMap2.put("params", dataList.get(i));
			tot += (Integer) di.DB(paramMap2).get("result");
			
		}
		System.out.println("tot: "+tot);
		
		return null;
		
	}
	
	public List<HashMap<String, Object>> getHTMLData(String url) {
		List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> row;
		
		HashMap<String, UrlBean> urlinfo = ui.UrlInfo(url);
		String target = urlinfo.get("urlinfo").getTarget();
		HashMap<String, String> columns = urlinfo.get("urlinfo").getColumns();
		//for (int i = 1; i <= 5; i++) {
			url = urlinfo.get("urlinfo").getUrl(); //+ i;
			
			try {
				Document doc = Jsoup.connect(url).get();
				Elements newsHeadlines = doc.select(target);
				for (Element headline : newsHeadlines) {
					row = new HashMap<String, Object>();
					
					for (String key : columns.keySet()) {
						String value = headline.select(columns.get(key)).text();
						row.put(key, value);
					}
					dataList.add(row);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		//}
		return dataList;
		
	}

}
