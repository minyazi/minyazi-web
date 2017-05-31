package com.minyazi.web.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.minyazi.web.dao.CommonDao;

/**
 * 公共Dao
 * 
 * @author minyazi
 */
@Repository("commonDao")
public class CommonDaoImpl implements CommonDao {
    private HibernateTemplate hibernateTemplate;
    
    public CommonDaoImpl() {}
    
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    
    @Required
    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
