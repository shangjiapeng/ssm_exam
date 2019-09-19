package com.shang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理类
 */
public class DateUtils {
    /**
     * 日期转为字符串
     * @param date 要转换的日期
     * @param patt 抓换后的格式
     * @return
     */
    public static String dateToString(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 字符串转为日期
     * @param str
     * @param patt
     * @return
     */
    public static Date stringToDate(String str,String patt ) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date date = simpleDateFormat.parse(str);
        return date;
    }
}
