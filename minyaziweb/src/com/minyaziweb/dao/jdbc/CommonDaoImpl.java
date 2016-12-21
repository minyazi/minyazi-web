package com.minyaziweb.dao.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Repository;

import com.minyaziutils.LogUtil;
import com.minyaziutils.StringUtil;
import com.minyaziweb.Paging;
import com.minyaziweb.dao.CommonDao;

/**
 * 公共Dao<br>
 * 
 * @author minyazi
 */
@Repository("commonDao")
public class CommonDaoImpl implements CommonDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CommonDaoImpl() {
		
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
	public List<Map<String, Object>> queryToList(String sql) {
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
	public List<Map<String, Object>> queryToList(String sql, Object... params) {
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
		return result;
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @return 返回查询结果。
	 */
	public List<Map<String, String>> queryToList2(String sql) {
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
	public List<Map<String, String>> queryToList2(String sql, Object... params) {
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
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
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
	public <T> List<T> queryToList(Class<T> c, String sql) {
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
	public <T> List<T> queryToList(Class<T> c, String sql, Object... params) {
		List<T> result = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(c), params);
		
		LogUtil.info("（执行SQL）" + sql + "，（执行结果）" + result.size());
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
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
	public <T> T queryToBean(Class<T> c, String sql) {
		List<T> result = this.queryToList(c, sql);
		
		T t = null;
		if (result.size() != 0) {
			t = result.get(0);
		}
		
		return t;
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
	public <T> T queryToBean(Class<T> c, String sql, Object... params) {
		List<T> result = this.queryToList(c, sql, params);
		
		T t = null;
		if (result.size() != 0) {
			t = result.get(0);
		}
		
		return t;
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
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
		return result;
	}
	
	/**
	 * 保存数据<br>
	 * 
	 * @param tableName 表名
	 * @param data 要保存的数据
	 * @return 返回保存结果。
	 */
	public int insert(String tableName, Map<String, String> data) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("select * from ").append(tableName);
		SqlRowSet srs = this.getJdbcTemplate().queryForRowSet(sql.toString());
		SqlRowSetMetaData srsmd = srs.getMetaData();
		int columnCount = srsmd.getColumnCount();
		
		StringBuilder fields = new StringBuilder(500);
		StringBuilder values = new StringBuilder(500);
		Object[] params = new Object[columnCount];
		for (int i = 1; i <= columnCount; i++) {
			String columnName = srsmd.getColumnName(i);
			String columnValue = StringUtil.formatNullString(data.get(columnName));
			
			if (i != columnCount) {
				fields.append(columnName).append(",");
				values.append("?,");
			} else {
				fields.append(columnName);
				values.append("?");
			}
			params[i - 1] = columnValue;
		}
		
		if (columnCount > 0) {
			sql = new StringBuilder(500);
			sql.append("insert into ").append(tableName).append(" (").append(fields).append(")");
			sql.append(" values (").append(values).append(")");
			return this.update(sql.toString(), params);
		} else {
			return 0;
		}
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
		
		LogUtil.info("（执行SQL）" + _sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<Map<String, Object>> result = new Paging<Map<String, Object>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToList(_sql.toString()));
		
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
		
		LogUtil.info("（执行SQL）" + _sql.toString() + "，（执行结果）" + totalNumber);
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
		Paging<Map<String, Object>> result = new Paging<Map<String, Object>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToList(_sql.toString(), params));
		
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
		
		LogUtil.info("（执行SQL）" + _sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<Map<String, String>> result = new Paging<Map<String, String>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToList2(_sql.toString()));
		
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
		
		LogUtil.info("（执行SQL）" + _sql.toString() + "，（执行结果）" + totalNumber);
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
		Paging<Map<String, String>> result = new Paging<Map<String, String>>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToList2(_sql.toString(), params));
		
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
		
		LogUtil.info("（执行SQL）" + _sql.toString() + "，（执行结果）" + totalNumber);
		
		Paging<T> result = new Paging<T>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToList(c, _sql.toString()));
		
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
		
		LogUtil.info("（执行SQL）" + _sql.toString() + "，（执行结果）" + totalNumber);
		LogUtil.info("（SQL参数）" + Arrays.toString(params));
		
		Paging<T> result = new Paging<T>(page, pageSize, totalNumber);
		
		// 获取当前页的所有记录
		_sql = new StringBuilder(500);
		_sql.append(sql).append(" limit ").append(result.getOffset()).append(",").append(pageSize);
		result.setList(this.queryToList(c, _sql.toString(), params));
		
		return result;
	}
	
}
