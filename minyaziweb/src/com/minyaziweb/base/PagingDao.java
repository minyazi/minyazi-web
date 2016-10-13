package com.minyaziweb.base;

import com.minyaziweb.Paging;

/**
 * 分页Dao<br>
 * 
 * @author minyazi
 */
public interface PagingDao {
	
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
