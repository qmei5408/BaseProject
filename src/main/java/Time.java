

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;


public class Time {
    //Get system's current time and date and displays it
    public static void getDate() {
        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a");
        System.out.println("The time now is : " + fmt.format(date));
    }
    //this method checks if date and time entered is before the system date/time
    public void errorCheckingBeforeDate(String time) throws Exception {
        String dateVal = time;
        SimpleDateFormat simplef = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date1 = simplef.parse(dateVal);//convert to format above
        Date sysDate = new Date();//system date/time
        if (date1.before(sysDate)) {
            System.out.println("The date you enter has already passed\n try again!");
            System.exit(1);
            }
    }
    //Check if date entered has already been used by previous activity.
    // uses temp.txt
    public void errorCheckingDateUsed(String time, String time2) throws Exception {
        String dateVal = time;
        String date1Val = time2;
        SimpleDateFormat simplef = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date1 = simplef.parse(dateVal);//entered date/time
        Date date2 = simplef.parse(date1Val);//saved date/time

        if (date1.equals(date2)) {
            System.out.println("There is already an activity for this date and time\n try again!");
            System.exit(1);
            }
    }
}

