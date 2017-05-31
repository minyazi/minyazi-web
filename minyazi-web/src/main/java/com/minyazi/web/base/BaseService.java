package com.minyazi.web.base;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

import com.minyazi.web.dao.CommonDao;

/**
 * 基础Service
 * 
 * @author minyazi
 */
public abstract class BaseService {
    private CommonDao commonDao;
    
    public BaseService() {}
    
    public CommonDao getCommonDao() {
        return commonDao;
    }
    
    @Required
    @Resource
    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }
}
