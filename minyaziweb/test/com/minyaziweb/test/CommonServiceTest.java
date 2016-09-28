package com.minyaziweb.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.minyaziutils.LogUtil;
import com.minyaziweb.domain.SqlInfo;
import com.minyaziweb.service.CommonService;

/**
 * 公共ServiceTest<br>
 * 
 * @author minyazi
 */
public class CommonServiceTest {
	
	private static ApplicationContext context;
	private static CommonService commonService;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		commonService = context.getBean("commonService", CommonService.class);
	}
	
	@Test
	public void test() {
		commonService.testTask();
		LogUtil.info(commonService.getDatas(new SqlInfo("select * from test")));
	}
	
}
