package com.yuuLab.api.domain.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuuLab.api.controller.usecase.UserCreateUseCase;
import com.yuuLab.api.controller.usecase.input.UserCreateInput;
import com.yuuLab.api.domain.entity.UserEntity;
import com.yuuLab.api.domain.repository.UserRepository;
import com.yuuLab.api.infrastructure.repository.UserIdGenerator;

@Service
@Transactional
public class UserCreateLogic implements UserCreateUseCase {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public String execute(UserCreateInput inputData) {
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
		return entity;
	}

}
