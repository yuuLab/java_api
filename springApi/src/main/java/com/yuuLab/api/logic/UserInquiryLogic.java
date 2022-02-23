package com.yuuLab.api.logic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuuLab.api.app.constants.ApiErrorCode;
import com.yuuLab.api.app.exception.impl.NotFoundException;
import com.yuuLab.api.domain.entity.UserEntity;
import com.yuuLab.api.domain.port.IUserRepository;
import com.yuuLab.api.logic.input.UserInquiryInput;
import com.yuuLab.api.logic.output.UserInquiryOutput;
import com.yuuLab.api.logic.port.IUserInquiryLogic;

@Service
@Transactional
public class UserInquiryLogic implements IUserInquiryLogic {
	
	protected final IUserRepository userRepository;
	
	@Autowired
	public UserInquiryLogic(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Override
	public UserInquiryOutput inquire(UserInquiryInput inputData) {
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
					.genderCode(user.getGender())
					.build();
		} else {
			throw new NotFoundException(ApiErrorCode.ERROR_CODE_001);
		}
		return output;
	}
	

} 
