package com.yuuLab.api.domain.model;

import org.apache.commons.lang3.StringUtils;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UserId {

	public UserId(String userId) {
		if (StringUtils.length(userId) != 17) {
			throw new IllegalArgumentException("ユーザーIDは17桁です。");
		}
		this.value = userId;
	}
	
	private String value;
}
