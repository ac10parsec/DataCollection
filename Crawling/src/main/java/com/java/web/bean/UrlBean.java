package com.java.web.bean;

import java.util.HashMap;

public class UrlBean {
	
	String url;
	String target;
	HashMap<String, String> columns;
	
	public UrlBean(String url, String target, HashMap<String, String> columns) {
		setUrl(url);
		setTarget(target);
		setColumns(columns);
	}
	
	private void setUrl(String url) {
		this.url = url;
	}
	private void setTarget(String target) {
		this.target = target;
	}
	private void setColumns(HashMap<String, String> columns) {
		this.columns = columns;
	}
	
	public String getUrl() {
		return url;
	}
	public String getTarget() {
		return target;
	}
	public HashMap<String, String> getColumns() {
		return columns;
	}
	
	@Override
	public String toString() {
		return "UrlBean [url=" + url + ", target=" + target + ", columns=" + columns + "]";
	}
}
