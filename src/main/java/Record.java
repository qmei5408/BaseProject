import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Scanner;

public class Record {
  
  private String filename = "Homework.txt";

  public boolean add(String name, String date, String note) throws IOException{
    FileWriter fw = new FileWriter(filename,true);
    
    fw.write(date + "\r\n");
    fw.flush();
    fw.write(name + "\r\n");
    fw.flush();
    fw.write(note + "\r\n");
    fw.flush();
    
    fw.close();
    
    return true;
  }
  

  public boolean read(int input) throws IOException, ParseException {
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);
    Time time = new Time();
    
    if (input == 1) {
      while (br.ready()) {
        System.out.println(br.readLine());
      }
    } else {
      while (br.ready()) {
        String date = br.readLine();
        if (time.timeComing(date)) {
          System.out.println(date);
          System.out.println(br.readLine());
          System.out.println(br.readLine());
        } else {
          br.readLine();
          br.readLine();
        }
        
        
      }
    }
   
    fr.close();
    
    return true;
  }
  

  public boolean del() throws IOException, ParseException {
    FileReader fr1 = new FileReader(filename);
    FileWriter fw1 = new FileWriter("test.txt");
    
    BufferedReader br1 = new BufferedReader(fr1);
    Time time = new Time();
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Input name");
    String name = scanner.nextLine();
    
    System.out.println("Input date(yyyy-MM-dd)");
    String date = scanner.nextLine();

    boolean check = false;
    
    while (br1.ready()) {
      String recdate = br1.readLine();
      String recname = br1.readLine();
      String recnote = br1.readLine();

      if (time.timeDele(date, recdate) && name.compareTo(recname) == 0) {
        System.out.println(recname);
        System.out.println(recdate);
        check = true;
      } else {
        fw1.write(recdate + "\r\n");
        fw1.flush();
        fw1.write(recname + "\r\n");
        fw1.flush();
        fw1.write(recnote + "\r\n");
        fw1.flush();
      }
    }
    
    boolean result = false;
    
    if (check) {
      result = true;
      copyFile("test.txt","Homework.txt");
    } else {
      result = false;
    }
    
    
    fw1.close();
    fr1.close();
    scanner.close();
    
    return result;
  }
  

  public static boolean copyFile(String string, String string2) throws IOException {
    InputStream fis = null;
    OutputStream fos = null;    
    try {
      fos = new FileOutputStream(string2);
      fis = new FileInputStream(string);
      byte[] b = new byte[1024];
      int off = 0;
      int len = 0;
      while ((len = fis.read(b)) != -1) {
        fos.write(b,off,len);        
      }
      fos.flush();
    } catch (IOException ioe) {
      throw ioe;
    } finally {
      fos.close();
      fis.close();
    }
    
    return true;
  } 
}
