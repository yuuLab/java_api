package com.yuuLab.api.infrastructure.repository;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.yuuLab.api.domain.entity.UserEntity;
import com.yuuLab.api.domain.port.IUserRepository;

@Component
public class UserRepository implements IUserRepository {
	
	/**
	 * 一時的にユーザーデータをオンメモリで保持する。
	 * 実際にはデータベースにアクセスして書き込みや読み取り処理を実施する。
	 */
	private static HashMap<String, UserEntity> userData = new HashMap<String, UserEntity>();

	@Override
	public void register(UserEntity entity) {
		userData.put(entity.getUserId().getValue(), entity);
	}

	@Override
	public Optional<UserEntity> findById(String userId) {
		return Optional.ofNullable(userData.get(userId));
	}

}
