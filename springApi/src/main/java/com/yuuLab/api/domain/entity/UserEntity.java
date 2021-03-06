package com.yuuLab.api.domain.entity;

import com.yuuLab.api.domain.model.UserId;
import com.yuuLab.api.domain.model.constants.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
	
	private UserId userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
	private Gender gender;
}
