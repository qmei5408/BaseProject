

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Time {
    //Get system's current time and date and displays it
    public static Date getDate() {
        Date date = new Date();
        //SimpleDateFormat fmt = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a");
        //System.out.println("The time now is : " + fmt.format(date));
        return date;
    }
    //this method checks if date and time entered is before the system date/time
    public boolean errorCheckingBeforeDate(String sTime) throws Exception {
        String dateVal = sTime;
        boolean status = false;
        SimpleDateFormat simplef = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date1 = simplef.parse(dateVal);//convert to format above
        Date sysDate = new Date();//system date/time
        if (date1.before(sysDate)) {
            status = true;
            return status;
            }
            else {
            status = false;
            return status;
        }
    }

    //Check if date entered has already been used by previous activity.
    // uses temp.txt
    public boolean errorCheckingDateUsed(String time, String time2) throws Exception {
        String dateVal = time;
        String date1Val = time2;
        boolean status;
        SimpleDateFormat simplef = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date1 = simplef.parse(dateVal);//entered date/time
        Date date2 = simplef.parse(date1Val);//saved date/time

        if (date1.equals(date2)) {
            status = true;
            return status;
            }
            else{
            status = false;
            return status;
        }
    }
    
    public boolean checkTime(String date) throws ParseException {
      SimpleDateFormat datenow = new java.text.SimpleDateFormat("yyyy-MM-dd");
      datenow.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      String sdate = datenow.format(new java.util.Date());
      
      Date date1 = datenow.parse(sdate);
      Date date2 = datenow.parse(date);
      
      if (date1.compareTo(date2) != 1) {
        return true;
      }
      
      return false;
    }
    
    public boolean timeComing(String date) throws ParseException {
      SimpleDateFormat datenow = new java.text.SimpleDateFormat("yyyy-MM-dd");
      datenow.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      String sdate = datenow.format(new java.util.Date());
      
      Date date1 = datenow.parse(sdate);
      Date date2 = datenow.parse(date);
      
      long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000); 
      if (day <= 3) {
        return true;
      }
      
      return false;
    }
    
    public boolean timeDele(String time1, String time2) throws ParseException {
      SimpleDateFormat datenow = new java.text.SimpleDateFormat("yyyy-MM-dd");
      datenow.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      
      Date date1 = datenow.parse(time1);
      Date date2 = datenow.parse(time2);
      
      long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000); 
      if (day == 0) {
        return true;
      }
      
      return false;
    }
}

