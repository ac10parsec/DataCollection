package com.java.web.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.java.web.bean.UrlBean;

@Component
public class UrlInfo {

	public HashMap<String, UrlBean> UrlInfo(String url) {
		HashMap<String, UrlBean> resultMap = new HashMap<String, UrlBean>();
		if ("https://www.genie.co.kr/genre/M0200?genreCode=M0200&pg=".equals(url)) {
			resultMap = urlInfo1(url);
		} else if ("http://www.gdu.co.kr/process/process_010100.html".equals(url)) {
			resultMap = urlInfo2(url);
		}
		return resultMap;
	}
	
	public HashMap<String, UrlBean> urlInfo1(String url) {
		HashMap<String, UrlBean> resultMap = new HashMap<String, UrlBean>();
		String target = ".list .info";
		HashMap<String, String> columns = new HashMap<String, String>();
		columns.put("title", ".title");
		columns.put("artist", ".artist");
		columns.put("album", ".albumtitle");
		resultMap.put("urlinfo", new UrlBean(url, target, columns));
		return resultMap;
	}
	
	public HashMap<String, UrlBean> urlInfo2(String url) {
		HashMap<String, UrlBean> resultMap = new HashMap<String, UrlBean>();
		String target = ".process-list .first_li";
		HashMap<String, String> columns = new HashMap<String, String>();
		columns.put("title", ".tit");
		columns.put("term", ".date");
		columns.put("teacher", ".clearfix");
		resultMap.put("urlinfo", new UrlBean(url, target, columns));
		return resultMap;
	}
}
