package com.minyaziweb.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.minyaziutils.LogUtil;
import com.minyaziweb.HttpRequestSimulator;

/**
 * 代码工具类Test<br>
 * 
 * @author minyazi
 */
public class HttpRequestSimulatorTest {
	
	@Test
	public void testInit() {
		String urlStr = "http://58.67.194.193:8080/cnapstst/cnapstst/jsp/login.jsp";
//		String urlStr = "http://58.67.194.193:8080/cnapstst/controller?txcode=TX1010101";
		Map<String, String> params = new HashMap<String, String>();
//		params.put("Test", "测试");
		LogUtil.info(HttpRequestSimulator.doPost(urlStr, params));
	}
	
}
