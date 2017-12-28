
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Mainhw {

  public static void main(String[] args) throws ParseException, IOException {
    Scanner scanner = new Scanner(System.in);

    Time time = new Time();
    Record record = new Record();


    boolean test = true;
    while (test) {
      System.out.println("1.Add homework.");
      System.out.println("2.Delete homework.");
      System.out.println("3.View homework.");
      System.out.println("Exit. Any key.");
      int choose = scanner.nextInt();

      switch (choose) {
        case 1 :
          scanner.nextLine();
          System.out.println("Input Subject name.");
          String name = scanner.nextLine();
          System.out.println("Input homework information.");
          String note = scanner.nextLine();

          while (true) {
            System.out.println("Input time limit.(yyyy-MM-dd)");
            String date = scanner.nextLine();
            if (time.checkTime(date)) {
              record.add(name, date, note);
              break;
            } else {
              System.out.println("Time wrong, input again.");
            }
          }
          System.out.println("Done add");
          break;
        case 2 :
          record.del();
          break;
        case 3 :
          System.out.println("1.View all.");
          System.out.println("2.View the deadline is coming.");
          int input = scanner.nextInt();
          record.read(input);
          break;
        default:
          test = false;
          break;
      }
    }

    scanner.close();
  }

}

