
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Sugar City Calendar\n");
        System.out.println("1. HomeWork");
        System.out.println("2. Activities");
        System.out.println("3. Something else");
        System.out.println("4. Something else");
        System.out.println("5. Exit Program");
        int in = input.nextInt();
        switch (in){
            case 1:
                //武漢
                break;
            case 2:
                ActivityMenu menu = new ActivityMenu();
                menu.Amenu();
                break;
            case 3:
                //other
                break;
            case 4:
                //other
                break;
                default:
                    System.out.println("Exiting Program");
                    break;
        }
    }
}
