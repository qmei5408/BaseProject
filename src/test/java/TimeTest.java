import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TimeTest {

    @Test
    public void getDatetest() {

        assertNotEquals(Time.getDate(), "2016.12.12 09:20" );

    }

    @Test
    public void errorCheckingBeforeDate() throws Exception {
        Time err = new Time();
        assertTrue(err.errorCheckingBeforeDate("2016.12.12 09:20"));
    }

    @Test
    public void errorCheckingBeforeDate2() throws Exception {
        Time err = new Time();
        assertEquals(err.errorCheckingBeforeDate("2017.12.12 09:20"), true);
    }

    @Test
    public void errorCheckingDateUsed() throws Exception {
       Time err = new Time();
       assertTrue(err.errorCheckingDateUsed("2017.12.12 09:20", "2017.12.12 09:20"));
    }
    
    @Test
    public void checkTime() throws ParseException {
      Time err = new Time();
      assertTrue(err.checkTime("2018-02-15"));
      assertFalse(err.checkTime("2017-01-15"));
    }
    
    @Test
    public void timeComing() throws ParseException {
      Time err = new Time();
      assertTrue(err.timeComing("2018-01-17"));
      assertFalse(err.timeComing("2017-02-15"));
      assertFalse(err.timeComing("2018-02-15"));
    }
    
    @Test
    public void timeDel() throws ParseException {
      Time err = new Time();
      assertTrue(err.timeDele("2018-02-15","2018-02-15"));
      assertFalse(err.timeDele("2017-02-15","2018-02-15"));
    }
    
}
