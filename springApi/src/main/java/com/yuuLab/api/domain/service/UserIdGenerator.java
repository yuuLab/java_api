package com.yuuLab.api.domain.service;

import java.util.concurrent.atomic.AtomicInteger;

import com.yuuLab.api.app.utils.ApiDateUtil;
import com.yuuLab.api.app.utils.ApiDateUtil.Format;
import com.yuuLab.api.app.utils.ApiStringUtil;
import com.yuuLab.api.domain.model.UserId;

/**
 * userIdを生成する。
 * 実際にはプロジェクトに合わせた採番処理を実施する。
 * @author yuuLab
 *
 */
public class UserIdGenerator {
	
	private static final AtomicInteger cnt = new AtomicInteger(0);
	
	private static final int max = 999;
	
	private static int getIncrementedValue() {
		return cnt.getAndUpdate(prev -> prev < max ? prev + 1 : 0);
	}
	
	/**
	 * userIdを採番する。なお、今回userIdは"日時+連番三桁”とする。
	 * @return userId
	 */
	public static UserId numberUserId() {
		StringBuilder sb = new StringBuilder();
		String dateStr = ApiDateUtil.format(ApiDateUtil.getCurrentDate(), Format.YYYYMMDDHHMMSS);
		sb.append(dateStr);
		sb.append(ApiStringUtil.fillDigitZero(getIncrementedValue(), 3));
		return new UserId(sb.toString());
	}

}
