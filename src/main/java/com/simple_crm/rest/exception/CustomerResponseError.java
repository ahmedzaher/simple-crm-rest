package com.simple_crm.rest.exception;

public class CustomerResponseError {
	private int status;
	private String message;
	private long time;
	
	public CustomerResponseError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.time = System.currentTimeMillis();
		
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
