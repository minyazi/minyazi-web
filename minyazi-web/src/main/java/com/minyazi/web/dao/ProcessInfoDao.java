package com.minyazi.web.dao;

import java.util.List;

import com.minyazi.web.base.PagingDao;
import com.minyazi.web.domain.ProcessInfo;

/**
 * 处理信息Dao
 * 
 * @author minyazi
 */
public interface ProcessInfoDao extends PagingDao {
    /**
     * 新增处理信息
     * 
     * @param info 处理信息
     * @return 新增的记录数
     */
    int insert(ProcessInfo info);
    
    /**
     * 删除处理信息
     * 
     * @param processCode 处理码
     * @return 删除的记录数
     */
    int deleteById(String processCode);
    
    /**
     * 删除处理信息
     * 
     * @return 删除的记录数
     */
    int deleteAll();
    
    /**
     * 修改处理信息
     * 
     * @param info 处理信息
     * @return 修改的记录数
     */
    int update(ProcessInfo info);
    
    /**
     * 查询处理信息
     * 
     * @param processCode 处理码
     * @return 查询结果
     */
    ProcessInfo selectById(String processCode);
    
    /**
     * 查询处理信息
     * 
     * @return 查询结果
     */
    List<ProcessInfo> selectAll();
}
