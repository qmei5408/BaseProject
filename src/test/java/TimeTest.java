import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
}
