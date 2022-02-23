package com.yuuLab.api.domain.port;

import java.util.Optional;

import com.yuuLab.api.domain.entity.UserEntity;




public interface IUserRepository {
	
	void register(UserEntity entity);
	
	Optional<UserEntity> findById(String accountId);

}
