package com.lxh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lxh.util.DateUtil;

/**
 * 线程池4种
 * <1> newCachedThreadPool
 * <2> newFixedThreadPool
 * <3> newScheduledThreadPool
 * <4> newSingleThreadExector
 * @author Administrator
 *
 */
public class FixedThreadPoolDemo {
	
	public static void main(String[] args) {
		final ExecutorService es = Executors.newFixedThreadPool(3);
		for ( int i=0; i<10; i++ ) {
			final int index = i;
			es.execute(new Runnable(){
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName()+":\t"+index + "\t" + DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
						Thread.sleep(1000);
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
