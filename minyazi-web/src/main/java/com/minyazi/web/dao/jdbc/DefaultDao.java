package com.minyazi.web.dao.jdbc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

import com.minyazi.web.base.BaseDao;

/**
 * Default Dao
 * 
 * @author minyazi
 */
public class DefaultDao extends BaseDao {
    private CommonDaoImpl commonDao;
    
    public DefaultDao() {}
    
    public CommonDaoImpl getCommonDao() {
        return commonDao;
    }
    
    @Required
    @Resource
    public void setCommonDao(CommonDaoImpl commonDao) {
        this.commonDao = commonDao;
    }
}
