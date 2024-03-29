package com.config.online.service.bean;

public class ResponseBean {

	private String serviceContextName;

	public ResponseBean() {
		super();
	}

	public ResponseBean(String serviceContextName, String status, String content) {
		super();
		this.serviceContextName = serviceContextName;
		this.status = status;
		this.content = content;
	}

	private String status;

	private String content;

	public String getServiceContextName() {
		return serviceContextName;
	}

	public void setServiceContextName(String serviceContextName) {
		this.serviceContextName = serviceContextName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}