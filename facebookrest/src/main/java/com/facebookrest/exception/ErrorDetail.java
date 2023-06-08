package com.facebookrest.exception;

public class ErrorDetail {
	private String message;
	private String details;
	
	public ErrorDetail(String message,String details) {
		super();
		this.message=message;
		this.details=details;
		
	}
}
