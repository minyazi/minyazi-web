package com.minyazi.web.action;

import com.minyazi.web.base.BaseAction;

/**
 * 系统退出Action
 * 
 * @author minyazi
 */
public class LogoutAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    
    public LogoutAction() {}
    
    /**
     * 系统退出时调用
     */
    @Override
    public String execute() throws Exception {
        session.remove("Username"); // 用户名
        return SUCCESS;
    }
}
