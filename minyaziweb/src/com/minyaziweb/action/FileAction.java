package com.minyaziweb.action;

import java.io.File;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.minyaziutils.FileUtil;
import com.minyaziutils.LogUtil;
import com.minyaziutils.PlatformException;
import com.minyaziweb.base.BaseAction;

/**
 * 文件上传下载Action<br>
 * 
 * @author minyazi
 */
public class FileAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	private File upload; // 上传文件内容
	private String uploadFileName; // 上传文件名
	private String uploadContentType; // 上传文件类型
	private InputStream download; // 下载文件内容
	
	private String address;
	private String namespace;
	private String action;
	
	private String allowedTypes; // 允许上传的文件类型
	private Integer maximumSize; // 允许上传的文件最大大小
	
	public FileAction() {
		
	}
	
	public File getUpload() {
		return upload;
	}
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public String getUploadFileName() {
		return uploadFileName;
	}
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String getUploadContentType() {
		return uploadContentType;
	}
	
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	public InputStream getDownload() {
		return download;
	}
	
	public void setDownload(InputStream download) {
		this.download = download;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getAllowedTypes() {
		return allowedTypes;
	}
	
	public void setAllowedTypes(String allowedTypes) {
		this.allowedTypes = allowedTypes;
	}
	
	public Integer getMaximumSize() {
		return maximumSize;
	}
	
	public void setMaximumSize(Integer maximumSize) {
		this.maximumSize = maximumSize;
	}
	
	/**
	 * 上传文件时调用<br>
	 */
	public String upload() throws Exception {
		if (!this.checkFileType()) {
			this.setMessage("上传的文件类型不在（" + allowedTypes + "）范围内！");
			LogUtil.exception(new PlatformException(this.getMessage()));
			return ERROR;
		}
		if (!this.checkFileSize()) {
			this.setMessage("上传的文件大小不能超过" + maximumSize / 1024 / 1024 + "M！");
			LogUtil.exception(new PlatformException(this.getMessage()));
			return ERROR;
		}
		
		// 保存文件
		FileUtil.saveFile(upload, ServletActionContext.getServletContext().getRealPath("/"), uploadFileName);
		
		this.setNamespace(address.substring(0, address.lastIndexOf("/")));
		this.setAction(address.substring(address.lastIndexOf("/") + 1));
		
		return SUCCESS;
	}
	
	/**
	 * 下载文件时调用<br>
	 */
	public String download() throws Exception {
		this.setUploadFileName(new String(uploadFileName.getBytes(), "ISO-8859-1"));
		this.setDownload(ServletActionContext.getServletContext().getResourceAsStream("/" + uploadFileName));
		if (download == null) {
			this.setMessage("下载文件失败，文件不存在！");
			LogUtil.exception(new PlatformException(this.getMessage()));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除文件时调用<br>
	 */
	public String delete() throws Exception {
		// 删除文件
		FileUtil.deleteFile(ServletActionContext.getServletContext().getRealPath("/"), uploadFileName);
		
		this.setNamespace(address.substring(0, address.lastIndexOf("/")));
		this.setAction(address.substring(address.lastIndexOf("/") + 1));
		
		return SUCCESS;
	}
	
	/**
	 * 检查文件类型<br>
	 * 
	 * @return 检查通过返回true，否则返回false。
	 */
	public boolean checkFileType() {
		if (allowedTypes != null && !allowedTypes.equals("")) {
			String[] types = allowedTypes.split(",");
			for (String type : types) {
				if (type.equals(uploadContentType)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
	
	/**
	 * 检查文件大小<br>
	 * 
	 * @return 检查通过返回true，否则返回false。
	 */
	public boolean checkFileSize() {
		if (maximumSize != null && maximumSize > 0) {
			if (upload != null && upload.length() > maximumSize) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
	
}
