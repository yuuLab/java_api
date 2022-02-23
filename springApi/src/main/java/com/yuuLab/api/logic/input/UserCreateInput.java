package com.yuuLab.api.logic.input;

import com.yuuLab.api.domain.model.constants.Gender;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCreateInput implements InputData {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
	private Gender genderCode;

}
