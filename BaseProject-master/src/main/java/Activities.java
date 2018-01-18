import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Activities {

    static String actName;
    static String sTime;
    static int idNum;

    public Activities(String actName) {
        this.actName = actName;
    }// Constructor for activities. only initializes one
                                                                 //variable

    public static void add(String actName, String sTime) throws Exception {
        SimpleDateFormat fmt = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a");
        System.out.println("The time now is : " + fmt.format(Time.getDate()));//show time and date at
                                                                                //beginning of function call
        String id = "";
        String time ="";
        String temp = "";
        Database idN = new Database();
        idNum = idN.line(); // get the number of lines in the Database.txt, used for creating activity number
        id= Integer.toString(idNum); //change the integer idNum to a string
        time = id;

//      System.out.println("What is the name of the activity?");// Get name of Activity
        Scanner scan =  new Scanner(System.in);
//      actName = scan.nextLine();
        id = id.concat(" ");// add a space between Activity number and Activity name
        id = id.concat(actName);// Make both Activity number and Activity name into one string
        Database write = new Database();
//      System.out.println("Enter date of activity as \"2004.07.18 04:14\""); //get Date and Time
//      sTime = scan.nextLine();
        temp = sTime;// this temo value is used with temp.txt, simply to store all dates and times so we can check
                    //if used at later time
        Time err = new Time();

        if(err.errorCheckingBeforeDate(sTime)){
            System.out.println("The date you enter has already passed\n try again!");
            System.exit(1);
        }

        time = time.concat(" ");//same as with Activity name and number *Activity name and Date/Time has same number*
        time = time.concat(sTime);
        scan.close();
        Database check = new Database();
        check.CheckFile(sTime);
        write.WriteFile(id, null);
        write.WriteFile(time, temp);
    }

    //View all contents of Database.txt
    public static void view(){
        System.out.println("Viewing All activities!");
        Database viewAct = new Database();
        viewAct.ReadFile();
    }
    //Delete something from Database.txt
    public static void delete(String idnum){
        Database da = new Database();
        da.delete(idnum);

    }
}
