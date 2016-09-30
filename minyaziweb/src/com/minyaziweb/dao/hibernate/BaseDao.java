package com.minyaziweb.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.minyaziweb.Paging;

/**
 * 基础Dao<br>
 * 
 * @author minyazi
 */
public abstract class BaseDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public BaseDao() {
		
	}
	
	public BaseDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	/**
	 * Spring依赖注入<br>
	 */
	@Required
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
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
