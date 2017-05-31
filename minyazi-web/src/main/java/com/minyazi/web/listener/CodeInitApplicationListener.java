package com.minyazi.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.minyazi.core.util.CodeUtil;

/**
 * 应用监听器（初始化代码列表）
 * 
 * @author minyazi
 */
public class CodeInitApplicationListener implements ServletContextListener {
    public CodeInitApplicationListener() {}
    
    /**
     * 应用启动时调用
     */
    public void contextInitialized(ServletContextEvent sce) {
        // 初始化代码列表
        CodeUtil.init("code-config.xml");;
        
        ServletContext application = sce.getServletContext();
        application.setAttribute("CODES", CodeUtil.getCodes());
    }
    
    /**
     * 应用关闭时调用
     */
    public void contextDestroyed(ServletContextEvent sce) {}
}
