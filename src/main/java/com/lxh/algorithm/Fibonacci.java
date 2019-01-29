package com.lxh.algorithm;

/**
 * 斐波那契数列
 * @author Administrator
 * 说明:
 * 标号: 0 1 2 3 4 5 6  7  8
 * 序列: 1 1 2 3 5 8 13 21 34  ... 
 */
public class Fibonacci {
	/**
	 * 根据"斐波那契数列位置获取该位置的值"
	 * @param n  斐波那契数列位置
	 * @return
	 */
	public static int getFibonacci(int n){
		if ( 0 > n ) {
			return 0;
		}
		if ( 0 == n || 1 == n) {
			return 1;
		}
		return getFibonacci(n-1) + getFibonacci(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(getFibonacci(-6));
		System.out.println(getFibonacci(2));
		System.out.println(getFibonacci(7));
		System.out.println(getFibonacci(80));
	}
}
