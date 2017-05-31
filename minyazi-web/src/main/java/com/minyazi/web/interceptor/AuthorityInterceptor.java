package com.minyazi.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限检查拦截器
 * 
 * @author minyazi
 */
public class AuthorityInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;
    
    public AuthorityInterceptor() {}
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext context = invocation.getInvocationContext();
        Map<String, Object> session = context.getSession();
        String username = (String) session.get("Username");
        if (username != null) {
            return invocation.invoke();
        }
        
        session.remove("Username"); // 用户名
        
        return Action.LOGIN;
    }
}
