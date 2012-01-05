import org.apache.commons.collections.ListUtils;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Daniel
 * Date: 04.01.12
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
public class LcdToNumber {

  public static int parseDigit(String lcdDigit) {
    List<Integer> numbersList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    Scanner s = new Scanner(lcdDigit);
    List<Integer> matchingNumbersFirstLine = parseFirstLine(s.nextLine());
    List<Integer> matchingNumbersSecondLine = parseSecondLine(s.nextLine());
    List<Integer> matchingNumbersThirdLine = parseThirdLine(s.nextLine());

    List<Integer> intersection = ListUtils.intersection(numbersList, matchingNumbersFirstLine);
    intersection = ListUtils.intersection(intersection, matchingNumbersSecondLine);
    intersection = ListUtils.intersection(intersection, matchingNumbersThirdLine);

    assert intersection.size() == 1;

    return intersection.get(0);
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
    throw new IllegalArgumentException("Line number " + lineNr + " out of range");
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
    char c;
    switch (c = line.charAt(0)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0, 4, 5, 6, 8, 9));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(1, 2, 3, 7));
        break;
      default:
        throw new IllegalArgumentException("Character " + c + " unexpected in second line.");
    }
    switch (c = line.charAt(1)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(2, 3, 4, 5, 6, 8, 9));
        break;
      case '_':
        numbersList.removeAll(Arrays.asList(0, 1, 7));
        break;
      default:
        throw new IllegalArgumentException("Character " + c + " unexpected in second line.");
    }
    switch (c = line.charAt(2)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0, 1, 2, 3, 4, 7, 8, 9));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(5, 6));
        break;
      default:
      throw new IllegalArgumentException("Character " + c + " unexpected in second line.");
    }

    return numbersList;
  }

  private static List<Integer> parseThirdLine(String line) {
    // ArrayList required here as instance because AbstractList does not support removeAll
    List<Integer> numbersList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
   char c;
    switch (c = line.charAt(0)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0,2,6,8));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(1,3,4,5,7,9));
        break;
      default:
        throw new IllegalArgumentException("Character " + c + " unexpected in third line.");
    }
    switch (c = line.charAt(1)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0,2,3,5,6,8,9));
        break;
      case '_':
        numbersList.removeAll(Arrays.asList(1,4,7));
        break;
      default:
        throw new IllegalArgumentException("Character " + c + " unexpected in third line.");
    }
    switch (c = line.charAt(2)) {
      case ' ':
        numbersList.removeAll(Arrays.asList(0,1,3,4,5,6,7,8,9));
        break;
      case '|':
        numbersList.removeAll(Arrays.asList(2));
        break;
      default:
        throw new IllegalArgumentException("Character " + c + " unexpected in third line.");
    }

    return numbersList;
  }
  
}
