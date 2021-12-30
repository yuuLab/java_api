package com.yuuLab.api.exception;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yuuLab.api.constants.ApiErrorCode;
import com.yuuLab.api.controller.response.ApiErrorResponse;
import com.yuuLab.api.exception.impl.NotFoundException;


@RestControllerAdvice
public class ApiExceptionHandler {
	
	static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@ExceptionHandler({NotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorResponse  ApiErrorExeptionHandler(NotFoundException e) {
		LOGGER.info("NotFoundException", e);
		ApiErrorCode error = e.getErrorCode();
		ApiErrorResponse response = ApiErrorResponse.builder().build();
		if (Objects.nonNull(error)) {
			response = ApiErrorResponse.builder()
					.errorCode(error.getCode())
					.errorMessage(error.getMessage())
					.build();
		}
		return response;
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorResponse MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		LOGGER.info("Request Validation Error", e);
		ApiErrorCode error = ApiErrorCode.ERROR_CODE_700;
		return ApiErrorResponse.builder()
				.errorCode(error.getCode())
				.errorMessage(error.getMessage())
				.build();
	}
	
}
