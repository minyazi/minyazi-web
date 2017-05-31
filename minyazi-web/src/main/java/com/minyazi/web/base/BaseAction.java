package com.minyazi.web.base;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.minyazi.core.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础Action
 * 
 * @author minyazi
 */
public abstract class BaseAction extends ActionSupport implements ApplicationAware, SessionAware, RequestAware {
    private static final long serialVersionUID = 1L;
    
    public Map<String, Object> application;
    public Map<String, Object> session;
    public Map<String, Object> request;
    
    private String token; // 令牌
    private String message; // 提示信息
    
    public BaseAction() {}
    
    /**
     * Struts2依赖注入
     */
    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }
    
    /**
     * Struts2依赖注入
     */
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
        
        ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
        StringBuilder log = new StringBuilder(500);
        log.append("【Action】").append("（").append(session.get("Username")).append("）");
        log.append("（").append(invocation.getProxy().getNamespace()).append("/").append(invocation.getProxy().getActionName()).append("）");
        log.append(invocation.getAction().getClass().getName()).append(".").append(invocation.getProxy().getMethod()).append("()");
        LogUtil.info(log.toString());
    }
    
    /**
     * Struts2依赖注入
     */
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
