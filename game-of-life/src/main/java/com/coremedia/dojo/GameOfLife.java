package com.coremedia.dojo;

/**
 * TODO[dst] javadoc
 */
public class GameOfLife {

  private boolean[][] field;

  public GameOfLife(String in) {
    parseInput(in);
  }

  private void parseInput(String inField) {
    String[] rows = inField.split("\n");
    field = new boolean[rows.length][rows[0].length()];

    for (int i = 0; i < rows.length; i++) {
      String row = rows[i];
      char[] chars = row.toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == '*') {
          field[i][j] = true;
        }
      }
    }
  }


  public void next() {
    boolean[][] newField = new boolean[field.length][field[0].length];

    for (int y = 0; y < field.length; y++) {
      for (int x = 0; x < field[0].length; x++) {
        int neighborCnt = neighborCount(x, y);
        if (field[y][x] && neighborCnt >= 2 && neighborCnt <= 3) {
          newField[y][x] = true;
        } else if (!field[y][x] && neighborCnt == 3) {
          newField[y][x] = true;
        }
      }
    }

    field = newField;
  }

  private int neighborCount(int x, int y) {
    int count = 0;
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {

        int currentY = y + i;
        int currentX = x + j;

        if (currentX != x || currentY != y) {

          if (currentX >= 0 && currentX < field[0].length && currentY >= 0 && currentY < field.length) {
            if (field[currentY][currentX]) {
              count++;
            }
          }
        }
      }
    }
    return count;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (boolean[] booleans : field) {
      for (boolean aBoolean : booleans) {
        result.append(aBoolean ? "*" : ".");
      }
      result.append("\n");
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String field =  "....\n" +
            "....\n" +
            ".***\n" +
            "....\n";

    String planetOfDeath =  "....\n" +
            "....\n" +
            "....\n" +
            "....\n";

    GameOfLife gol = new GameOfLife(field);
    String result = "";
    do {
      gol.next();
      result = gol.toString();
      System.out.println(result);
    } while (!result.equals(planetOfDeath));
  }


}
