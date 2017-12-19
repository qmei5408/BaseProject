
import java.io.*;
import java.util.Scanner;


public class Database {
    /**
     * This is the database function. Its role is to read, write and check database.txt
     *
     *
     */

    String fileName = "Database.txt";
    String line = null; // used when reading from file
    String fromFile; // used also when reading from file but iin the check method

    //Reads data from Database.txt
    public void ReadFile() {


        try {
            FileReader read = new FileReader(fileName);// create new file reader
            BufferedReader buffR = new BufferedReader(read);// place the file reader in a buffered reader
            while ((line = buffR.readLine()) != null) {// while not eof "end of file"
                System.out.println(line);
            }
            buffR.close(); // close the buffered reader
            //Error handling
        } catch (FileNotFoundException ex) {
            System.out.println("Failed to open " + fileName);
        } catch (IOException ex) {
            System.out.println("Unable to read file " + fileName);
            ex.printStackTrace(); // we could just use this to show errors
        }
    }

    // Writing to Database.txt
    //Mostly the same as the read method
    public void WriteFile(String actName) {
        try {

            FileWriter write = new FileWriter(fileName, true);// true is added here because we want to append
            BufferedWriter buffW = new BufferedWriter(write);          // the file
            buffW.write(actName);//Write name of activity
            buffW.newLine();// go to new line
            buffW.close();
            System.out.println("Write Successful");// just so we know information was added successfully
            //Error handling
        } catch (IOException ex) {
            System.out.println("Unable to write to " + fileName);
            ex.printStackTrace();
        }
    }
    // Method to check if activity with the same time already exists
    // **!!currently buggy always gives true, need to check!!**
    public boolean CheckFile(String actName, String sTime) {


        boolean success = true;
        Scanner check = new Scanner(fileName);// set Scanner to read from Database.txt
        while (check.hasNextLine()) {// while we are not at the end of the file do comparison
            fromFile = check.nextLine();// get net line in file
            if (fromFile.contains(actName) || fromFile.contains(sTime)) {
                success = false;
            }
            else
                success = true;
        }
        return success;
    }
}
