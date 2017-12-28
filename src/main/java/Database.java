
import java.io.*;

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
    public void WriteFile(String actName, String temp) {
        try {

            FileWriter write = new FileWriter(fileName, true);// true is added here because we want to append
            FileWriter writeTemp = new FileWriter("temp.txt", true);
            BufferedWriter buffW = new BufferedWriter(write);          // the file
            BufferedWriter buffTemp = new BufferedWriter(writeTemp);
            buffW.write(actName);//Write name of activity
            if (temp != null) {
                buffTemp.write(temp);
                buffTemp.newLine();
                buffTemp.close();
            }
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
    public void CheckFile (String sTime) {
        String checking = "";
        Time see = new Time();
        try {
            FileReader read = new FileReader("temp.txt");// create new file reader
            BufferedReader buffR = new BufferedReader(read);// place the file reader in a buffered reader
            while ((checking = buffR.readLine()) != null) {// while not eof "end of file"
                try {
                    if (see.errorCheckingDateUsed(sTime,checking)){
                        System.out.println("There is already an activity for this date and time\n try again!");
                        System.exit(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            buffR.close(); // close the buffered reader
            //Error handling
        } catch (FileNotFoundException ex) {
            System.out.println("Failed to open temp.txt");
        } catch (IOException ex) {
            System.out.println("Unable to read file temp.txt");
            ex.printStackTrace(); // we could just use this to show errors
        }

    }

    //Deletes any Activity along with its time from Database.txt
    public void delete(String actName){
        String toDelete;
        try {
            File file = new File(fileName);
            if (!file.isFile()) {//error handling
                System.out.println("Not a file");
                return;
            }
            File temp = new File(file.getAbsolutePath() + ".tmp");// creates a temporary file, all info from
                                                                            //Database.txt will be stored here
            FileReader read = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(read);
            PrintWriter print = new PrintWriter(new FileWriter(temp));
            while ((toDelete = buff.readLine()) != null) {// while not at end of file
                if (!toDelete.trim().startsWith(actName)) {//check for activity number
                    print.println(toDelete);
                    print.flush();
                }
            }
            buff.close();
            print.close();
            if (!file.delete()) {
                System.out.println("Unable to delete file");
            }
            if (!temp.renameTo(file)) {
                System.out.println("Could not rename file");
            }
        }
            catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
            System.out.println("Deleted Successfully");
        }

        public int line(){
            int lines=0;

            try {
                FileReader read = new FileReader(fileName);// create new file reader
                BufferedReader buffR = new BufferedReader(read);// place the file reader in a buffered reader
                while ((line = buffR.readLine()) != null) {// while not eof "end of file"
                    lines++;
                }
                buffR.close(); // close the buffered reader
                //Error handling
            } catch (FileNotFoundException ex) {
                System.out.println("Failed to open " + fileName);
            } catch (IOException ex) {
                System.out.println("Unable to read file " + fileName);
                ex.printStackTrace(); // we could just use this to show errors
            }
            return lines;
        }
}
