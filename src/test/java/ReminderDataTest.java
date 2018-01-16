import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class ReminderDataTest {
	
	void testAdd() throws IOException{
		ReminderData test = new ReminderData();
		assertTrue(test.add("Biology", "2018-01-19 19:30"));
	}
	
	void testRead() throws IOException, ParseException{
		ReminderData test = new ReminderData();
		assertTrue(test.read());
	}
	
	void testDelete() throws IOException, ParseException{
		ReminderData test = new ReminderData();
		assertTrue(test.del());
	}
	
	void testCopyFile() throws IOException {
		 assertTrue(ReminderData.copyFile("AAAA","AAAA"));
	}
	
	void testCompareTime() throws IOException, ParseException{
		ReminderData test = new ReminderData();
		assertTrue(test.compareTime());
	}
}
	
	
