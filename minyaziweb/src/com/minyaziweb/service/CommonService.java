package com.minyaziweb.service;

import org.springframework.stereotype.Service;

import com.minyaziutils.DateUtil;
import com.minyaziutils.LogUtil;
import com.minyaziweb.base.BaseService;

/**
 * 公共Service<br>
 * 
 * @author minyazi
 */
@Service("commonService")
public class CommonService extends BaseService {
	
	public CommonService() {
		
	}
	
	/**
	 * 测试定时任务<br>
	 */
	public void testTask() {
		LogUtil.info(DateUtil.getISODateTime());
	}
	
}
