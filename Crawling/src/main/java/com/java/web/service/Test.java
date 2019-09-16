package com.java.web.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class Test {
	
	public void test() {
		try {
			String url = "http://www.gdu.co.kr/process/process_010100.html";
			Document doc = Jsoup.connect(url).get();
			Elements newsHeadlines = doc.select(".process-list .first_li");
			for (Element headline : newsHeadlines) {				
				String tit = headline.select(".tit").text();
				String date = headline.select(".date").text();
				String clearfix = headline.select(".clearfix").text();
				System.out.println(tit);
				System.out.println(date);
				System.out.println(clearfix);
				System.out.println("===========================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
