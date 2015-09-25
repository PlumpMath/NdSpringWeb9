package com.tatvasoft.controller;

import java.util.List;

import com.tatvasoft.model.Usermaster;

public class UserResponseController {
	
	
	private List<Usermaster> rows;
	private Integer total;
	private Integer records;
	private Integer page;
	public List<Usermaster> getRows() {
		return rows;
	}
	public void setRows(List<Usermaster> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	
	
}
