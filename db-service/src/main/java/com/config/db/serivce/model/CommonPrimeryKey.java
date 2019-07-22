package com.config.db.serivce.model;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class CommonPrimeryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	public CommonPrimeryKey() {
		super();
	}

	public CommonPrimeryKey(String serviceContextName, String status) {
		super();
		this.serviceContextName = serviceContextName;
		this.status = status;
	}

	@PrimaryKeyColumn(name = "SERVICE_CONTEXT_NAME", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String serviceContextName;

	@PrimaryKeyColumn(name = "STATUS", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String status;
	
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

}
