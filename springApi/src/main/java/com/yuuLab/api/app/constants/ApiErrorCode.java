package com.yuuLab.api.app.constants;

import lombok.Getter;

@Getter
public enum ApiErrorCode {
	
	ERROR_CODE_001("E000001", "会員が存在しません。"),
	
	ERROR_CODE_700("E000700", "リクエストパラメータに誤りがあります。確認してください。");
	
	private String code;
	
	private String message;
	
	ApiErrorCode(String code, String message){
		this.code = code;
		this.message = message;
	}

}
