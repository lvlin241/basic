package com.lxh.algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * 二分法查找
 * @author lvlin
 *
 */
public class BinarySearch {
	
	/**
	 * 二分查找算法
	 * @param srcList
	 * @param key
	 * @return
	 */
	public static int binarySearch(List<Integer> srcList,Integer key) {
		if ( null == srcList || 0 == srcList.size() || null == key ){
			return -1;
		}
		int start = 0;
		int end = srcList.size() - 1;
		int mid = ( start + end ) / 2;
		int currentVal = srcList.get(mid);
		while ( start <= end ){
			if ( key > currentVal ){
				start = mid + 1;
			}
			
			if ( key < currentVal ){
				end = mid - 1;
			}
			
			if ( key == currentVal ){
				return mid;
			}
			
			mid = ( start + end ) / 2;
			currentVal = srcList.get(mid);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		List<Integer> res = new ArrayList<Integer>(5);
		res.add(3);
		res.add(7);
		res.add(13);
		res.add(17);
		res.add(25);
		res.add(34);
		res.add(443);
		System.out.println(binarySearch(res, -28));
		System.out.println(binarySearch(res, 13));
		System.out.println(binarySearch(res, 25));
		System.out.println(binarySearch(res, 180));
		System.out.println(binarySearch(res, 443));
	}
	
}
