package com.minyazi.web.base;

import com.minyazi.web.Paging;

/**
 * 分页Dao
 * 
 * @author minyazi
 */
public interface PagingDao {
    /**
     * 分页查询数据
     * 
     * @param <T> 类型参数
     * @param page 页码
     * @param pageSize 每页记录数
     * @return 查询结果
     */
    <T> Paging<T> queryToPaging(int page, int pageSize);
    
    /**
     * 分页查询数据
     * 
     * @param <T> 类型参数
     * @param page 页码
     * @param pageSize 每页记录数
     * @param queryCondition 查询条件
     * @return 查询结果
     */
    <T> Paging<T> queryToPaging(int page, int pageSize, String queryCondition);
}
