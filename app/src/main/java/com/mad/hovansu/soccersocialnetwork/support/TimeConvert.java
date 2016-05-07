package com.mad.hovansu.soccersocialnetwork.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConvert {

	public static String getStringDatetime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dateFormat.format(cal.getTime());
	}
	public static Date getDatetime(String stringDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try
		{
			Date date = simpleDateFormat.parse(stringDate);
			return date;
		}
		catch (ParseException ex){
			return null;
		}
	}

	public static String getTimeLoading(Date current, Date now) {
		long time = now.getTime() - current.getTime();
		long days = time / (1000 * 60 * 60 * 24);
		time = time % (1000 * 60 * 60 * 24);

		long hours = time / (1000 * 60 * 60);
		time = time % (1000 * 60 * 60);

		long minutes = time / (1000 * 60);
		time = time %  (1000 * 60);

		long seconds = time / 1000;
		String timeLoad = "";
		if (days < 10) {
			timeLoad = timeLoad + "0" + days + ":";
		} else {
			timeLoad = timeLoad + String.valueOf(days) + ":";
		}
		if (hours < 10) {
			timeLoad = timeLoad + "0" + hours + ":";
		} else {
			timeLoad = timeLoad + String.valueOf(hours) + ":";
		}
		if (minutes < 10) {
			timeLoad = timeLoad + "0" + minutes + ":";
		} else {
			timeLoad = timeLoad + String.valueOf(minutes) + ":";
		}
		if (seconds < 10) {
			timeLoad = timeLoad + "0" + seconds;
		} else {
			timeLoad = timeLoad + String.valueOf(seconds);
		}
		return timeLoad;
	}

	public static long getLoadDays(Date oldDate, Date now) {
		long timeLoad = now.getTime() - oldDate.getTime();
		long days = timeLoad / (1000 * 60 * 60 * 24);
		return days;
	}
	public static Date getUtilTime(java.sql.Timestamp sqlTime){
		return new Date(sqlTime.getTime());
	}
	
	public static java.sql.Timestamp getSqlTime(Date utilTime){
		return new java.sql.Timestamp(utilTime.getTime());
	}

}
