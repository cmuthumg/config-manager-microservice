package com.config.db.serivce.exception;

public class RecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private String message;
	
	public RecordNotFoundException(String message) {
		this.message= message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
