package com.minyazi.web.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.minyazi.core.util.LogUtil;
import com.minyazi.web.dao.ProcessInfoDao;
import com.minyazi.web.domain.ProcessInfo;

public class MyBatisTest {
    private static SqlSessionFactory sessionFactory;
    
    @BeforeClass
    public static void init() {
        InputStream is = MyBatisTest.class.getClassLoader().getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
        
//        Reader reader = Resources.getResourceAsReader("mybatis.xml");
//        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    
    @Test
    public void testInsert() {
        SqlSession session = sessionFactory.openSession();
        try {
            ProcessInfoDao dao = session.getMapper(ProcessInfoDao.class);
            
            dao.deleteAll();
            session.commit();
            
            ProcessInfo info = new ProcessInfo();
            info.setProcessCode("PC000000");
            info.setProcessMesg("处理成功");
            LogUtil.info(dao.insert(info) + "");
            session.commit();
            
            info = new ProcessInfo();
            info.setProcessCode("PC999999");
            info.setProcessMesg("处理失败");
            LogUtil.info(dao.insert(info) + "");
            session.commit();
        } finally {
            session.close();
        }
    }
    
    @Test
    public void testDelete() {
        SqlSession session = sessionFactory.openSession();
        try {
            ProcessInfoDao dao = session.getMapper(ProcessInfoDao.class);
            LogUtil.info(dao.deleteById("PC000000") + "");
            session.commit();
        } finally {
            session.close();
        }
    }
    
    @Test
    public void testUpdate() {
        SqlSession session = sessionFactory.openSession();
        try {
            ProcessInfoDao dao = session.getMapper(ProcessInfoDao.class);
            
            ProcessInfo info = new ProcessInfo();
            info.setProcessCode("PC999999");
            info.setProcessMesg("处理成功");
            LogUtil.info(dao.update(info) + "");
            session.commit();
        } finally {
            session.close();
        }
    }
    
    @Test
    public void testSelect() {
        SqlSession session = sessionFactory.openSession();
        try {
            ProcessInfoDao dao = session.getMapper(ProcessInfoDao.class);
            
            ProcessInfo info = dao.selectById("PC999999");
            LogUtil.info(info.toString());
//            LogUtil.info(new String(info.getProcessMesg().getBytes("ISO-8859-1"), "GB2312"));
            
            List<ProcessInfo> infos = dao.selectAll();
            LogUtil.info(infos.toString());
        } finally {
            session.close();
        }
    }
}
