package com.lxh.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lxh.pojo.Apple;
import com.lxh.util.ListUtil;
import com.lxh.util.ObjectCompareByProp;
import com.lxh.util.StringUtil;

/**
 * 深拷贝测试类
 * @author Administrator
 *
 */
public class Test {
	
	@org.junit.Test
	public void DeepCopy() throws CloneNotSupportedException{
		Apple a1 = new Apple();
		a1.setName("红富士");
		a1.setWeight(0.50f);
		a1.setSource("日本");
		Apple a2 = (Apple) a1.clone();
		a2.setName("烟台苹果");
		a2.setWeight(0.60f);
		a2.setSource("烟台");
		System.out.println("a1:\n" + a1);
		System.out.println("a2:\n" + a2);
		
	}
	
	@org.junit.Test
	public void sortListObjectByProp() throws CloneNotSupportedException{
		List<Apple> appleList = new ArrayList<Apple>(3);
		Apple a1 = new Apple();
		a1.setName("红富士");
		a1.setWeight(0.50f);
		a1.setSource("日本");
		Apple a2 = (Apple) a1.clone();
		a2.setName("烟台苹果");
		a2.setWeight(0.70f);
		a2.setSource("烟台");
		Apple a3 = (Apple) a1.clone();
		a3.setName("未知苹果");
		a3.setWeight(0.40f);
		a3.setSource("未知");
		appleList.add(a1);
		appleList.add(a2);
		appleList.add(a3);
		
		System.out.println("排序前");
		ListUtil.printList(appleList);
		Collections.sort(appleList, new ObjectCompareByProp());
		System.out.println("排序后");
		ListUtil.printList(appleList);
	}
	
	@org.junit.Test
	public static void splitStringByMutliBlank(){
		String kw1 = "hello wold";
		String[] res = StringUtil.splitByMutliBlank(kw1);
		for ( String s : res ){
			System.out.println(s);
		}
	}
	
}
