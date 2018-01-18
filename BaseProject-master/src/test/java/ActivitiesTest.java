import org.junit.Test;

import static org.junit.Assert.*;

public class ActivitiesTest {

    @Test
    public void add() throws Exception {
        Database dat = new Database();
        int lineNum = dat.line();
        Activities act = new Activities("test");
        act.add("test for adding", "2019.5.20 12:31");
        int newLineNum = dat.line();
        assertTrue(lineNum == newLineNum-2);
    }

    @Test
    public void view() {
    }

    @Test
    public void delete() {
        Database dat = new Database();
        int line1 = dat.line();
        dat.WriteFile("test Delete", null);
        dat.delete("test");
        int line3 = dat.line();
        assertTrue(line1 == line3);
    }
}
