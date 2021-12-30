package com.yuuLab.api.exception;

import com.yuuLab.api.constants.ApiErrorCode;

import lombok.Getter;

@Getter
public class ApiErrorException extends RuntimeException {
	
	protected ApiErrorCode errorCode;

    public ApiErrorException(Throwable cause, ApiErrorCode errorCode) {
    	super(cause);
    	this.errorCode = errorCode;
    }
    
    public ApiErrorException(String message, ApiErrorCode errorCode) {
    	super(message);
    	this.errorCode = errorCode;
    }
    
    public ApiErrorException(String message, Throwable cause, ApiErrorCode errorCode) {
    	super(message, cause);
    	this.errorCode = errorCode;
    }
    
    public ApiErrorException(ApiErrorCode errorCode) {
    	this.errorCode = errorCode;
    }
}
