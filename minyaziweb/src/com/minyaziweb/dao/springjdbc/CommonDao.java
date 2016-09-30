package com.minyaziweb.dao.springjdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.minyaziutils.LogUtil;
import com.minyaziweb.Paging;

/**
 * 公共Dao<br>
 * 
 * @author minyazi
 */
@Repository("commonDao")
public class CommonDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CommonDao() {
		
	}
	
	public CommonDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	/**
	 * Spring依赖注入<br>
	 */
	@Required
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public List<Map<String, Object>> queryToMap(String sql) {
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		
		return result;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询结果。
	 */
	public List<Map<String, Object>> queryToMap(String sql, Object... params) {
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		
		return result;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public List<Map<String, String>> queryToMap2(String sql) {
		List<Map<String, String>> result = this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String, String>> result = new ArrayList<Map<String, String>>();
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					Map<String, String> _result = new HashMap<String, String>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						String columnName = rsmd.getColumnName(i);
						_result.put(columnName, rs.getString(columnName));
					}
					result.add(_result);
				}
				return result;
			}
		});
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		
		return result;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询结果。
	 */
	public List<Map<String, String>> queryToMap2(String sql, Object... params) {
		List<Map<String, String>> result = this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String, String>> result = new ArrayList<Map<String, String>>();
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					Map<String, String> _result = new HashMap<String, String>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						String columnName = rsmd.getColumnName(i);
						_result.put(columnName, rs.getString(columnName));
					}
					result.add(_result);
				}
				return result;
			}
		}, params);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		
		return result;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public <T> List<T> queryToBean(Class<T> c, String sql) {
		List<T> result = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(c));
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		
		return result;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询结果。
	 */
	public <T> List<T> queryToBean(Class<T> c, String sql, Object... params) {
		List<T> result = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(c), params);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		
		return result;
	}
	
	/**
	 * 更新数据<br>
	 * 
	 * @param sql SQL语句
	 * @return 返回更新结果。
	 */
	public int update(String sql) {
		int result = this.getJdbcTemplate().update(sql);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result);
		
		return result;
	}
	
	/**
	 * 更新数据<br>
	 * 
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回更新结果。
	 */
	public int update(String sql, Object... params) {
		int result = this.getJdbcTemplate().update(sql, params);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result);
		
		return result;
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public Paging<Map<String, Object>> queryToPaging(int page, int pageSize, String sql) {
		// 获取总记录数
		StringBuilder _sql = new StringBuilder(500);
		_sql.append("select count(*) from (").append(sql).append(") as T");
		int totalNumber = this.getJdbcTemplate().queryForObject(_sql.toString(), Integer.class);
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<Map<String, Object>> result = new Paging<Map<String, Object>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToMap(_sql.toString()));
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + result.getList().size());
		
		return result;
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询结果。
	 */
	public Paging<Map<String, Object>> queryToPaging(int page, int pageSize, String sql, Object... params) {
		// 获取总记录数
		StringBuilder _sql = new StringBuilder(500);
		_sql.append("select count(*) from (").append(sql).append(") as T");
		int totalNumber = this.getJdbcTemplate().queryForObject(_sql.toString(), Integer.class, params);
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<Map<String, Object>> result = new Paging<Map<String, Object>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToMap(_sql.toString(), params));
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + result.getList().size());
		
		return result;
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public Paging<Map<String, String>> queryToPaging2(int page, int pageSize, String sql) {
		// 获取总记录数
		StringBuilder _sql = new StringBuilder(500);
		_sql.append("select count(*) from (").append(sql).append(") as T");
		int totalNumber = this.getJdbcTemplate().queryForObject(_sql.toString(), Integer.class);
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<Map<String, String>> result = new Paging<Map<String, String>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToMap2(_sql.toString()));
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + result.getList().size());
		
		return result;
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询结果。
	 */
	public Paging<Map<String, String>> queryToPaging2(int page, int pageSize, String sql, Object... params) {
		// 获取总记录数
		StringBuilder _sql = new StringBuilder(500);
		_sql.append("select count(*) from (").append(sql).append(") as T");
		int totalNumber = this.getJdbcTemplate().queryForObject(_sql.toString(), Integer.class, params);
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<Map<String, String>> result = new Paging<Map<String, String>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToMap2(_sql.toString(), params));
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + result.getList().size());
		
		return result;
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public <T> Paging<T> queryToPaging(Class<T> c, int page, int pageSize, String sql) {
		// 获取总记录数
		StringBuilder _sql = new StringBuilder(500);
		_sql.append("select count(*) from (").append(sql).append(") as T");
		int totalNumber = this.getJdbcTemplate().queryForObject(_sql.toString(), Integer.class);
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<T> result = new Paging<T>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToBean(c, _sql.toString()));
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + result.getList().size());
		
		return result;
	}
	
	/**
	 * 分页查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param page 页码
	 * @param pageSize 每页记录数
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询结果。
	 */
	public <T> Paging<T> queryToPaging(Class<T> c, int page, int pageSize, String sql, Object... params) {
		// 获取总记录数
		StringBuilder _sql = new StringBuilder(500);
		_sql.append("select count(*) from (").append(sql).append(") as T");
		int totalNumber = this.getJdbcTemplate().queryForObject(_sql.toString(), Integer.class, params);
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<T> result = new Paging<T>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToBean(c, _sql.toString(), params));
		
		LogUtil.info("（执行SQL）" + sql.toString() + "，（执行结果）" + result.getList().size());
		
		return result;
	}
	
}
