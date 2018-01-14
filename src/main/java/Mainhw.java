import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Mainhw {

  public void homeworkMenu(){
    Scanner scanner = new Scanner(System.in);

    Time time = new Time();
    Record record = new Record();
    int choose;
    String name;
    String date;
    String note;
    
    System.out.println("1.Add homework.");
    System.out.println("2.Delete homework.");
    System.out.println("3.View homework.");
    System.out.println("Exit. Any key.");
    choose = scanner.nextInt();
      
    switch (choose) {
      case 1 :
        scanner.nextLine();
        System.out.println("Input Subject name.");
        name = scanner.nextLine();
        System.out.println("Input homework information.");
        note = scanner.nextLine();
    
        while (true) {
          System.out.println("Input time limit.(yyyy-MM-dd)");
          date = scanner.nextLine();
          try {
            if (time.checkTime(date)) {
              if(record.add(name, date, note)) {
                System.out.println("Done add");
              }
              break;
            } else {
              System.out.println("Time wrong, input again.");
            }
          } catch (ParseException e) {
            System.out.println("Time format wrong!!");
          } catch (IOException e) {
            System.out.println("Time format wrong!!");
          }
        }
        break;
      case 2 :
      try {
        if(record.del()) {
          System.out.println("Delete Done");
        }else {
          System.out.println("No this data");
        }
      } catch (IOException | ParseException e) {
        System.out.println("No this file.");
      }
        break;
      case 3 :
        System.out.println("1.View all.");
        System.out.println("2.View the deadline is coming.");
        int input = scanner.nextInt();
      try {
        record.read(input);
      } catch (IOException | ParseException e) {
        System.out.println("No this file.");
      }
        break;
      default:
        break;
    }
    scanner.close();
  }

}
