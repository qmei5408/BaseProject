import static org.junit.Assert.assertTrue;
import org.junit.Test;


import java.io.IOException;
import java.text.ParseException;
import static org.junit.Assert.*;


public class RecordTest {

  @Test
  public void testAdd() throws IOException {
    Record tst = new Record();
    assertTrue(tst.add("Math","2018-01-20","Add"));
  }

  @Test
  public void testRead() throws IOException, ParseException {
    Record tst = new Record();
    assertTrue(tst.read(1));
  }

  @Test
  public void testDel() throws IOException, ParseException {
    Record tst = new Record();
    // input test case add
    assertTrue(tst.del());

  }

  @Test
  public void testCopyFile() throws IOException {
    assertTrue(Record.copyFile("123","123"));
  }

}
