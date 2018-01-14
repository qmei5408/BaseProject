import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class RecordTest {

  @Test
  void testAdd() throws IOException {
    Record tst = new Record();
    assertTrue(tst.add("Math","2018-01-20","Add"));
  }

  @Test
  void testRead() throws IOException, ParseException {
    Record tst = new Record();
    assertTrue(tst.read(1));
  }

  @Test
  void testDel() throws IOException, ParseException {
    Record tst = new Record();
    // input test case add
    assertTrue(tst.del());
    
  }

  @Test
  void testCopyFile() throws IOException {
    assertTrue(Record.copyFile("123","123"));
  }

}
