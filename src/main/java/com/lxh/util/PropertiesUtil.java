package com.lxh.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	private static Properties prop = null;
	
	static {
		init();
	}
	
	private static void init () {
		if ( null == prop ) {
			prop = new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("src/main/resources/jdbc.properties");
				prop.load(fis);
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static Object getPropValue (String key) {
		Object res = null;
		if ( StringUtil.isNotBlank(key) ) {
			res = prop.getProperty(key);
			if ( null == res ) {
				throw new RuntimeException("get properties value failed ,key="+key+" not found ... ");
			}
			return res;
		}
		throw new NullPointerException("properties key is null or ''");
	}
	
}
