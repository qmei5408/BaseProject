import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;

public class Reminder {
	
	Scanner scan = new Scanner(System.in);
	Time time = new Time();
	ReminderData rd = new ReminderData();

	public void ReminderMenu() {
		int select = 0;
		
		while(select != 5) {
			
			System.out.println("1. Add class schedule.");
			System.out.println("2. Delete class schedule.");
			System.out.println("3. View schedule.");
			System.out.println("4. Reminder.");
			System.out.println("5. Exit.");
			select = scan.nextInt();
			
			switch(select) {
				case 1:
					addSchedule();
					System.out.println();
					break;
				case 2:
					deleteSchedule();
					System.out.println();
					break;
				case 3:
					showSchedule();
					System.out.println();
					break;
				case 4:
					remind();
					System.out.println();
					break;
				case 5:
					break;
				default:
					System.out.println("Wrong input!");
					System.out.println();
					break;
			}
		}
	}
	
	public void addSchedule() {
		
		String course;
		String date;
		scan.nextLine();
		System.out.println("Input date and time: (yyyy-mm-dd hh:mm): ");
		date = scan.nextLine();
		
		while(true) {
			System.out.println("Input new course: ");
			course = scan.nextLine();
			try {
				if(time.checkTime(date)) {
					if(rd.add(course, date)) {
						System.out.println("Adding Complete.");
					}
					break;
				}else {
					System.out.println("Time error, input again.");
				}
			} catch(IOException | ParseException e) {
				System.out.println("Time format error!"); 
			}
		}
	}
	
	public void deleteSchedule() {
		try {
			if(rd.del()) {
				System.out.println("Deletion Complete.");
			}else {
				System.out.println("Data not found!");
			}
		} catch(IOException | ParseException e) {
			System.out.println("Data not found!");
		}
	}
	
	public void showSchedule() {
		try {
			rd.read();
		} catch(IOException | ParseException e) {
			System.out.println("Data not found!");
		}
	}
	
	public void remind() {
		try {
			if(rd.compareTime()) {
				
			}else {
				System.out.println("Data not found!");
			}
		} catch(IOException | ParseException e) {
			System.out.println("Data not found!");
		}
	}
}
