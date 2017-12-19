


import java.util.Scanner;

public class Activities {

    static String actName;
    static String sTime;

    public Activities(String actName) {
        this.actName = actName;
    }

    public static void add() {
        Time.getDate();
        System.out.println("What is the name of the activity?");
        Scanner scan =  new Scanner(System.in);
        actName = scan.nextLine();
        Database write = new Database();
        System.out.println("Enter date of activity as \"Sun 2004.07.18 at 04:14:09 PM\"");
        sTime = scan.nextLine();
        scan.close();
        Database check = new Database();
        if(check.CheckFile(actName, sTime)){
            write.WriteFile(actName);
            write.WriteFile(sTime);
        }
        else
            System.out.println("The Activity might have already been added");

    }

    public static void view(){
        System.out.println("Viewing All activities!");
        Database viewAct = new Database();
        viewAct.ReadFile();
    }

    public static void delete(String actName){

    }
}
