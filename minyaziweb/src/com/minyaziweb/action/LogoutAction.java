package com.minyaziweb.action;

import com.minyaziweb.base.BaseAction;

/**
 * 系统退出Action<br>
 * 
 * @author minyazi
 */
public class LogoutAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	public LogoutAction() {
		
	}
	
	/**
	 * 系统退出时调用<br>
	 */
	@Override
	public String execute() throws Exception {
		session.remove("Username"); // 用户名
		return SUCCESS;
	}
	
}
