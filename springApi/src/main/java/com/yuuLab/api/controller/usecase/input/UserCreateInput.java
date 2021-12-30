package com.yuuLab.api.controller.usecase.input;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCreateInput implements InputData {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;

}
