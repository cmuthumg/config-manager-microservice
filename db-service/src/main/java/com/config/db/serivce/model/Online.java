package com.config.db.serivce.model;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("ONLINE_CONFIG")
public class Online implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private CommonPrimeryKey primeryKey;

	@Column("CONTENT")
	private String content;

	public Online() {
		// Do nothing
	}

	public Online(String serviceContextName, String status, String content) {
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
