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
		return processCode;
	}
	
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}
	
	public String getProcessMesg() {
		return processMesg;
	}
	
	public void setProcessMesg(String processMesg) {
		this.processMesg = processMesg;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof ProcessInfo)) {
			return false;
		}
		
		ProcessInfo info = (ProcessInfo) obj;
		if (processCode != null && processCode.equals(info.getProcessCode())) {
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		if (processCode == null) {
			return super.hashCode();
		}
		return processCode.hashCode() * 3;
	}

	@Override
	public String toString() {
		if (processMesg == null) {
			return super.toString();
		}
		return processMesg;
	}
	
}
