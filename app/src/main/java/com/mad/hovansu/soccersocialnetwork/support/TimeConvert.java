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
}
