package com.lxh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池4种
 * <1> newCachedThreadPool
 * <2> newFixedThreadPool
 * <3> newScheduledThreadPool
 * <4> newSingleThreadExector
 * @author Administrator
 *
 */
public class CachedThreadPoolDemo {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for ( int i=0; i<10; i++ ) {
			final int index = i;
			try {
				Thread.sleep(index*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			es.execute(new Runnable() {
				public void run() {
					System.out.println();
				}
			});
		}
	}
}

