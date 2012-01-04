import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Daniel
 * Date: 04.01.12
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public class LcdToNumberTest {

  private static final String ONE =
  " " +
  "|" +
  "|" +
  " ";

  @Test
  public void testParseDigit_1() {
    assertThat(1, is(LcdToNumber.parseDigit(ONE)));
  }

  @Test
  public void testParseFirstLine() {
    assertThat(Arrays.asList(0,2,3,5,6,7,8,9), is(equalTo(LcdToNumber.parseLine(" _ ", 1))));
    assertThat(Arrays.asList(1,4), is(equalTo(LcdToNumber.parseLine("   ", 1))));
  }

  @Test
  public void testParseSecondLine() {
    // check
    // '  | ' ->    1, 7
    assertThat(Arrays.asList(1,7), is(equalTo(LcdToNumber.parseLine("  |", 2))));
    // '  _|' ->    2, 3
    assertThat(Arrays.asList(2,3), is(equalTo(LcdToNumber.parseLine(" _|", 2))));
    // '|_|'  ->    4, 8, 9
    assertThat(Arrays.asList(4,8,9), is(equalTo(LcdToNumber.parseLine("|_|", 2))));
    // ' _ '  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine(" _ ", 2))));
    // '|_ '  ->    5, 6
    assertThat(Arrays.asList(5,6), is(equalTo(LcdToNumber.parseLine("|_ ", 2))));
    // '|  '  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine("|  ", 2))));
    // '| |'  ->    0
    assertThat(Arrays.asList(0), is(equalTo(LcdToNumber.parseLine("| |", 2))));
  }

  public void testParseThirdLine() {
     // check
    // '  |'  -> 1, 7
  }

}
