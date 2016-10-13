package com.minyaziweb.dao;

import java.util.List;

import com.minyaziweb.base.PagingDao;
import com.minyaziweb.domain.ProcessInfo;

/**
 * 处理信息Dao<br>
 * 
 * @author minyazi
 */
public interface ProcessInfoDao extends PagingDao {
	
	/**
	 * 新增处理信息<br>
	 * 
	 * @param info 处理信息
	 * @return 返回新增的记录数。
	 */
	public abstract int insert(ProcessInfo info);
	
	/**
	 * 删除处理信息<br>
	 * 
	 * @param processCode 处理码
	 * @return 返回删除的记录数。
	 */
	public abstract int deleteById(String processCode);
	
	/**
	 * 删除处理信息<br>
	 * 
	 * @return 返回删除的记录数。
	 */
	public abstract int deleteAll();
	
	/**
	 * 修改处理信息<br>
	 * 
	 * @param info 处理信息
	 * @return 返回修改的记录数。
	 */
	public abstract int update(ProcessInfo info);
	
	/**
	 * 查询处理信息<br>
	 * 
	 * @param processCode 处理码
	 * @return 返回查询结果。
	 */
	public abstract ProcessInfo selectById(String processCode);
	
	/**
	 * 查询处理信息<br>
	 * 
	 * @return 返回查询结果。
	 */
	public abstract List<ProcessInfo> selectAll();
	
}
