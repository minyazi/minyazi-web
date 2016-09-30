package com.minyaziweb.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.minyaziutils.LogUtil;
import com.minyaziweb.domain.ProcessInfo;

/**
 * MyBatisTest<br>
 * 
 * @author minyazi
 */
public class MyBatisTest {
	
	private static SqlSessionFactory sessionFactory;
	
	@BeforeClass
	public static void init() {
		InputStream is = MyBatisTest.class.getClassLoader().getResourceAsStream("mybatis.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
//		Reader reader = Resources.getResourceAsReader("mybatis.xml");
//		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void test() throws Exception {
		SqlSession session = sessionFactory.openSession();
		ProcessInfo info = session.selectOne("test.mybatis.getProcessMesg", "PC000000");
		LogUtil.info(new String(info.getProcessMesg().getBytes("ISO-8859-1"), "GB2312"));
		
		List<ProcessInfo> infos = session.selectList("test.mybatis.getProcessMesgs");
		LogUtil.info(infos);
	}
	
}
