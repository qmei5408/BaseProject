import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TimeForHomework {

	public void thMenu() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Show the remaining time which can be used to do homework");
		System.out.println("Now is : " + Time.getDate());
		String fileName1 = "Database.txt";
		String fileName2 = "Homework.txt";
		String line = null;
		int x;
		ArrayList<String> TimeOfDB = new ArrayList();
		ArrayList<String> TimeOfH = new ArrayList();
		ArrayList<String> NameOfH = new ArrayList();

		try {
			FileReader read = new FileReader(fileName1);// create new file
														// reader
			BufferedReader buffR = new BufferedReader(read);// place the file
			x = 0;
			while ((line = buffR.readLine()) != null) {// while not eof "end of
														// file"
				x++;
				if (x % 2 == 0) {
					TimeOfDB.add(line.substring(2));
				}
			}
			buffR.close(); // close the buffered reader
			// Error handling
		} catch (FileNotFoundException ex) {
			System.out.println("Failed to open " + fileName1);
		} catch (IOException ex) {
			System.out.println("Unable to read file " + fileName1);
			ex.printStackTrace(); // we could just use this to show errors
		}

		try {
			FileReader read = new FileReader(fileName2);// create new file
														// reader
			BufferedReader buffR = new BufferedReader(read);// place the file
															// reader in a
															// buffered reader
			x = 0;
			while ((line = buffR.readLine()) != null) {// while not eof "end of
														// file"
				x++;
				if ((x - 1) % 3 == 0) {
					TimeOfH.add(line);
				} else if ((x - 2) % 3 == 0) {
					NameOfH.add(line);
				}
			}
			buffR.close(); // close the buffered reader
			
			// Error handling
		} catch (FileNotFoundException ex) {
			System.out.println("Failed to open " + fileName2);
		} catch (IOException ex) {
			System.out.println("Unable to read file " + fileName2);
			ex.printStackTrace(); // we could just use this to show errors
		}
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String nowString = formatter.format(currentTime);
		int diff = 0;
		for (int i = 0; i < TimeOfH.size(); i++) {
			System.out.println("The deadline of homework"+NameOfH.get(i) +" is "+TimeOfH.get(i));
			try {

				diff = differenceDate(currentTime, TimeOfH.get(i));
				if(diff>0)
				    System.out.println("And its remaining hour time is :"+diff);
				else
					System.out.println("And its remaining hour time is :"+" over");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int differenceDate(Date FD, String SD) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long diff = 0;
		long start = FD.getTime();
		long end = sdf.parse(SD).getTime();
		diff = (end - start) / 1000 / 60 / 60;
		return (int) diff;
	}
	


}
