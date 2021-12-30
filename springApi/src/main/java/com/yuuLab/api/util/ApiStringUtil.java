package com.yuuLab.api.util;

public class ApiStringUtil {
	
	private ApiStringUtil () {
		// nothing
	}
	
	/**
	 * targetを指定桁数(numberOfDigits)で0埋めする。
	 * @param target 0埋め対象
	 * @param numberOfDigits 指定桁数
	 * @return 0埋めした文字列
	 */
	public static String fillDigitZero(int target, int numberOfDigits) {
		String pattern = "%0xd".replace("x", String.valueOf(numberOfDigits));
		return String.format(pattern, target);
	}
}
