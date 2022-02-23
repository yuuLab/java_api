package com.yuuLab.api.app.exception.impl;

import com.yuuLab.api.app.constants.ApiErrorCode;
import com.yuuLab.api.app.exception.ApiErrorException;

import lombok.Getter;

@Getter
public class NotFoundException extends ApiErrorException {

	public NotFoundException(ApiErrorCode errorCode) {
		super(errorCode);
	} 

	
}
