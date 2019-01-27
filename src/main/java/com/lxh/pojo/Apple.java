package com.lxh.pojo;

/**
 * 苹果类,实现克隆接口，演示深拷贝使用
 * @author Administrator
 *
 */
public class Apple implements Cloneable{
	/**
	 * 苹果名称
	 */
	private String name;
	/**
	 * 苹果重量
	 */
	private float weight;
	/**
	 * 苹果产地
	 */
	private String source;
	
	public Apple(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * 克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * 重写输出对象
	 */
	public String toString() {
		return "{" + "名称: " + this.name + ",重量: " + this.weight + ",产地:" + this.source + "}";
	}
}
