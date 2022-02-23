package com.yuuLab.api.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuuLab.api.domain.entity.UserEntity;
import com.yuuLab.api.domain.model.UserId;
import com.yuuLab.api.domain.port.IUserRepository;
import com.yuuLab.api.domain.service.UserIdGenerator;
import com.yuuLab.api.logic.input.UserCreateInput;
import com.yuuLab.api.logic.port.IUserCreateLogic;

@Service
@Transactional
public class UserCreateLogic implements IUserCreateLogic {
	
	IUserRepository userRepository;
	
	@Autowired
	public UserCreateLogic(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	@Override
	public UserId create(UserCreateInput inputData) {
		UserEntity user = this.createUserEntity(inputData);
		this.userRepository.register(user);
		return user.getUserId();
	}
	
	
	private UserEntity createUserEntity(UserCreateInput inputData) {
		UserEntity entity = new UserEntity();
		entity.setUserId(UserIdGenerator.numberUserId());
		entity.setFirstName(inputData.getFirstName());
		entity.setLastName(inputData.getLastName());
		entity.setEmail(inputData.getEmail());
		entity.setMobileNumber(inputData.getMobileNumber());
		entity.setGender(inputData.getGenderCode());
		return entity;
	}

}
