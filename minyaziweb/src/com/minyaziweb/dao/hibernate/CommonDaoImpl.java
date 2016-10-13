package com.minyaziweb.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.minyaziweb.dao.CommonDao;

/**
 * 公共Dao<br>
 * 
 * @author minyazi
 */
@Repository("commonDao")
public class CommonDaoImpl implements CommonDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public CommonDaoImpl() {
		
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
	
}
