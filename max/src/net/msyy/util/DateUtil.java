package net.msyy.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 
	 * @return String yyyy-MM-dd HH:mm:ss.000
	 */
	public static String getNowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000");
		return sdf.format(new Date());
	}
	
	public static String parse(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000");
		return sdf.format(sdf.parse(date));
	}
	
	/**
	 * 
	 * @return Date: yyyy-MM-dd
	 */
	public static Date getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @return String: yyyy-MM-dd
	 */
	public static String Now() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public static String flow() {
		char c='A';
		c=(char)(c+(int)(Math.random()*26));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		return c+sdf.format(new Date());
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "sldhf=ab.jpg";
		str = str.substring(str.lastIndexOf("=")+1, str.lastIndexOf("."));
		System.out.println(str);
	}
}
