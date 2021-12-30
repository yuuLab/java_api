package com.yuuLab.api.exception.impl;

import com.yuuLab.api.constants.ApiErrorCode;
import com.yuuLab.api.exception.ApiErrorException;

import lombok.Getter;

@Getter
public class NotFoundException extends ApiErrorException {

	public NotFoundException(ApiErrorCode errorCode) {
		super(errorCode);
	} 

	
}
