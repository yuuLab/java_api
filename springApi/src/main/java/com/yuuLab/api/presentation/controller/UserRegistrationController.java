package com.yuuLab.api.presentation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuuLab.api.domain.model.UserId;
import com.yuuLab.api.domain.model.constants.Gender;
import com.yuuLab.api.logic.input.UserCreateInput;
import com.yuuLab.api.logic.port.IUserCreateLogic;
import com.yuuLab.api.presentation.request.UserCreateRequest;
import com.yuuLab.api.presentation.response.ApiResponseEntity;
import com.yuuLab.api.presentation.response.UesrCreateResponse;

@RestController
public class UserRegistrationController {
	
	protected final IUserCreateLogic userCreateLogic;
	
	@Autowired
	public UserRegistrationController(IUserCreateLogic userCreateLogic) {
		this.userCreateLogic = userCreateLogic;
	}


	@PostMapping(value="/user", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ApiUser')")
	public ResponseEntity<UesrCreateResponse> registerUser(@RequestBody @Valid UserCreateRequest request) {
		UserCreateInput input = UserCreateInput.builder()
				.firstName(request.getFirstName()) 
				.lastName(request.getLastName())
				.email(request.getEmail())
				.mobileNumber(request.getMobileNumber())
				.genderCode(Gender.of(request.getGenderCode()))
				.build();
		UserId userId = this.userCreateLogic.create(input);
		UesrCreateResponse response = UesrCreateResponse.builder().userId(userId.getValue()).build();
		return ApiResponseEntity.successPost(response);
	}
}
