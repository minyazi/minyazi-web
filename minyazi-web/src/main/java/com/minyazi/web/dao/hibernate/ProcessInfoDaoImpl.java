package com.minyazi.web.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minyazi.web.Paging;
import com.minyazi.web.dao.ProcessInfoDao;
import com.minyazi.web.domain.ProcessInfo;

/**
 * 处理信息Dao
 * 
 * @author minyazi
 */
@Repository("processInfoDao")
public class ProcessInfoDaoImpl extends DefaultDao implements ProcessInfoDao {
    public ProcessInfoDaoImpl() {}
    
    @Override
    public int insert(ProcessInfo info) {
        return 0;
    }
    
    @Override
    public int deleteById(String processCode) {
        return 0;
    }
    
    @Override
    public int deleteAll() {
        return 0;
    }
    
    @Override
    public int update(ProcessInfo info) {
        return 0;
    }
    
    @Override
    public ProcessInfo selectById(String processCode) {
        return null;
    }
    
    @Override
    public List<ProcessInfo> selectAll() {
        return null;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Paging<ProcessInfo> queryToPaging(int page, int pageSize) {
        return null;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Paging<ProcessInfo> queryToPaging(int page, int pageSize, String queryCondition) {
        return null;
    }
}
