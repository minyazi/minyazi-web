package com.minyaziweb.interceptor;

import java.util.Map;

import com.minyaziutils.LogUtil;
import com.minyaziutils.PlatformException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 异常记录拦截器<br>
 * 
 * @author minyazi
 */
public class ExceptionInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 1L;
	
	public ExceptionInterceptor() {
		
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		String username = (String) session.get("Username");
		try {
			return invocation.invoke();
		} catch (Exception e) {
			StringBuilder log = new StringBuilder(500);
			log.append("【Exception】").append("（").append(username).append("）");
			log.append("（").append(invocation.getProxy().getNamespace()).append("/").append(invocation.getProxy().getActionName()).append("）");
			log.append(invocation.getAction().getClass().getName()).append(".").append(invocation.getProxy().getMethod()).append("()");
			LogUtil.error(log.toString());
			PlatformException pe = new PlatformException("系统运行异常：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
}
