package com.lxh.util;
/**
 * 线程间通信----唤醒等待机制
 * @author Administrator
 *
 */
public class ThreadWaitAndNotifyDemo {
	
	public static void main(String[] args) {
		// 资源
		Resource res = new Resource();
		// 开始时无资源，需要先创建资源，设置标识
		res.setFlag(false);
		// 输入线程
		Thread inputThread = new Thread(new InputResource(res));
		// 输出线程
		Thread outputThread = new Thread(new OutputResource(res));
		// 设置线程名称
		inputThread.setName("【inputThread】");
		outputThread.setName("【outputThread】");
		// 启动线程
		inputThread.start();
		outputThread.start();
	}
	
}

/**
 * 资源类
 * @author Administrator
 *
 */
class Resource {
	private String name;
	private String manufacturer;
	private boolean flag;
	public Resource() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

/**
 * 资源输入类
 * @author Administrator
 *
 */
class InputResource implements Runnable{
	private Resource res;
	public InputResource(Resource res) {
		this.res = res;
	}
	
	public void run() {
		int tmpFlag = 0;
		while (true) {
			synchronized(res) {
				// 判断是否需要创建资源(为true时，不需要创建)
				if ( res.isFlag() ) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} 
				// 简单区分，资源填充
				if ( (tmpFlag % 2) == 0 ) {
					res.setName("煤炭");
					res.setManufacturer("大同");
					System.out.println(Thread.currentThread().getName() + " 创建资源 ：  " + res.getName() +" , "+ res.getManufacturer());
				}else {
					res.setName("gold");
					res.setManufacturer("Russion");
					System.out.println(Thread.currentThread().getName() + " 创建资源 ：  " + res.getName() +" , "+ res.getManufacturer());
				}
				// 标识资源创建完毕
				res.setFlag(true);
				// 唤醒资源消费者 消费资源
				res.notifyAll();
			
			}
			tmpFlag = ( tmpFlag + 1 ) % 2;
		}
	}
	
}

/**
 * 资源输出类
 * @author Administrator
 *
 */
class OutputResource implements Runnable{
	private Resource res;
	public OutputResource(Resource res) {
		this.res = res;
	}
	
	public void run() {
		while (true) {
			synchronized(res) {
				// 无资源时不可以消费  等待
				if ( !res.isFlag() ) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} 
				System.out.println(Thread.currentThread().getName() + "消费资源： "+res.getName() +" , " + res.getManufacturer());
				// 消费完毕标识资源
				res.setFlag(false);
				// 唤醒资源创建者  创建资源
				res.notifyAll();
			}
		}
	}
	
}
