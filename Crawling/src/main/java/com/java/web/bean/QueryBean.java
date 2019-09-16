package com.java.web.bean;

public class QueryBean {
	
	String select;
	String insert;
	String delete;
	String update;
	
	public QueryBean(String select, String insert, String delete, String update) {
		setSelect(select);
		setInsert(insert);
		setDelete(delete);
		setUpdate(update);
	}
	
	private void setSelect(String select) {
		this.select = select;
	}
	private void setInsert(String insert) {
		this.insert = insert;
	}
	private void setDelete(String delete) {
		this.delete = delete;
	}
	private void setUpdate(String update) {
		this.update = update;
	}
	
	public String getSelect() {
		return select;
	}
	public String getInsert() {
		return insert;
	}
	public String getDelete() {
		return delete;
	}
	public String getUpdate() {
		return update;
	}
}
