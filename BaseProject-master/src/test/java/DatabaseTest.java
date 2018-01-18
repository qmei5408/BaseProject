import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void readFile() {
        Database dat = new Database();
        int line1 = dat.line();
        dat.WriteFile("Test", "test");
        int line2 = dat.line();
        assertTrue(line1< line2);
    }

    @Test
    public void writeFile() {

        Database dat = new Database();
        int line1 = dat.line();
        dat.WriteFile("Test", "test");
        int line2 = dat.line();
        assertNotEquals(line1, line2);

    }

    @Test
    public void checkFile() throws Exception {
//
    }

    @Test
    public void delete() {
        Database dat = new Database();
        int line1 = dat.line();
        dat.delete("Test");
        int line2 = dat.line();
        assertNotEquals(line1, line2);
    }

    @Test
    public void line() {
        Database dat = new Database();
        assertTrue(dat.line() >-1);
    }
}
