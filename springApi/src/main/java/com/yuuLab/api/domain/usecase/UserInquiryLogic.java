package com.yuuLab.api.domain.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuuLab.api.constants.ApiErrorCode;
import com.yuuLab.api.controller.usecase.UserInquiryUseCase;
import com.yuuLab.api.controller.usecase.input.UserInquiryInput;
import com.yuuLab.api.controller.usecase.output.UserInquiryOutput;
import com.yuuLab.api.domain.entity.UserEntity;
import com.yuuLab.api.domain.repository.UserRepository;
import com.yuuLab.api.exception.impl.NotFoundException;

@Service
@Transactional
public class UserInquiryLogic implements UserInquiryUseCase {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserInquiryOutput execute(UserInquiryInput inputData) {
		Optional<UserEntity> entityOpt = this.userRepository.findById(inputData.getUserId());
		UserInquiryOutput output;
		if (entityOpt.isPresent()) {
			UserEntity user = entityOpt.get();
			output = UserInquiryOutput.builder()
					.userId(user.getUserId())
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.email(user.getEmail())
					.mobileNumber(user.getMobileNumber())
					.build();
		} else {
			throw new NotFoundException(ApiErrorCode.ERROR_CODE_001);
		}
		return output;
	}
	

} 
