package com.minyazi.web.service;

import org.springframework.stereotype.Service;

import com.minyazi.core.util.DateUtil;
import com.minyazi.core.util.LogUtil;
import com.minyazi.web.base.BaseService;

/**
 * 公共Service
 * 
 * @author minyazi
 */
@Service("commonService")
public class CommonService extends BaseService {
    public CommonService() {}
    
    /**
     * 测试定时任务
     */
    public void testTask() {
        LogUtil.info(DateUtil.getISODateTime());
    }
}
