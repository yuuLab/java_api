package com.yuuLab.api.controller.usecase;

import com.yuuLab.api.controller.usecase.input.UserInquiryInput;
import com.yuuLab.api.controller.usecase.output.UserInquiryOutput;

public interface UserInquiryUseCase {
	
	public UserInquiryOutput execute(UserInquiryInput inputData);

}
