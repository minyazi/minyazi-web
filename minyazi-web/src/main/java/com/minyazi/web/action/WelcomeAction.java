package com.minyazi.web.action;

import com.minyazi.web.base.BaseAction;

/**
 * 欢迎页面Action
 * 
 * @author minyazi
 */
public class WelcomeAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    
    public WelcomeAction() {}
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
