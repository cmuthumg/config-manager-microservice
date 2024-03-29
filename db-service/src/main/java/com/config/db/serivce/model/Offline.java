package com.config.db.serivce.model;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("OFFLINE_CONFIG")
public class Offline implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private CommonPrimeryKey primeryKey;

	@Column("CONTENT")
	private String content;

	public Offline() {
		// Do nothing
	}

	public Offline(String serviceContextName, String status, String content) {
		super();
		primeryKey = new CommonPrimeryKey(serviceContextName, status);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommonPrimeryKey getPrimeryKey() {
		return primeryKey;
	}

	public void setPrimeryKey(CommonPrimeryKey primeryKey) {
		this.primeryKey = primeryKey;
	}
}
