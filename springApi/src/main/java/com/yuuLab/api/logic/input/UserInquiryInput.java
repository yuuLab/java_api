package com.yuuLab.api.logic.input;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInquiryInput implements InputData {
	
	String userId;

}
