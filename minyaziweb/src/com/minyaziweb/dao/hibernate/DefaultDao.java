package com.minyaziweb.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

import com.minyaziweb.base.BaseDao;

/**
 * Default Dao<br>
 * 
 * @author minyazi
 */
public class DefaultDao extends BaseDao {
	
	private CommonDaoImpl commonDao;
	
	public DefaultDao() {
		
	}
	
	public CommonDaoImpl getCommonDao() {
		return commonDao;
	}
	
	/**
	 * Spring依赖注入<br>
	 */
	@Required
	@Resource
	public void setCommonDao(CommonDaoImpl commonDao) {
		this.commonDao = commonDao;
	}
	
}
