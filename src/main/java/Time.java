import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Time {
  SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
  
  private String sdate;

  public Time() {
    nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    sdate = nowdate.format(new java.util.Date());
    
  }

  public static void getDate(){
    Date date = new Date();
    SimpleDateFormat fmt = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a");
    System.out.println("The time now is : " + fmt.format(date));
  }
  
  public boolean checkTime(String date) throws ParseException {
    Date date1 = nowdate.parse(sdate);
    Date date2 = nowdate.parse(date);
    
    if (date1.compareTo(date2) != 1) {
      return true;
    }
    
    return false;
  }
  

  public boolean timeComing(String date) throws ParseException {
    Date date1 = nowdate.parse(sdate);
    Date date2 = nowdate.parse(date);
    
    long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000); 
    if (day <= 3) {
      return true;
    }
    
    return false;
  }
  

  public boolean timeDele(String time1, String time2) throws ParseException {
    Date date1 = nowdate.parse(time1);
    Date date2 = nowdate.parse(time2);
    
    long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000); 
    if (day == 0) {
      return true;
    }
    
    return false;
  }
}
