package com.minyaziweb.domain;

import java.io.Serializable;

/**
 * SQL信息<br>
 * 
 * @author minyazi
 */
public class SqlInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String sql; // SQL语句
	private Object[] params; // 参数集
	
	public SqlInfo() {
		
	}
	
	public SqlInfo(String sql, Object... params) {
		this.sql = sql;
		this.params = params;
	}
	
	public String getSql() {
		return sql;
	}
	
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public Object[] getParams() {
		return params;
	}
	
	public void setParams(Object... params) {
		this.params = params;
	}
	
}
