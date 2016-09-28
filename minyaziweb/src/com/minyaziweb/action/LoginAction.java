package com.minyaziweb.action;

import com.minyaziweb.base.BaseAction;

/**
 * 系统登录Action<br>
 * 
 * @author minyazi
 */
public class LoginAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	private String username; // 用户名
	private String password; // 密码
	
	public LoginAction() {
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 进入系统登录页面时调用<br>
	 */
	public String input() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 系统登录时调用<br>
	 */
	@Override
	public String execute() throws Exception {
		username = "minyazi";
		password = "123456";
		
		session.put("Username", username); // 用户名
		session.put("UserName", "敏伢子"); // 用户姓名
		
		return SUCCESS;
	}
	
}
