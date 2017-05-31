package com.minyazi.web.action;

import com.minyazi.web.base.BaseAction;

/**
 * 权限检查Action
 * 
 * @author minyazi
 */
public class AuthorityAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    
    private String username; // 用户名
    
    public AuthorityAction() {}
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String execute() throws Exception {
        if (session.get("Username") == null) {
            this.setUsername("");
        } else {
            this.setUsername((String) session.get("Username"));
        }
        return SUCCESS;
    }
}
