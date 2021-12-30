package com.yuuLab.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuuLab.api.controller.request.UserCreateRequest;
import com.yuuLab.api.controller.response.ApiResponseEntity;
import com.yuuLab.api.controller.response.UesrCreateResponse;
import com.yuuLab.api.controller.response.UserInquiryResponse;
import com.yuuLab.api.controller.usecase.UserCreateUseCase;
import com.yuuLab.api.controller.usecase.UserInquiryUseCase;
import com.yuuLab.api.controller.usecase.input.UserCreateInput;
import com.yuuLab.api.controller.usecase.input.UserInquiryInput;
import com.yuuLab.api.controller.usecase.output.UserInquiryOutput;

@RestController
public class UserAccountController {
	
	@Autowired
	protected UserInquiryUseCase userInquiry;
	
	@Autowired
	protected UserCreateUseCase userCreate;
	
	
	@GetMapping(value="/account/{user_id}")
	@PreAuthorize("hasAuthority('ApiUser')")
	public ResponseEntity<UserInquiryResponse> inquireUserAccount(@PathVariable("user_id") String userId) {
		
		UserInquiryInput input = UserInquiryInput.builder().userId(userId).build();
		UserInquiryOutput output = this.userInquiry.execute(input);
		
		UserInquiryResponse response = UserInquiryResponse.builder()
				.userId(output.getUserId())
				.firstName(output.getFirstName())
				.lastName(output.getLastName())
				.email(output.getEmail())
				.mobileNumber(output.getMobileNumber())
				.build();
		
		return ApiResponseEntity.successGet(response);

	}
	
	@PostMapping(value="/account", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ApiUser')")
	public ResponseEntity<UesrCreateResponse> createUserAccount(@RequestBody @Valid UserCreateRequest request) {
		UserCreateInput input = UserCreateInput.builder()
				.firstName(request.getFirstName()) 
				.lastName(request.getLastName())
				.email(request.getEmail())
				.mobileNumber(request.getMobileNumber())
				.build();
		String userId = this.userCreate.execute(input);
		UesrCreateResponse response = UesrCreateResponse.builder().userId(userId).build();
		return ApiResponseEntity.successPost(response);
	}
}
