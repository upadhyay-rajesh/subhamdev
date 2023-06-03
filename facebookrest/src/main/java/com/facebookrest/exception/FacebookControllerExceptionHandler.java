package com.facebookrest.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FacebookControllerExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleusernotfound(UserNotFoundException ex,HttpServletRequest request) {
		
		ExceptionResponse ee=new ExceptionResponse();
		ee.setErrorMessage(ex.getMessage());
		ee.setRequestURL(request.getRequestURI());
		
		return ee;
	}
	
	

}
