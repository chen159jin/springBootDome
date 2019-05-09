package com.jin.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Date处理方法
 *
 * @author Jin
 * @Title: DateUtil
 * @ProjectName
 * @Description: TODO
 * @date 2019/5/1/00114:49
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /**
     * Base ISO 8601 Date format yyyyMMdd i.e., 20021225 for the 25th day of December in the year 2002
     */
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";

    /**
     * Expanded ISO 8601 Date format yyyy-MM-dd i.e., 2002-12-25 for the 25th day of December in the year 2002
     */
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd hh:mm:ss
     */
    public static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_PATTERN = "yyyyMMddHHmmss";

    /**
     * 则个
     */
    private static boolean LENIENT_DATE = false;


    private static Random random = new Random();
    private static final int ID_BYTES = 10;


    /**
     * 格式转换 yyyy-MM-dd 到yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String dateTranslateFormat(String date) throws ParseException {
        return dateTranslateFormat(date, "yyyy-MM-dd", "yyyy年M月d日");
    }

    /**
     * 获取当前系统年份
     *
     * @return
     */
    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }


    /**
     * 格式转换 yyyy-MM-dd 到yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String dateTranslateFormat(String date, String fromStr) throws ParseException {
        return dateTranslateFormat(date, fromStr, "yyyy年M月d日");
    }

    /**
     * 格式转换 自定义格式
     *
     * @param date
     * @return
     */
    public static String dateTranslateFormat(String date, String fromStr, String toStr) throws ParseException {
        SimpleDateFormat myFormatter = new SimpleDateFormat(fromStr);
        SimpleDateFormat sdf = new SimpleDateFormat(toStr);
        String str = date;
        Date date1 = myFormatter.parse(date);
        str = sdf.format(date1);

        return str;
    }

    public static String dateTranslateFormat(Date date, String toStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(toStr);
        return sdf.format(date);
    }

    /**
     * 将字符串根据指定的格式转换成date格式输出
     *
     * @param date
     * @param fromStr
     * @return
     */
    public static Date dateTranslate(String date, String fromStr) {
        SimpleDateFormat myFormatter = new SimpleDateFormat(fromStr);
        String str = date;
        Date date1 = null;
        try {
            date1 = myFormatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * 出生日期处理
     *
     * @param idNumber
     * @return
     */
    public static Date getBirthday(String idNumber) {
        Date parse = null;
        String birthday = idNumber.substring(6, 14);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            parse = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }


    /**
     * java.util.Date
     *
     * @param dateText
     * @param format
     * @param lenient
     * @return
     */
    public static Date stringToDate(String dateText, String format,
                                    boolean lenient) {
        if (dateText == null) {
            return null;
        }
        DateFormat df = null;
        try {

            if (format == null) {
                df = new SimpleDateFormat();
            } else {
                df = new SimpleDateFormat(format);
            }
            df.setLenient(false);

            return df.parse(dateText);
        } catch (ParseException e) {

            return null;
        }
    }


    /**
     * java.util.Date
     *
     * @param format
     * @return
     */
    public static Date stringToDate(String dateString, String format) {

        return stringToDate(dateString, format, LENIENT_DATE);
    }

    /**
     * java.util.Date
     */
    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, ISO_EXPANDED_DATE_FORMAT, LENIENT_DATE);
    }

    /**
     * @param pattern
     * @param date
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
            sfDate.setLenient(false);
            return sfDate.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return dateToString(date, ISO_EXPANDED_DATE_FORMAT);
    }


    /**
     * @param date
     * @return string
     */
    public static String getYear(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(
                "yyyy");
        String cur_year = formater.format(date);
        return cur_year;
    }

    /**
     * @param date
     * @return string
     */
    public static String getMonth(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(
                "MM");
        String cur_month = formater.format(date);
        return cur_month;
    }

    /**
     * @param date
     * @return string
     */
    public static String getDay(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(
                "dd");
        String cur_day = formater.format(date);
        return cur_day;
    }

    /**
     * @param date
     * @return string
     */
    public static String getHour(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(
                "HH");
        String cur_day = formater.format(date);
        return cur_day;
    }

    public static int getMinsFromDate(Date dt) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        return ((hour * 60) + min);
    }


    /**
     * str1 -str2
     *
     * @param str1
     * @param str2
     * @return
     * @throws ParseException
     */
    public static int subDate(String str1, String str2) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        /*天数差*/
        Date fromDate1 = simpleFormat.parse(str1);
        Date toDate2 = simpleFormat.parse(str2);
        return subDate(fromDate1, toDate2);
    }

    public static int subDate(Date fromDate1, Date toDate2) {
        /*天数差*/
        long from1 = fromDate1.getTime();
        long to2 = toDate2.getTime();
        int days = (int) ((from1 - to2) / (1000 * 60 * 60 * 24));
        System.out.println("两个时间之间的天数差为：" + days);
        return days;
    }


    /**
     * 2017-06-24 12:05:01 to 二零一七年六月二十四日
     */
    @SuppressWarnings("deprecation")
    public static String transferDateZh(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String year = Integer.toString(cal.get(Calendar.YEAR));
        year = year.replaceAll("0", "〇")
                .replaceAll("1", "一")
                .replaceAll("2", "二")
                .replaceAll("3", "三")
                .replaceAll("4", "四")
                .replaceAll("5", "五")
                .replaceAll("6", "六")
                .replaceAll("7", "七")
                .replaceAll("8", "八")
                .replaceAll("9", "九");
        logger.debug("转换后" + year);
        int month = cal.get(Calendar.MONTH) + 1;
        String[] monthArray = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
        String monthStr = monthArray[month - 1];

        String[] dayArray = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八",
                "十九", "二十", "二十一", "二十二", "二十三", "二十四", "二十五", "二十六", "二十七", "二十八", "二十九", "三十", "三十一"};
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String dayStr = dayArray[day - 1];
        String result = year + "年" + monthStr + "月" + dayStr + "日";
        return result;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd");
        Date date = sdf.parse("2017年10月25日");

        String replaceAll = transferDateZh(date);
        System.out.println(replaceAll);
    }

}
