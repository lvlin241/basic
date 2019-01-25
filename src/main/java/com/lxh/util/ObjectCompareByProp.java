package com.lxh.util;

import java.util.Comparator;

import com.lxh.pojo.Apple;

/**
 * 对象根据属性排序(以Apple类对象为例)
 * @author Administrator
 *
 */
public class ObjectCompareByProp implements Comparator<Apple> {

	public int compare(Apple o1, Apple o2) {
		if ( o1.getWeight() > o2.getWeight() )
			return 1;
		if ( o1.getWeight() < o2.getWeight() ) 
			return -1;
		return 0;
	}


}
