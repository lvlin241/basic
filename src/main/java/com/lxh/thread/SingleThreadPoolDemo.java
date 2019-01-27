package com.lxh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lxh.util.DateUtil;

/**
 * 线程池4种
 * <1> newCachedThreadPool
 * <2> newFixedThreadPool
 * <3> newScheduledThreadPool
 * <4> newSingleThreadExector : 只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * @author Administrator
 *
 */
public class SingleThreadPoolDemo {
	
	public static void main(String[] args) {
		final ExecutorService es = Executors.newSingleThreadExecutor();
		for ( int i=0; i<10 ; i++ ){
			final int index = i;
			es.execute(new Runnable(){
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + " : " + index + " , " + DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						es.shutdown();
					}
				}
			});
		}
	}
	
}
