package com.minyaziweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.minyaziutils.LogUtil;
import com.minyaziutils.PlatformException;

/**
 * HTTP请求模拟器<br>
 * 
 * @author minyazi
 */
public class HttpRequestSimulator {
	
	/**
	 * 模拟post请求<br>
	 * 
	 * @param urlStr 请求URL
	 * @param params 请求参数
	 * @return 返回响应信息。
	 */
	public static String doPost(String urlStr, Map<String, String> params) {
		try {
			// 建立连接
			URL url = new URL(urlStr);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// 传递参数
			/*
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "GB2312");
			writer.write("username=admin&password=123456");
			writer.flush();
			writer.close();
			*/
			if (params != null) {
				Set<String> keys = params.keySet();
				if (!keys.isEmpty()) {
					Iterator<String> iterator = keys.iterator();
					while (iterator.hasNext()) {
						connection.addRequestProperty(iterator.next(), params.get(iterator.next()));
					}
				}
			}
			
			// 获取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String temp = "";
			String response = "";
			while ((temp = reader.readLine()) != null) {
				response += temp + "\r\n";
			}
			return response;
		} catch (MalformedURLException e) {
			PlatformException pe = new PlatformException("模拟post请求出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		} catch (IOException e) {
			PlatformException pe = new PlatformException("模拟post请求出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
}
