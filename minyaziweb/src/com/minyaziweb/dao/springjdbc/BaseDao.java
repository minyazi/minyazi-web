package com.minyaziweb.dao.springjdbc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

import com.minyaziweb.Paging;

/**
 * 基础Dao<br>
 * 
 * @author minyazi
 */
public abstract class BaseDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public BaseDao() {
		
	}
	
	public BaseDao(JdbcTemplate jdbcTemplate) {
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
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @return 返回查询结果。
	 */
	public abstract <T> Paging<T> queryToPaging(int page, int pageSize);
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param queryCondition 查询条件
	 * @return 返回查询结果。
	 */
	public abstract <T> Paging<T> queryToPaging(int page, int pageSize, String queryCondition);
	
}
