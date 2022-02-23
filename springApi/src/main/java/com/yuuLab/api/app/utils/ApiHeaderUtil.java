package com.yuuLab.api.app.utils;

import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

public class ApiHeaderUtil {

	private ApiHeaderUtil(){
		// nothing
	}
	
	public static HttpHeaders getResponseHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	public static MultiValueMap<String, String> addResponseContentType(MultiValueMap<String, String> headers){
		if (Objects.isNull(headers)) {
			return null;
		}
		if (!headers.containsKey(HttpHeaders.CONTENT_TYPE)) {
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		}
		return headers;
	}
}
