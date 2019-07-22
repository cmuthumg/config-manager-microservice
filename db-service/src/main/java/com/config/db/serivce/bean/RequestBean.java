package com.config.db.serivce.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RequestBean {

	@NotNull
	private String serviceContextName;

	public RequestBean() {
		super();
	}

	public RequestBean(String serviceContextName, String status, String content) {
		super();
		this.serviceContextName = serviceContextName;
		this.status = status;
		this.content = content;
	}

	@NotNull
	@Pattern(regexp = "active|not-active", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String status;

	@NotNull
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
