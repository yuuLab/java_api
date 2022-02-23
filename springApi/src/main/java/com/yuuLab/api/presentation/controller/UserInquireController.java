package com.yuuLab.api.presentation.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yuuLab.api.logic.input.UserInquiryInput;
import com.yuuLab.api.logic.output.UserInquiryOutput;
import com.yuuLab.api.logic.port.IUserInquiryLogic;
import com.yuuLab.api.presentation.response.ApiResponseEntity;
import com.yuuLab.api.presentation.response.UserInquiryResponse;

@RestController
public class UserInquireController {
	
	protected final IUserInquiryLogic userInquiryLogic;
	
	@Autowired
	public UserInquireController(IUserInquiryLogic userInquiryLogic) {
		this.userInquiryLogic = userInquiryLogic;
	}	
	
	@GetMapping(value="/user/{user_id}")
	@PreAuthorize("hasAuthority('ApiUser')")
	public ResponseEntity<UserInquiryResponse> inquireUser(@PathVariable("user_id") String userId) {
		
		UserInquiryInput input = UserInquiryInput.builder().userId(userId).build();
		UserInquiryOutput output = this.userInquiryLogic.inquire(input);
		
		UserInquiryResponse response = UserInquiryResponse.builder()
				.userId(output.getUserId().getValue())
				.firstName(output.getFirstName())
				.lastName(output.getLastName())
				.email(output.getEmail())
				.mobileNumber(output.getMobileNumber())
				.genderCode(Objects.nonNull(output.getGenderCode()) ? output.getGenderCode().getValue() : null)
				.build();
		
		return ApiResponseEntity.successGet(response);
	}
	
}
