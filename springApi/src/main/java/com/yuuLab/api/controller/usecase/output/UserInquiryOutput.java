package com.yuuLab.api.controller.usecase.output;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInquiryOutput implements OutputData {
	
	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
}
