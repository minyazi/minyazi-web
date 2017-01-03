package com.minyaziweb.domain;

import java.io.Serializable;

/**
 * 处理信息<br>
 * 
 * @author minyazi
 */
public class ProcessInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String processCode; // 处理码
	private String processMesg; // 处理信息
	
	public ProcessInfo() {
		
	}
	
	public ProcessInfo(String processCode) {
		this.processCode = processCode;
	}
	
	public String getProcessCode() {
		return this.processCode;
	}
	
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}
	
	public String getProcessMesg() {
		return this.processMesg;
	}
	
	public void setProcessMesg(String processMesg) {
		this.processMesg = processMesg;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof ProcessInfo)) {
			return false;
		}
		
		ProcessInfo other = (ProcessInfo) obj;
		return other.getProcessCode().equals(this.getProcessCode());
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + this.getProcessCode() == null ? 0 : this.getProcessCode().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return this.getProcessMesg() == null ? "" : this.getProcessMesg();
	}
	
}
