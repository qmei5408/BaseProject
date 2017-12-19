
import java.text.SimpleDateFormat;
import java.util.*;

public class Time {

    public static void getDate(){
        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a");
        System.out.println("The time now is : " + fmt.format(date));
    }

//    public void errorChecking(){
//
//    }
}
