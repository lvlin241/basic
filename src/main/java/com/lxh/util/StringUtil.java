package com.lxh.util;

/**
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtil {
	
	/**
	 * 判断(当前字符串)是否为空
	 * @param key
	 * @return
	 */
	public static boolean isNotBlank(String key) {
		if ( "".equals(key) || null == key )
			return false;
		return true;
	}
	
	/**
	 * 判断字符串是否为空
	 * @param key
	 * @return
	 */
	public static boolean isBlank(String key) {
		return null==key||"".equals(key) ? true : false ;
	}
	
	
	/**
	 * 根据关键字之间的空格分割(常用于   检索内容  分割)
	 * @param keywords
	 * @return
	 */
	public static String[] splitByMutliBlank(String keywords){
		if ( isNotBlank(keywords) ){
			String[] res = null;
			res = keywords.split("\\s+");
			return res;
		}
		return null;
	}
	
}
