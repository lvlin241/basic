package com.lxh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 创建线程3种形式 
 * 1、继承 Thread 类
 * 2、实现 Runnable 接口   
 * 3、实现 Callable 接口   
 * 区别：
 * 1、简单，但只能继承一个类
 * 2、可实现多个接口，实现run方法，但无返回结果且不能抛出异常
 * 3、可实现多个接口，实现call方法，有返回结果，可以操作线程
 */
public class ThreadImplDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		CreateThreadDemo ctd = new CreateThreadDemo();
		FutureTask<String> ft1 = new FutureTask<String>(ctd);
		FutureTask<String> ft2 = new FutureTask<String>(ctd);
		FutureTask<String> ft3 = new FutureTask<String>(ctd);
		FutureTask<String> ft4 = new FutureTask<String>(ctd);
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.submit(ft1);
		es.submit(ft2);
		es.submit(ft3);
		es.submit(ft4);
		
		try {
			// 当前线程等待10s后，判断4个线程是否执行执行完成，完成则关闭
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if ( ft1.isDone() && ft2.isDone() && ft3.isDone() && ft4.isDone() ) {
				System.out.println("over");
				es.shutdown();
				return;
			}
		}
	}

}

class CreateThreadDemo implements Callable{
	private int count = 0;
	public String call() throws Exception {
		String res = Thread.currentThread().getName() + "...execute..." + count++;
		System.out.println( res );
		return res;
	}

}
