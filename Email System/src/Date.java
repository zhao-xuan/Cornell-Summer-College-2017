package Homework02;

import java.time.*;

public class Date {
	//Date class can create object of the current time, or create a object with certain date.
	//Date can print itself through the method 'printDate()', 'printTime()' and 'printDateTime()'
	//'isEqualDate()' will return true if and only if two Date objects have the same date(not necessarily the same time).
	private LocalDateTime time = LocalDateTime.now();
	private String timeString = time.toString();

	private int month, day, year, hour, minute, second;
	
	public Date() {
		month = Integer.parseInt(timeString.substring(5, 7));
		day = Integer.parseInt(timeString.substring(8, 10));
		year = Integer.parseInt(timeString.substring(0, 4));
		hour = Integer.parseInt(timeString.substring(11, 13));
		minute = Integer.parseInt(timeString.substring(14, 16));
		second = Integer.parseInt(timeString.substring(17, 19));
	}
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = this.minute = this.second = (int)Double.NaN;
	}
	
	public int getMonth() { return month; }
	public int getDay() { return day; }
	public int getYear() { return year; }
	public int getHour() { return hour; }
	public int getMinute() { return minute; }
	public int getSecond() { return second; }
	
	public void setMonth(int month) { this.month = month; }
	public void setDay(int day) { this.day = day; }
	public void setYear(int year) { this.year = year; }
	
	public boolean isEqualDate(Date another) {
		if (this.getMonth() == another.getMonth() && this.getYear() == another.getYear()) {
			if (this.getDay() == another.getDay()) {
				return true;
			}
		}
		
		return false;
	}
	public void printDate() {
		System.out.println(month+"-"+day+"-"+year);
	}
	public void printTime() {
		System.out.println(hour+"h "+minute+"min "+second+"sec");
	}
	public void printDateTime() {
		System.out.print(month+"-"+day+"-"+year+" ");
		System.out.println(hour+"h "+minute+"min "+second+"sec");
	}
}