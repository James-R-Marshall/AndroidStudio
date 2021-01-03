package com.james.android.Objects;

import android.provider.CalendarContract;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class CalendarDate {


    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return  "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
    public String toDateString(){
        return ""+month+"/"+day+"/"+year+"\t" +hour+":"+minute;
    }
    public Vector<String> convertToListOFDateStrings(Vector<CalendarDate> v){
        Vector<String> dates = new Vector<String>();
        for (int i = 0; i < v.size(); i++) {
            dates.add(v.elementAt(i).toDateString());
        }
        return dates;
    }

    public void ParseShortString(String Sdate){
        String holder = new String();
        int values[] = new int[6];
        int x = 0;
        for (int i = 0; i < Sdate.length(); i++){
            if (Sdate.charAt(i) == ' '){
                values[x] = Integer.parseInt(holder);
                holder = "";
                x++;
            }
            else{
                holder+=Sdate.charAt(i);
            }
        }
        year = values[0];
        month = values[1];
        day = values[2];
        hour = values[3];
        minute = values[4];
        second = values[5];

    }

    public String toShortString() {
        return  "" + year +" "+
                 + month +" "+
                 + day +" "+
                 + hour +" "+
                 + minute +" "+
                 + second;
    }


    public long ConvertToMilliseconds(){
        Calendar c = Calendar.getInstance();
        c.set(year, month, day,hour,minute,0);
        return c.getTimeInMillis();
    }
}
