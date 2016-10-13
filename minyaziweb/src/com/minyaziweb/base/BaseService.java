package com.minyaziweb.base;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

import com.minyaziweb.dao.CommonDao;

/**
 * 基础Service<br>
 * 
 * @author minyazi
 */
public abstract class BaseService {
	
	private CommonDao commonDao;
	
	public BaseService() {
		
	}
	
	public CommonDao getCommonDao() {
		return commonDao;
	}

	/**
	 * Spring依赖注入<br>
	 */
	@Required
	@Resource
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
}
