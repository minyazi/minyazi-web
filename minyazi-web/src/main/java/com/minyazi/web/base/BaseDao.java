package com.minyazi.web.base;

import com.minyazi.web.Paging;

/**
 * 基础Dao
 * 
 * @author minyazi
 */
public abstract class BaseDao implements PagingDao {
    public BaseDao() {}
    
    @Override
    public <T> Paging<T> queryToPaging(int page, int pageSize) {
        return null;
    }
    
    @Override
    public <T> Paging<T> queryToPaging(int page, int pageSize, String queryCondition) {
        return null;
    }
}
