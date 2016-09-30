package com.minyaziweb.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.minyaziutils.DateUtil;
import com.minyaziutils.LogUtil;
import com.minyaziutils.PlatformException;
import com.minyaziutils.StringUtil;
import com.minyaziweb.Paging;
import com.minyaziweb.base.BaseService;
import com.minyaziweb.dao.springjdbc.CommonDao;
import com.minyaziweb.domain.SqlInfo;

/**
 * 公共Service<br>
 * 
 * @author minyazi
 */
@Service("commonService")
public class CommonService extends BaseService {
	
	private CommonDao commonDao;
	
	public CommonService() {
		
	}
	
	public CommonDao getCommonDao() {
		return commonDao;
	}

	/**
	 * Spring依赖注入<br>
	 */
	@Required
	@Resource
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
	/**
	 * 新增数据<br>
	 * 
	 * @param sqlInfos SQL信息
	 */
	public void addDatas(SqlInfo... sqlInfos) {
		for (SqlInfo sqlInfo : sqlInfos) {
			LogUtil.info("SQL语句=" + sqlInfo.getSql());
			if (StringUtil.formatNullString(sqlInfo.getSql()).trim().equals("")) {
				PlatformException pe = new PlatformException("SQL语句不能为空");
				LogUtil.exception(pe);
				throw pe;
			}
			
			// 新增数据
			if (this.getCommonDao().update(sqlInfo.getSql(), sqlInfo.getParams()) != 1) {
				PlatformException pe = new PlatformException("新增数据失败");
				LogUtil.exception(pe);
				throw pe;
			}
		}
	}
	
	/**
	 * 删除数据<br>
	 * 
	 * @param sqlInfos SQL信息
	 */
	public void deleteDatas(SqlInfo... sqlInfos) {
		for (SqlInfo sqlInfo : sqlInfos) {
			LogUtil.info("SQL语句=" + sqlInfo.getSql());
			if (StringUtil.formatNullString(sqlInfo.getSql()).trim().equals("")) {
				PlatformException pe = new PlatformException("SQL语句不能为空");
				LogUtil.exception(pe);
				throw pe;
			}
			
			// 删除数据
			if (this.getCommonDao().update(sqlInfo.getSql(), sqlInfo.getParams()) < 1) {
				PlatformException pe = new PlatformException("删除数据失败");
				LogUtil.exception(pe);
				throw pe;
			}
		}
	}
	
	/**
	 * 修改数据<br>
	 * 
	 * @param sqlInfos SQL信息
	 */
	public void modifyDatas(SqlInfo... sqlInfos) {
		for (SqlInfo sqlInfo : sqlInfos) {
			LogUtil.info("SQL语句=" + sqlInfo.getSql());
			if (StringUtil.formatNullString(sqlInfo.getSql()).trim().equals("")) {
				PlatformException pe = new PlatformException("SQL语句不能为空");
				LogUtil.exception(pe);
				throw pe;
			}
			
			// 修改数据
			if (this.getCommonDao().update(sqlInfo.getSql(), sqlInfo.getParams()) < 1) {
				PlatformException pe = new PlatformException("修改数据失败");
				LogUtil.exception(pe);
				throw pe;
			}
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sqlInfo SQL信息
	 * @return 返回查询结果。
	 */
	public List<Map<String, Object>> getDatas(SqlInfo sqlInfo) {
		if (sqlInfo == null) {
			PlatformException pe = new PlatformException("SQL信息不能为空");
			LogUtil.exception(pe);
			throw pe;
		}
		
		LogUtil.info("SQL语句=" + sqlInfo.getSql());
		if (StringUtil.formatNullString(sqlInfo.getSql()).trim().equals("")) {
			PlatformException pe = new PlatformException("SQL语句不能为空");
			LogUtil.exception(pe);
			throw pe;
		}
		
		return this.getCommonDao().queryToMap(sqlInfo.getSql(), sqlInfo.getParams());
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sqlInfo SQL信息
	 * @return 返回查询结果。
	 */
	public Paging<Map<String, Object>> getDatasByPaging(int page, int pageSize, SqlInfo sqlInfo) {
		if (sqlInfo == null) {
			PlatformException pe = new PlatformException("SQL信息不能为空");
			LogUtil.exception(pe);
			throw pe;
		}
		
		LogUtil.info("SQL语句=" + sqlInfo.getSql());
		if (StringUtil.formatNullString(sqlInfo.getSql()).trim().equals("")) {
			PlatformException pe = new PlatformException("SQL语句不能为空");
			LogUtil.exception(pe);
			throw pe;
		}
		
		return this.getCommonDao().queryToPaging(page, pageSize, sqlInfo.getSql(), sqlInfo.getParams());
	}
	
	/**
	 * 测试定时任务<br>
	 */
	public void testTask() {
		LogUtil.info(DateUtil.getISODateTime());
	}
	
}
