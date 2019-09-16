package com.java.web.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDao implements SpringDaoInterface {
	
	@Autowired
	SqlSession session;
	
	@Override
	public HashMap<String, Object> DB(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		String queryType = paramMap.get("queryType").toString();
		String queryTarget = paramMap.get("queryTarget").toString();
		HashMap<String, Object> params = (HashMap<String, Object>) paramMap.get("params");
		
		if("selectOne".equals(queryType)) {
			resultMap.put("result", session.selectOne(queryTarget, params));
			
		} else if("selectList".equals(queryType)) {
			resultMap.put("result", session.selectList(queryTarget, params));
			
		} else if("insert".equals(queryType)) {
			resultMap.put("result", session.insert(queryTarget, params));
			
		} else if("update".equals(queryType)) {
			resultMap.put("result", session.update(queryTarget, params));
			
		} else if("delete".equals(queryType)) {
			resultMap.put("result", session.delete(queryTarget, params));
			
		}
		
		return resultMap;
	}

}
