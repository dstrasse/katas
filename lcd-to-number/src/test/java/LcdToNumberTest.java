import org.junit.Test;

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

  private static final String ZERO =
          " _ \n" +
          "| |\n" +
          "|_|\n" +
          "   \n";
  private static final String ONE =
          "   \n" +
          "  |\n" +
          "  |\n" +
          "   \n";
  private static final String TWO =
          " _ \n" +
          " _|\n" +
          "|_ \n" +
          "   \n";
  private static final String THREE =
          " _ \n" +
          " _|\n" +
          " _|\n" +
          "   \n";
  private static final String FOUR =
          "   \n" +
          "|_|\n" +
          "  |\n" +
          "   \n";
  private static final String FIVE =
          " _ \n" +
          "|_ \n" +
          " _|\n" +
          "   \n";
  private static final String SIX =
          " _ \n" +
          "|_ \n" +
          "|_|\n" +
          "   \n";

  private static final String SEVEN =
          " _ \n" +
          "  |\n" +
          "  |\n" +
          "   \n";
  private static final String EIGHT =
          " _ \n" +
          "|_|\n" +
          "|_|\n" +
          "   \n";
  private static final String NINE =
          " _ \n" +
          "|_|\n" +
          " _|\n" +
          "   \n";


  @Test
  public void testParseFirstLine() {
    assertThat(Arrays.asList(0, 2, 3, 5, 6, 7, 8, 9), is(equalTo(LcdToNumber.parseLine(" _ ", 1))));
    assertThat(Arrays.asList(1, 4), is(equalTo(LcdToNumber.parseLine("   ", 1))));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseFirstLineError() throws Exception {
    LcdToNumber.parseLine(" a ", 1);
  }

  @Test
  public void testParseSecondLine() {
    // check
    // '  | ' ->    1, 7
    assertThat(Arrays.asList(1, 7), is(equalTo(LcdToNumber.parseLine("  |", 2))));
    // '  _|' ->    2, 3
    assertThat(Arrays.asList(2, 3), is(equalTo(LcdToNumber.parseLine(" _|", 2))));
    // '|_|'  ->    4, 8, 9
    assertThat(Arrays.asList(4, 8, 9), is(equalTo(LcdToNumber.parseLine("|_|", 2))));
    // ' _ '  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine(" _ ", 2))));
    // '|_ '  ->    5, 6
    assertThat(Arrays.asList(5, 6), is(equalTo(LcdToNumber.parseLine("|_ ", 2))));
    // '|  '  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine("|  ", 2))));
    // '| |'  ->    0
    assertThat(Arrays.asList(0), is(equalTo(LcdToNumber.parseLine("| |", 2))));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseSecondLineFirstCharError() throws Exception {
    LcdToNumber.parseLine("a  ", 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseSecondLineSecondCharError() throws Exception {
    LcdToNumber.parseLine(" a ", 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseSecondLineThirdCharError() throws Exception {
    LcdToNumber.parseLine("  a", 2);
  }

  @Test
  public void testParseThirdLine() {
    // check
    // '  |'  ->    1, 4, 7
    assertThat(Arrays.asList(1, 4, 7), is(equalTo(LcdToNumber.parseLine("  |", 3))));
    // '  _|' ->    3, 5, 9
    assertThat(Arrays.asList(3, 5, 9), is(equalTo(LcdToNumber.parseLine(" _|", 3))));
    // '|_|'  ->    6, 8
    assertThat(Arrays.asList(0, 6, 8), is(equalTo(LcdToNumber.parseLine("|_|", 3))));
    // ' _ '  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine(" _ ", 3))));
    // '|_ '  ->    2
    assertThat(Arrays.asList(2), is(equalTo(LcdToNumber.parseLine("|_ ", 3))));
    // '|  '  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine("|  ", 3))));
    // '| |'  ->    x
    assertThat(new ArrayList<Integer>(0), is(equalTo(LcdToNumber.parseLine("| |", 3))));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseThirdLineFirstCharError() throws Exception {
    LcdToNumber.parseLine("a  ", 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseThirdLineSecondCharError() throws Exception {
    LcdToNumber.parseLine(" a ", 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseThirdLineThirdCharError() throws Exception {
    LcdToNumber.parseLine("  a", 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseInvalidLineNr() throws Exception {
    LcdToNumber.parseLine("  a", 4);
  }

  @Test
  public void testParseDigit_0() {
    assertThat(0, is(LcdToNumber.parseDigit(ZERO)));
  }

  @Test
  public void testParseDigit_1() {
    assertThat(1, is(LcdToNumber.parseDigit(ONE)));
  }

  @Test
  public void testParseDigit_2() {
    assertThat(2, is(LcdToNumber.parseDigit(TWO)));
  }

  @Test
  public void testParseDigit_3() {
    assertThat(3, is(LcdToNumber.parseDigit(THREE)));
  }

  @Test
  public void testParseDigit_4() {
    assertThat(4, is(LcdToNumber.parseDigit(FOUR)));
  }

  @Test
  public void testParseDigit_5() {
    assertThat(5, is(LcdToNumber.parseDigit(FIVE)));
  }

  @Test
  public void testParseDigit_6() {
    assertThat(6, is(LcdToNumber.parseDigit(SIX)));
  }

  @Test
  public void testParseDigit_7() {
    assertThat(7, is(LcdToNumber.parseDigit(SEVEN)));
  }

  @Test
  public void testParseDigit_8() {
    assertThat(8, is(LcdToNumber.parseDigit(EIGHT)));
  }

  @Test
  public void testParseDigit_9() {
    assertThat(9, is(LcdToNumber.parseDigit(NINE)));
  }
}
