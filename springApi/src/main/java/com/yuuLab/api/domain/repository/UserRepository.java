package com.yuuLab.api.domain.repository;

import java.util.Optional;

import com.yuuLab.api.domain.entity.UserEntity;



public interface UserRepository {
	
	void register(UserEntity entity);
	
	Optional<UserEntity> findById(String accountId);

}
