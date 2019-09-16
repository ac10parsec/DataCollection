package com.java.web.service;

import java.util.HashMap;

public interface SpringServerInterface {
	
	public HashMap<String, Object> getData(String url);
	public HashMap<String, Object> setData(String url);
	
}
