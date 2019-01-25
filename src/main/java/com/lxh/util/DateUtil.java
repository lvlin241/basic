package com.lxh.util;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 *  jdk:1.8
 * 日期工具类
 */
public class DateUtil {

    /**
     * 获取指定格式的日期
     * @param pattern 日期格式
     * @return
     */
    private static String getCurrentDate(String pattern){
        LocalDateTime date = LocalDateTime.now();
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
	
	/**
	 * 获得时间戳
	 * @param :
	 * @return:
	 * @author: LXH
	 * @date:2018年9月21日下午2:20:48
	 */
	public static String getNowStamp(){
		return String.valueOf(Timestamp.valueOf(LocalDateTime.now()).getTime());
	}
	
	/**
	 * 获取当前日期前一天的日期
	 * @param preDayNum: 当前日期之前第几天
	 * @return:
	 * @author: LXH
	 * @date:2018年9月26日下午5:24:36
	 */
	public static String getPrveDay(int preDayNum){
		String res = LocalDateTime.now().minusDays(preDayNum).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return res;
	}
	/**
	 * 获取给定日期前几天的日期yyyyMMdd
	 * @param preDayNum: 当前日期之前第几天
	 * @return:
	 * @author: LXH
	 * @date:2018年9月26日下午5:24:36
	 */
	public static String getPrveDay(String day,int preDayNum){
		String res = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyyMMdd")).minusDays(preDayNum).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return res;
	}
	
	/**
	 * 时间戳转化为时间
	 * @param:
	 * @return:
	 * @author: LXH
	 * @date:2018年9月28日上午11:15:56
	 */
	public static String convertTimestampToDate(long timeStamp,String timePattern){
		LocalDateTime ldt = LocalDateTime.ofEpochSecond(timeStamp/1000, 0, ZoneOffset.ofHours(8));
		return ldt.format(DateTimeFormatter.ofPattern(timePattern));
	}
	
	/**
	 * 获取获取指定前日期前一天的日期
	 * @param:
	 * @return:
	 * @author: LXH
	 * @date:2018年9月30日下午4:48:30
	 */
	public static String getPrveDay(LocalDateTime ldt,int preDayNum){
		String res = ldt.minusDays(preDayNum).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return res;
	}
	
	/**
	 * 转换时间戳为yyyyMMdd字符串
	 * @param timeStamp: 时间戳
	 * @return:
	 * @author: LXH
	 * @date:2018年10月12日下午7:43:33
	 */
	public static String convertTimestampToString(long timeStamp) {
		LocalDateTime ldt = convertTimeStampToLocalDateTime(timeStamp);
		return getPrveDay(ldt, 0);
	}
	
	/**
	 * 时间戳转换为LocalDateTime
	 * @param:
	 * @return:
	 * @author: LXH
	 * @date:2018年9月30日下午4:46:40
	 */
	public static LocalDateTime convertTimeStampToLocalDateTime(long timeStamp){
		LocalDateTime ldt = LocalDateTime.ofEpochSecond(timeStamp/1000, 0, ZoneOffset.ofHours(8));
		return ldt;
	}
	
	/**
	 * 计算时间戳之间的间隔
	 * @param start: 开始时间戳
	 * @param end: 结束时间戳
	 * @return:间隔天数
	 * @author: LXH
	 * @date:2018年9月30日下午3:34:41
	 */
	public static long calculateIntervalOfDay(long start,long end){
		// 默认时区
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime t1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(start), zone);
		LocalDateTime t2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(end), zone);
		Duration dur = Duration.between(t1, t2);
		long res = dur.toDays();
		return res;
	}

    public static void main(String[] args){
        String s = getCurrentDate("yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
    }

}
