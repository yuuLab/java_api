package com.yuuLab.api.logic.port;

import com.yuuLab.api.logic.input.UserInquiryInput;
import com.yuuLab.api.logic.output.UserInquiryOutput;

public interface IUserInquiryLogic {
	
	public UserInquiryOutput inquire(UserInquiryInput inputData);

}
