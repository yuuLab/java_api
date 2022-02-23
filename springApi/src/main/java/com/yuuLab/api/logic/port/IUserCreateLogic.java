package com.yuuLab.api.logic.port;

import com.yuuLab.api.domain.model.UserId;
import com.yuuLab.api.logic.input.UserCreateInput;

public interface IUserCreateLogic {
	
	/**
	 * register user account.
	 * @param inputData UserCreateInput
	 * @return userId
	 */
	public UserId create(UserCreateInput inputData);
	
}
