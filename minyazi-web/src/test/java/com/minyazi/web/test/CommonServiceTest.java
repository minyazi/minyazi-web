package com.minyazi.web.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.minyazi.web.service.CommonService;

public class CommonServiceTest {
    private static ApplicationContext context;
    private static CommonService commonService;
    
    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext-springjdbc.xml");
        commonService = context.getBean("commonService", CommonService.class);
    }
    
    @Test
    public void test() {
        commonService.testTask();
    }
}
