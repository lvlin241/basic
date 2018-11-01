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
 * ���ڹ�����
 */
public class DateUtil {

    /**
     * ��ȡָ����ʽ������
     * @param pattern ���ڸ�ʽ
     * @return
     */
    private static String getCurrentDate(String pattern){
        LocalDateTime date = LocalDateTime.now();
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
	
	/**
	 * ���ʱ���
	 * @param :
	 * @return:
	 * @author: LXH
	 * @date:2018��9��21������2:20:48
	 */
	public static String getNowStamp(){
		return String.valueOf(Timestamp.valueOf(LocalDateTime.now()).getTime());
	}
	
	/**
	 * ��ȡ��ǰ����ǰһ�������
	 * @param preDayNum: ��ǰ����֮ǰ�ڼ���
	 * @return:
	 * @author: LXH
	 * @date:2018��9��26������5:24:36
	 */
	public static String getPrveDay(int preDayNum){
		String res = LocalDateTime.now().minusDays(preDayNum).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return res;
	}
	/**
	 * ��ȡ��������ǰ���������yyyyMMdd
	 * @param preDayNum: ��ǰ����֮ǰ�ڼ���
	 * @return:
	 * @author: LXH
	 * @date:2018��9��26������5:24:36
	 */
	public static String getPrveDay(String day,int preDayNum){
		String res = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyyMMdd")).minusDays(preDayNum).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return res;
	}
	
	/**
	 * ʱ���ת��Ϊʱ��
	 * @param:
	 * @return:
	 * @author: LXH
	 * @date:2018��9��28������11:15:56
	 */
	public static String convertTimestampToDate(long timeStamp,String timePattern){
		LocalDateTime ldt = LocalDateTime.ofEpochSecond(timeStamp/1000, 0, ZoneOffset.ofHours(8));
		return ldt.format(DateTimeFormatter.ofPattern(timePattern));
	}
	
	/**
	 * ��ȡ��ȡָ��ǰ����ǰһ�������
	 * @param:
	 * @return:
	 * @author: LXH
	 * @date:2018��9��30������4:48:30
	 */
	public static String getPrveDay(LocalDateTime ldt,int preDayNum){
		String res = ldt.minusDays(preDayNum).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return res;
	}
	
	/**
	 * ת��ʱ���ΪyyyyMMdd�ַ���
	 * @param timeStamp: ʱ���
	 * @return:
	 * @author: LXH
	 * @date:2018��10��12������7:43:33
	 */
	public static String convertTimestampToString(long timeStamp) {
		LocalDateTime ldt = convertTimeStampToLocalDateTime(timeStamp);
		return getPrveDay(ldt, 0);
	}
	
	/**
	 * ʱ���ת��ΪLocalDateTime
	 * @param:
	 * @return:
	 * @author: LXH
	 * @date:2018��9��30������4:46:40
	 */
	public static LocalDateTime convertTimeStampToLocalDateTime(long timeStamp){
		LocalDateTime ldt = LocalDateTime.ofEpochSecond(timeStamp/1000, 0, ZoneOffset.ofHours(8));
		return ldt;
	}
	
	/**
	 * ����ʱ���֮��ļ��
	 * @param start: ��ʼʱ���
	 * @param end: ����ʱ���
	 * @return:�������
	 * @author: LXH
	 * @date:2018��9��30������3:34:41
	 */
	public static long calculateIntervalOfDay(long start,long end){
		// Ĭ��ʱ��
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
