import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Daniel
 * Date: 04.01.12
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
public class LcdToNumber {

  //static int[] numbers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

  public static int parseDigit(String lcdDigit) {
    return 1;
  }

  protected static List<Integer> parseLine(String line, int lineNr) {

    switch (lineNr) {
      case 1:
        return parseFirstLine(line);
      case 2:
        return parseSecondLine(line);
      case 3:
        return parseThirdLine(line);
    }
    return null;
  }

  private static List<Integer> parseFirstLine(String line) {
    if (line.equals("   ")) {
      return Arrays.asList(1, 4);
    }
    if (line.equals(" _ ")) {
      return Arrays.asList(0, 2, 3, 5, 6, 7, 8, 9);
    }
    throw new IllegalArgumentException("Character " + line + " unexpected in first line.");
  }

  private static List<Integer> parseSecondLine(String line) {
    // ArrayList required here as instance because AbstractList does not support removeAll
    List<Integer> numbersList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    switch (line.charAt(0)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0, 4, 5, 6, 8, 9));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(1, 2, 3, 7));
    }
    switch (line.charAt(1)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(2, 3, 4, 5, 6, 8, 9));
        break;
      case '_':
        numbersList.removeAll(Arrays.asList(0, 1, 7));
    }
    switch (line.charAt(2)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0, 1, 2, 3, 4, 7, 8, 9));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(5, 6));
    }

    return numbersList;
  }

  private static List<Integer> parseThirdLine(String line) {
    // ArrayList required here as instance because AbstractList does not support removeAll
    List<Integer> numbersList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    switch (line.charAt(0)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0,2,6,8));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(1,3,4,5,7,9));
    }
    switch (line.charAt(1)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0,2,3,5,6,8,9));
        break;
      case '_':
        numbersList.removeAll(Arrays.asList(1,4,7));
    }
    switch (line.charAt(2)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0,1,3,4,5,6,7,8,9));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(2));
    }

    return numbersList;
  }
  
}
