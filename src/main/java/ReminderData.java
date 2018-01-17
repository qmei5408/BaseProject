import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReminderData {
	  String[] array = new String[100];
	  private String filename = "RMData.txt";
	  Scanner scanner = new Scanner(System.in);
	  Calendar rightnow = Calendar.getInstance();
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
	  
	  public boolean add(String name, String date) throws IOException{ //add new schedule
	    FileWriter fw = new FileWriter(filename,true);
	    
	    fw.write(date + "\r\n");
	    fw.flush();
	    fw.write(name + "\r\n");
	    fw.flush();
	    
	    fw.close();
	    
	    return true;
	  }
	  

	  public boolean read() throws IOException, ParseException {  //read all schedule
	    FileReader fr = new FileReader(filename);
	    BufferedReader br = new BufferedReader(fr);
	    while(br.ready()) {
	    	for(int i=0 ; i<100 ; i++) {
	    		array[i]= br.readLine();
	    		if(array[i] != null)
	    			System.out.println(array[i]);
	    	}
	    }

	    return true;
	  }
	  

	  public boolean del() throws IOException, ParseException {  //delete schedule
	    FileReader fr1 = new FileReader(filename);
	    FileWriter fw1 = new FileWriter("RM.txt");
	    
	    BufferedReader br1 = new BufferedReader(fr1);
	    Time time = new Time();
	    
	    System.out.println("Input date and time(yyyy-mm-dd hh:mm): ");
	    String date = scanner.nextLine();
	    
	    System.out.println("Input course name: ");
	    String name = scanner.nextLine();

	    boolean check = false;
	    
	    while (br1.ready()) {
	      String recdate = br1.readLine();
	      String recname = br1.readLine();

	      if (time.timeDele(date, recdate) && name.compareTo(recname) == 0) {
	    	check = true;
	      } else {
	        fw1.write(recdate + "\r\n");
	        fw1.flush();
	        fw1.write(recname + "\r\n");
	        fw1.flush();
	      }
	    }
	    
	    boolean result = false;
	    
	    if (check) {
	      result = true;
	      copyFile("RM.txt","RMData.txt");
	    } else {
	      result = false;
	    }
	    
	    fw1.close();
	    fr1.close();
	    
	    return result;
	  }
	  

	  public static boolean copyFile(String string, String string2) throws IOException {  //for delete method
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
	  
	  public boolean compareTime() throws IOException, ParseException{  //compare current time to the schedule
		  String current = String.format("%04d-%02d-%02d %02d:%02d", rightnow.get(Calendar.YEAR)
				  												   ,rightnow.get(Calendar.MONTH)+1
				  												   ,rightnow.get(Calendar.DAY_OF_MONTH)
				  												   ,rightnow.get(Calendar.HOUR_OF_DAY)
				  												   ,rightnow.get(Calendar.MINUTE));
		  System.out.println("Current Time: \n" + current);
		  
		    FileReader fr = new FileReader(filename);
		    BufferedReader br = new BufferedReader(fr);
		    while(br.ready()) {
		    	for(int i=0 ; i<100 ; i++) {
		    		array[i]= br.readLine();
		    	}
		    }
		    
		    for(int i=0; i<100; i++) {
	    		if(array[i] != null) {
	    			 if(i % 2 == 0) {
	    				String sub = array[i].substring(0, 10);
	    				String sub1 = current.substring(0, 10);
	    				String sub2 = array[i].substring(11, 13);
	    				String sub3 = current.substring(11,13);
	    				String sub4 = array[i].substring(14, 16);
	    				String sub5 = current.substring(14, 16);
	    				if(sub1.equals(sub)) {
	    					if(sub3.compareTo(sub2)<=0 && sub5.compareTo(sub4)<0) {
	    						System.out.println("Upcoming schedule: \n" + array[i] + "\n" + array[i+1]);
	    					}else if(sub3.compareTo(sub2)<0){
	    						System.out.println("Upcoming schedule: \n" + array[i] + "\n" + array[i+1]);
	    					}
	    				}
	    			}
	    		}
		    }
		    fr.close();
		    
		    return true;
	  }
}
