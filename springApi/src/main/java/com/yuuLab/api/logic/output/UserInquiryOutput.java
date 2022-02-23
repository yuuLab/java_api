package com.yuuLab.api.logic.output;

import com.yuuLab.api.domain.model.UserId;
import com.yuuLab.api.domain.model.constants.Gender;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInquiryOutput implements OutputData {
	
	private UserId userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
	private Gender genderCode;
	
}
