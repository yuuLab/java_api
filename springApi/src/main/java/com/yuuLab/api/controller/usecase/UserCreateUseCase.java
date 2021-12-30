package com.yuuLab.api.controller.usecase;

import com.yuuLab.api.controller.usecase.input.UserCreateInput;

public interface UserCreateUseCase {
	
	/**
	 * register user account.
	 * @param inputData UserCreateInput
	 * @return userId
	 */
	public String execute(UserCreateInput inputData);
	
}
