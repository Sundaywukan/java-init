package cc.innosoft.thirdchat.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 时间工具类
 *
 */
public class DateUtil {

	private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);
	
	/** 格式 ：yyyy-MM-dd HH:mm:ss */
	public static final String DATEFORMAT_STR_001 = "yyyy-MM-dd HH:mm:ss";
	/** 格式 ：yyyy-MM-dd */
	public static final String DATEFORMAT_STR_002 = "yyyy-MM-dd";
	/** 格式 ：MM-dd */
	public static final String DATEFORMAT_STR_003 = "MM-dd";
	/** 格式 ：HH:mm:ss */
	public static final String DATEFORMAT_STR_004 = "HH:mm:ss";

	/** 格式 ：yyyyMMddHHmmss */
	public static final String DATEFORMAT_STR_011 = "yyyyMMddHHmmss";
	/** 格式 ：yyyyMMdd */
	public static final String DATEFORMAT_STR_012 = "yyyyMMdd";

	/** 格式 ：yyyy年MM月dd日 HH时mm分ss秒 */
	public static final String DATEFORMAT_STR_021 = "yyyy年MM月dd日 HH时mm分ss秒";
	/** 格式 ：yyyy年MM月dd日 */
	public static final String DATEFORMAT_STR_022 = "yyyy年MM月dd日";
	/** 格式 ：MM月dd日 hh:mm */
	public static final String DATEFORMAT_STR_023 = "MM月dd日 hh:mm";

	/**
	 * 获得当前日期
	 * 
	 */
	public static Date getNow() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 日期转换为字符串 格式自定义
	 * 
	 * @param date
	 * @param f
	 */
	public static String dateStr(Date date, String f) {
		SimpleDateFormat format = new SimpleDateFormat(f);
		return format.format(date);
	}

	/**
	 * 日期转换为字符串 MM月dd日 hh:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr(Date date) {
		return dateStr(date, DATEFORMAT_STR_023);
	}

	/**
	 * 日期转换为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr2(Date date) {
		return dateStr(date, DATEFORMAT_STR_002);
	}

	/**
	 * yyyy年MM月dd日HH时mm分ss秒
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr5(Date date) {
		return dateStr(date, DATEFORMAT_STR_021);
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr3(Date date) {
		return dateStr(date, DATEFORMAT_STR_011);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr4(Date date) {
		return dateStr(date, DATEFORMAT_STR_001);

	}

	/**
	 * yyyy年MM月dd日
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr6(Date date) {
		return dateStr(date, DATEFORMAT_STR_022);
	}

	/**
	 * yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr7(Date date) {
		return dateStr(date, DATEFORMAT_STR_012);
	}

	/**
	 * MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr8(Date date) {
		return dateStr(date, DATEFORMAT_STR_003);
	}

	/**
	 * 将时间戳转换为Date
	 * 
	 * @param times
	 * @return
	 */
	public static Date getDate(String times) {
		long time = Long.parseLong(times);
		return new Date(time * 1000);
	}

	public static String dateStr(String times) {
		return dateStr(getDate(times));
	}

	public static String dateStr2(String times) {
		return dateStr2(getDate(times));
	}

	public static String dateStr3(String times) {
		return dateStr3(getDate(times));
	}

	public static String dateStr4(String times) {
		return dateStr4(getDate(times));
	}

	public static String dateStr5(String times) {
		return dateStr5(getDate(times));
	}

	/**
	 * 将Date转换为时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static long getTime(Date date) {
		return date.getTime() / 1000;
	}

	public static int getDay(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 默认的valueOf 方法，格式化 yyyy-mm-dd HH:mm:ss
	 * 
	 * @param str 格式 yyyy-mm-dd
	 * @return
	 */
	public static Date valueOf(String str) {
		str += " 00:00:00";
		return valueOf(str, DATEFORMAT_STR_001);
	}
	
	/**
	 * 23:59:59转换
	 * @param str
	 * @return
	 */
	public static Date valueOfLast(String str) {
		str += " 23:59:59";
		return valueOf(str, DATEFORMAT_STR_001);
	}

	/**
	 * 
	 * 自定义format格式化字符串为date
	 * 
	 * @param str
	 *            要格式化的字符串
	 * @param dateFormatStr
	 * @return
	 */
	public static Date valueOf(String str, String dateFormatStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormatStr);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(str, pos);
	}

	/**
	 * @author lijie
	 * @param begin
	 * @param end
	 *            传入开始时间 和 结束时间 格式如：2012-09-07
	 * @return 返回Map 获取相隔多少年 get("YEAR")及为俩个时间年只差，月 天，类推 Key ： YEAR MONTH DAY
	 *         如果开始时间 晚于 结束时间 return null；
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getApartTime(String begin, String end) {
		String[] temp = begin.split("-");
		String[] temp2 = end.split("-");
		if (temp.length > 1 && temp2.length > 1) {
			Calendar ends = Calendar.getInstance();
			Calendar begins = Calendar.getInstance();

			begins.set(StringUtil.toInt(temp[0]), StringUtil.toInt(temp[1]),
					StringUtil.toInt(temp[2]));
			ends.set(StringUtil.toInt(temp2[0]), StringUtil.toInt(temp2[1]),
					StringUtil.toInt(temp2[2]));
			if (begins.compareTo(ends) < 0) {
				Map map = new HashMap();
				ends.add(Calendar.YEAR, -StringUtil.toInt(temp[0]));
				ends.add(Calendar.MONTH, -StringUtil.toInt(temp[1]));
				ends.add(Calendar.DATE, -StringUtil.toInt(temp[2]));
				map.put("YEAR", ends.get(Calendar.YEAR));
				map.put("MONTH", ends.get(Calendar.MONTH) + 1);
				map.put("DAY", ends.get(Calendar.DATE));
				return map;
			}
		}
		return null;
	}

	/**
	 * 前/后?分钟
	 * 
	 * @param d
	 * @param minute
	 * @return
	 */
	public static Date rollMinute(Date d, int minute) {
		return new Date(d.getTime() + minute * 60 * 1000);
	}

	/**
	 * 前/后?天
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date rollDay(Date d, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 前/后?月
	 * 
	 * @param d
	 * @param mon
	 * @return
	 */
	public static Date rollMon(Date d, int mon) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, mon);
		return cal.getTime();
	}

	/**
	 * 前/后?年
	 * 
	 * @param d
	 * @param year
	 * @return
	 */
	public static Date rollYear(Date d, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	public static Date rollDate(Date d, int year, int mon, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, mon);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 获取当前时间-时间戳字符串
	 * 
	 * @return
	 */
	public static String getNowTimeStr() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	/**
	 * 将Date转换为时间戳
	 * 
	 * @param time
	 * @return
	 */
	public static String getTimeStr(Date time) {
		long date = time.getTime();
		return Long.toString(date / 1000);
	}

	public static String getTimeStr(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			LOG.error("getTimeStr ParseException", e);
			return "";
		}
		return DateUtil.getTimeStr(date);
	}

	public static String rollMonth(Date addTime, String timeLimit) {
		Date t = DateUtil.rollDate(addTime, 0, StringUtil.toInt(timeLimit), 0);
		return t.getTime() / 1000 + "";
	}

	public static String rollDay(Date addTime, String timeLimitDay) {
		Date t = DateUtil.rollDate(addTime, 0, 0,
				StringUtil.toInt(timeLimitDay));
		return t.getTime() / 1000 + "";
	}

	public static Date getIntegralTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastIntegralTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastSecIntegralTime(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(d.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static long getTime(String format) {
		long t = 0;
		if (StringUtil.isBlank(format))
			return t;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(format);
			t = date.getTime() / 1000;
		} catch (ParseException e) {
			LOG.debug("getTime ParseException", e);
		}
		return t;
	}

	// 获取本周日的日期
	public static String getCurrentWeekday() {
		int mondayPlus = DateUtil.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		return df.format(monday);
	}

	// 获得当前日期与本周日相差的天数
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	// 获得本周一的日期
	public static String getMondayOFWeek() {
		int mondayPlus = DateUtil.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		return df.format(monday);
	}

	// 获取当前月第一天：
	public static String getFirstDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return format.format(c.getTime());
	}

	// 获取当月最后一天
	public static String getLastDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		return format.format(ca.getTime());
	}

	/**
	 * 日期月份处理
	 * 
	 * @param d
	 *            时间
	 * @param month
	 *            相加的月份，正数则加，负数则减
	 * @return
	 */
	public static Date timeMonthManage(Date d, int month) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(d);
		rightNow.add(Calendar.MONTH, month);
		return rightNow.getTime();
	}

	/**
	 * 获取指定年月的最后一天
	 * 
	 * @param yearTime
	 *            指定年
	 * @param monthTime
	 *            指定月
	 * @return
	 */
	public static Date monthLastDay(int yearTime, int monthTime) {
		Calendar cal = Calendar.getInstance();
		cal.set(yearTime, monthTime, 0, 23, 59, 59);
		return cal.getTime();
	}

	/**
	 * 获取指定年月的第一天
	 * 
	 * @param year_time
	 *            指定年
	 * @param month_time
	 *            指定月
	 * @return
	 */
	public static Date monthFirstDay(int year_time, int month_time) {
		Calendar cal = Calendar.getInstance();
		cal.set(year_time, month_time - 1, 1, 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定时间月的第一天
	 * 
	 * @param d
	 *            指定时间，为空代表当前时间
	 * @return
	 */
	public static Date currMonthFirstDay(Date d) {
		Calendar cal = Calendar.getInstance();
		if (d != null)
			cal.setTime(d);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE), 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定时间月的最后一天
	 * 
	 * @param d
	 *            指定时间，为空代表当前时间
	 * @return
	 */
	public static Date currMonthLastDay(Date d) {
		Calendar cal = Calendar.getInstance();
		if (d != null)
			cal.setTime(d);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE), 23, 59, 59);
		return cal.getTime();
	}

	/**
	 * 获取指定时间的年
	 * 
	 * @param date
	 *            指定时间
	 * @return
	 */
	public static int getTimeYear(Date date) {
		if (date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取指定时间的月
	 * 
	 * @param date
	 *            指定时间
	 * @return
	 */
	public static int getTimeMonth(Date date) {
		if (date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取指定时间的天
	 * 
	 * @param date
	 *            指定时间
	 * @return
	 */
	public static int getTimeDay(Date date) {
		if (date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}

	public static Date getFirstSecIntegralTime(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(d.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.DATE, 0);
		return cal.getTime();
	}

	/**
	 * 
	 * 指定天数 d + day天后的结束时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date rollDayEndTime(Date d, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE), 23, 59, 59);
		return cal.getTime();
	}
		
	/**
	 * 
	 * 指定天数 d + day天后的开始时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date rollDayStartTime(Date d, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE), 00, 00, 00);
		return cal.getTime();
	}
	
	
	/**
	 * 获取指定时间天的结束时间
	 * 
	 * @param d
	 * @return
	 */
	public static Date getDayEndTime(long d) {
		Date day = null;
		if (d <= 0) {
			day = new Date();
		} else {
			day = new Date(d * 1000);
		}
		Calendar cal = Calendar.getInstance();
		if (day != null) {
			cal.setTimeInMillis(day.getTime());
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE), 23, 59, 59);
		return cal.getTime();
	}

	/**
	 * 获取指定时间天的开始时间
	 * 
	 * @param d
	 * @return
	 */
	public static Date getDayStartTime(long d) {
		Date day = null;
		if (d <= 0) {
			day = new Date();
		} else {
			day = new Date(d * 1000);
		}
		Calendar cal = Calendar.getInstance();
		if (day != null) {
			cal.setTimeInMillis(day.getTime());
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE), 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取19位的格式时间
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateByFullDateStr(String dateStr) {
		if (StringUtil.isBlank(dateStr)) {
			return null;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		DateFormat sdf = new SimpleDateFormat(DATEFORMAT_STR_012);
		Calendar cal = Calendar.getInstance();
		try {
			Date d1 = sdf.parse(DateUtil.dateStr7(date1));
			Date d2 = sdf.parse(DateUtil.dateStr7(date2));
			cal.setTime(d1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(d2);
			long time2 = cal.getTimeInMillis();
			return Integer
					.parseInt(String.valueOf((time2 - time1) / 86400000L));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 获取两个日期之间月数
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(Date date1, Date date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        
        c1.setTime(sdf.parse(DateUtil.dateStr4(date1)));
        c2.setTime(sdf.parse(DateUtil.dateStr4(date2)));
        
        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        
        //开始日期若小月结束日期
        if(year<0){
            year=-year;
            return year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
        }
       
        return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
	}

	/**
	 * 计算两个日期之间相差的小时数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int hoursBetween(Date date1, Date date2) {

		DateFormat sdf = new SimpleDateFormat(DATEFORMAT_STR_012);
		Calendar cal = Calendar.getInstance();
		try {
			Date d1 = sdf.parse(DateUtil.dateStr7(date1));
			Date d2 = sdf.parse(DateUtil.dateStr7(date2));
			cal.setTime(d1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(d2);
			long time2 = cal.getTimeInMillis();
			return Integer.parseInt(String.valueOf((time2 - time1) / 3600000L));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
