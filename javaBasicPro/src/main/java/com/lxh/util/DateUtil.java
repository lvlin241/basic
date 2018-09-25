package com.lxh.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  jdk:1.8
 * 日期工具类
 */
public class DateUtil {

    private static String getCurrentDate(String pattern){
        LocalDateTime date = LocalDateTime.now();
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static void main(String[] args){
        String s = getCurrentDate("yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
    }

}
