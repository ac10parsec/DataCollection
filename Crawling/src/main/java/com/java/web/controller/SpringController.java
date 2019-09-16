package com.java.web.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.web.service.SpringServerInterface;
import com.java.web.service.Test;

@Controller
public class SpringController {
	
	@Autowired
	SpringServerInterface si;
	
	@Autowired
	Test ti;
	
	@RequestMapping("/test")
	public HashMap<String, Object> test() {
		ti.test();
		return null;
	}
	
	@RequestMapping("/getData")
	public String getData(Model model) {
		String url = "http://www.gdu.co.kr/process/process_010100.html";
		HashMap<String, Object> resultMap = si.getData(url);
		model.addAttribute("data", resultMap);
		return "result";
	}
	
	@RequestMapping("/setData")
	public HashMap<String, Object> setData() {
		String url = "http://www.gdu.co.kr/process/process_010100.html";
		si.setData(url);
		return null;
	}
	
}
