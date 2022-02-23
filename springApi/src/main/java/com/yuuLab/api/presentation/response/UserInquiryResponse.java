package com.yuuLab.api.presentation.response;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserInquiryResponse implements Serializable {

	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber; 
	
	private String genderCode;
}
