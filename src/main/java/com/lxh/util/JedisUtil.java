package com.lxh.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * redis ���߶�ȡ������
 * @author Administrator
 *
 */
public class JedisUtil {
	/**
	 * Jedis ����
	 */
	private static Jedis jedis = null;
	private static String host = null;
	private static int port ;
	
	private static Jedis init() {
		if ( null == jedis ) {
			host = PropertiesUtil.getPropValue("redisHost").toString();
			port = Integer.parseInt(PropertiesUtil.getPropValue("redisPort").toString());
			jedis = new Jedis(host, port);
		}
		return jedis;
	}
	
	/**
	 * �ر�
	 */
	private static void close() {
		if ( jedis.isConnected() ) {
			jedis.close();
		}
	}
	
	/**
	 * �ж�Redis�Ƿ����ĳ��key
	 * @param key
	 * @return
	 */
	private static boolean judgeKeyIsExist(String key) {
		return jedis.exists(key);
	}
	
	public static void main(String[] args) {
		init();
		Map<String,String> map = jedis.hgetAll("rmiServer"); 
		Set<String> sets = map.keySet();
		Iterator<String> it = sets.iterator();
		String tmp = "";
		while ( it.hasNext() ) {
			tmp = it.next();
			System.out.println(tmp + " : " + map.get(tmp));
		}
		System.out.println(judgeKeyIsExist("rmiServer"));
		close();
	}
}
