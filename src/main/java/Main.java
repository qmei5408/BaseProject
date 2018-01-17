import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int in=0;
        while(in != 5) {
        System.out.println("Welcome to the Sugar City Calendar\n");
        System.out.println("1. HomeWork");
        System.out.println("2. Activities");
        System.out.println("3. Reminder");
        System.out.println("4. Something else");
        System.out.println("5. Exit Program");
        in = input.nextInt();
        switch (in){
            case 1:
                Mainhw hwmenu = new Mainhw();
                hwmenu.homeworkMenu();
                break;
            case 2:
                ActivityMenu menu = new ActivityMenu();
                menu.Amenu();
                break;
            case 3:
                Reminder rmenu = new Reminder();
                rmenu.ReminderMenu();
                break;
            case 4:
                //other
                break;
            case 5:
                System.out.println("Exiting Program");
                break;
                default:
                    System.out.println("Input not recognized");
                    System.out.println("Exiting Program");
                    break;
        }
        }
        input.close();
    }
}
