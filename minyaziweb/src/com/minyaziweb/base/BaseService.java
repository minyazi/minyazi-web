package com.minyaziweb.base;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 基础Service<br>
 * 
 * @author minyazi
 */
public class BaseService {
	
	private JdbcTemplate jdbcTemplate;
	
	public BaseService() {
		
	}
	
	public BaseService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	/**
	 * Spring依赖注入<br>
	 */
	@Required
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
