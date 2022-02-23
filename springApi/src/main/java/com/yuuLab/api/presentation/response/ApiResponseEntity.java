package com.yuuLab.api.presentation.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.yuuLab.api.app.utils.ApiHeaderUtil;

public class ApiResponseEntity<T> extends ResponseEntity<T> {

	protected ApiResponseEntity(HttpStatus status) {
		super(ApiHeaderUtil.getResponseHeaders(), status);
	}
	
	protected ApiResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
		super(ApiHeaderUtil.addResponseContentType(headers), status);
	}
	
	protected ApiResponseEntity(T body, HttpStatus status) {
		super(body, ApiHeaderUtil.getResponseHeaders(), status);
	}
	
	protected ApiResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, ApiHeaderUtil.addResponseContentType(headers), status);
	}
	
	public static <T> ApiResponseEntity<T> successGet(T response){
		return new ApiResponseEntity<T>(response, HttpStatus.OK);
	}
	
	public static <T> ApiResponseEntity<T> successPost(T response){
		return new ApiResponseEntity<T>(response, HttpStatus.CREATED);
	}
	
	public static <T> ApiResponseEntity<T> successPutOK(T response){
		return new ApiResponseEntity<T>(response, HttpStatus.OK);
	}
	
	public static <T> ApiResponseEntity<T> successPutCreated(T response){
		return new ApiResponseEntity<T>(response, HttpStatus.CREATED);
	}
	
	public static <T> ApiResponseEntity<T> successPutNoContent(T response){
		return new ApiResponseEntity<T>(response, HttpStatus.NO_CONTENT);
	}
	
	public static <T> ApiResponseEntity<T> successDeleteOK(T response){
		return new ApiResponseEntity<T>(response, HttpStatus.OK);
	}
	
	public static <T> ApiResponseEntity<T> successDeleteNoContent(){
		return new ApiResponseEntity<T>(HttpStatus.NO_CONTENT);
	}


}
