package com.lxh.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.lxh.util.DateUtil;

/**
 * 线程池4种
 * <1> newCachedThreadPool
 * <2> newFixedThreadPool
 * <3> newScheduledThreadPool: 定长线程池，支持定时及周期性任务执行。
 * <4> newSingleThreadExector
 * @author Administrator
 *
 */
public class ScheduledThreadPoolDemo {
	
	/**
	 * 延迟3s执行
	 * @param stp
	 */
	@SuppressWarnings("unused")
	private static void delayExecute(ScheduledThreadPoolExecutor stp){
		stp.schedule(new Runnable(){
			public void run() {
				System.out.println("延迟执行。。。。");
			}
		}, 3, TimeUnit.SECONDS);
	}
	
	/**
	 * 延迟一段时候，定时执行
	 * @param stp
	 */
	private static void delayExecuteRegularly(ScheduledThreadPoolExecutor stp){
		stp.scheduleAtFixedRate(new Runnable(){
			public void run() {
				System.out.println("延迟执行。。。。" + DateUtil.convertTimestampToDate(Long.parseLong(DateUtil.getNowStamp()),"yyyyMMdd HH:mm:ss"));
			}
		}, 3, 5, TimeUnit.SECONDS);
	}
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor es = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(3);
//		delayExecute(es);
		delayExecuteRegularly(es);
	}
	
}
