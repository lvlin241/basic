package com.lxh.util;

public class StringUtil {
	
	public static boolean isNotBlank(String key) {
		if ( "".equals(key) || null == key )
			return false;
		return true;
	}
	
}
