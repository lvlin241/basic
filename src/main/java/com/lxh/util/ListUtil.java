package com.lxh.util;

import java.util.List;

/**
 * List 工具类
 * @author Administrator
 *
 */
public class ListUtil {
	
	/**
	 * 打印列表
	 * @param list
	 */
	public static void printList (List<?> list){
		if ( null != list ){
			for ( Object obj : list ){
				System.out.println(obj.toString());
			}
		}
	}
}
