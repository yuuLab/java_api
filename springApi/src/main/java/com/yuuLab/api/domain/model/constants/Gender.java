package com.yuuLab.api.domain.model.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Gender {
	
	MALE("0"),
	
	FEMALE("1"),
	
	OTHER("2");
	
	private final String genderCode;
	
	private static final Map<String, Gender> VALUE_MAP =
			Collections.unmodifiableMap(createMap());
	
	private Gender(String genderCode){
		this.genderCode = genderCode;
	}
	
	private static Map<String, Gender> createMap() {
		Map<String, Gender> map = new HashMap<>();
		for (Gender type : Gender.values()) {
			map.put(type.getValue(), type);
		}
		return map;
	}
	
	
	public String getValue() {
		return this.genderCode;
	}
	
	public static Gender of(String value) {
		if (value == null) {
			return null;
		}
		return VALUE_MAP.get(value);
	}

}
