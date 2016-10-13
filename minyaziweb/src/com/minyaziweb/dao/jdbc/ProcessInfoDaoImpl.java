package com.minyaziweb.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minyaziweb.Paging;
import com.minyaziweb.dao.ProcessInfoDao;
import com.minyaziweb.domain.ProcessInfo;

/**
 * 处理信息Dao<br>
 * 
 * @author minyazi
 */
@Repository("processInfoDao")
public class ProcessInfoDaoImpl extends DefaultDao implements ProcessInfoDao {
	
	public ProcessInfoDaoImpl() {
		
	}
	
	@Override
	public int insert(ProcessInfo info) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("insert into ProcessInfo (");
		sql.append("processCode,");
		sql.append("processMesg");
		sql.append(") values (?,?)");
		
		Object[] params = {info.getProcessCode(),
				info.getProcessMesg()};
		
		return this.getCommonDao().update(sql.toString(), params);
	}
	
	@Override
	public int deleteById(String processCode) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("delete from ProcessInfo where processCode=?");
		
		Object[] params = {processCode};
		
		return this.getCommonDao().update(sql.toString(), params);
	}
	
	@Override
	public int deleteAll() {
		StringBuilder sql = new StringBuilder(500);
		sql.append("delete from ProcessInfo");
		
		return this.getCommonDao().update(sql.toString());
	}
	
	@Override
	public int update(ProcessInfo info) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("update ProcessInfo set ");
		sql.append("processMesg=?");
		sql.append(" where processCode=?");
		
		Object[] params = {info.getProcessMesg(),
				info.getProcessCode()};
		
		return this.getCommonDao().update(sql.toString(), params);
	}
	
	@Override
	public ProcessInfo selectById(String processCode) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("select * from ProcessInfo where processCode=?");
		
		Object[] params = {processCode};
		
		return this.getCommonDao().queryToBean(ProcessInfo.class, sql.toString(), params);
	}
	
	@Override
	public List<ProcessInfo> selectAll() {
		StringBuilder sql = new StringBuilder(500);
		sql.append("select * from ProcessInfo order by processCode");
		
		return this.getCommonDao().queryToList(ProcessInfo.class, sql.toString());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Paging<ProcessInfo> queryToPaging(int page, int pageSize) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("select * from ProcessInfo order by processCode");
		
		return this.getCommonDao().queryToPaging(ProcessInfo.class, page, pageSize, sql.toString());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Paging<ProcessInfo> queryToPaging(int page, int pageSize, String queryCondition) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("select * from ProcessInfo where 1=1 ").append(queryCondition).append(" order by processCode");
		
		return this.getCommonDao().queryToPaging(ProcessInfo.class, page, pageSize, sql.toString());
	}
	
}
