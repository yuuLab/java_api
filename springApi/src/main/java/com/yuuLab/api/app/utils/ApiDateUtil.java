package com.yuuLab.api.app.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class ApiDateUtil {
	
	public static class Format {
		public static final String YYYYMMDDHHMMSS = "YYYYMMDDHHMMSS";
	}
	
	private ApiDateUtil() {
		// nothing
	}
	
	public static Date getCurrentDate() {
		return new Date();
	}
	
	/**
	 * 日付を指定の日付パターンでフォーマットする。
	 * @param date 変換対象日付 (java.util.Date)
	 * @param pattern 日付パターン <code> example : "YYYYMMDDHHMMSS") </code>
	 * @return 変換後文字列 (String)
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return DateFormatUtils.format(date, pattern);
	}
	
}
