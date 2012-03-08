/**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * TODO[dst] javadoc
 */
public class Wrapper {
  
  public static String wrap(String string, int length) {
    StringBuilder result = new StringBuilder();
    Scanner s = new Scanner(string);
    s.useDelimiter(" ");
    StringBuilder tmp = new StringBuilder();
    Pattern pattern = Pattern.compile(generatePattern(length));
    while (s.hasNext()) {

      String nextToken = s.findWithinHorizon(pattern, length);
      if (tmp.length() + nextToken.length() <= length) {
        tmp.append(nextToken.trim());
      } else {
        result.append(tmp.toString()).append("\n");
        tmp = new StringBuilder(nextToken.trim());
      }
    }
    result.append(tmp);
    return result.toString();
  }
  
  private static String generatePattern(int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      builder.append("(.*{1," + (length - i) + "}(\\s|\\z)?)");
      if (length - i != 1) {
        // not last iteration? append |
        builder.append("|");
      }
    }
    System.out.println("Pattern: " + builder.toString());
    return builder.toString();
  }
}
