package com.minyazi.web.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.minyazi.core.util.LogUtil;
import com.minyazi.web.dao.ProcessInfoDao;
import com.minyazi.web.domain.ProcessInfo;

public class SpringJDBCTest {
    private static ApplicationContext context;
    private static ProcessInfoDao processInfoDao;
    
    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext-springjdbc.xml");
        processInfoDao = context.getBean("processInfoDao", ProcessInfoDao.class);
    }
    
    @Test
    public void testInsert() {
        processInfoDao.deleteAll();
        
        ProcessInfo info = new ProcessInfo();
        info.setProcessCode("PC000000");
        info.setProcessMesg("处理成功");
        LogUtil.info(processInfoDao.insert(info) + "");
        
        info = new ProcessInfo();
        info.setProcessCode("PC999999");
        info.setProcessMesg("处理失败");
        LogUtil.info(processInfoDao.insert(info) + "");
    }
    
    @Test
    public void testPaging() {
        LogUtil.info(processInfoDao.queryToPaging(1, 10).toString());
    }
    
    @Test
    public void testDelete() {
        LogUtil.info(processInfoDao.deleteById("PC000000") + "");
    }
    
    @Test
    public void testUpdate() {
        ProcessInfo info = new ProcessInfo();
        info.setProcessCode("PC999999");
        info.setProcessMesg("处理成功");
        LogUtil.info(processInfoDao.update(info) + "");
    }
    
    @Test
    public void testSelect() {
        ProcessInfo info = processInfoDao.selectById("PC999999");
        LogUtil.info(info.toString());
//        LogUtil.info(new String(info.getProcessMesg().getBytes("ISO-8859-1"), "GB2312"));
        
        List<ProcessInfo> infos = processInfoDao.selectAll();
        LogUtil.info(infos.toString());
    }
}
