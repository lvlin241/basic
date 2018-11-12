package com.lxh.util;

/**
 * 线程死锁示例
 * 死锁前提：同步代码块中嵌套同步代码块并且同步锁标识不一致
 * @author Administrator
 *
 */
public class DeadLockDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunableImpl(true));
		Thread t2 = new Thread(new RunableImpl(false));
		t1.start();
		t2.start();
	}
}

class RunableImpl implements Runnable{
	// 执行标识
	private boolean flag;
	
	public RunableImpl(boolean flag){
		this.flag = flag;
	}
	
	public void run() {
		if ( flag ) {
			while (true) {
				synchronized (LockObject.lo1) {
					System.out.println("if lo1");
					synchronized (LockObject.lo2) {
						System.out.println("if lo2");
					}
				}
			}
		} else {
			while (true) {
				synchronized (LockObject.lo2) {
					System.out.println("else lo2");
					synchronized (LockObject.lo1) {
						System.out.println("else lo1");
					}
				}
			}	

		}
	}
}

class LockObject {
	/**
	 * 创建两个静态锁对象，便于调用
	 */
	public static LockObject lo1 = new LockObject();
	public static LockObject lo2 = new LockObject();
	public LockObject () {
		
	}
}