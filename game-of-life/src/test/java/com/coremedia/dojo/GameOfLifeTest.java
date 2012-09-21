package com.coremedia.dojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * TODO[dst] javadoc
 */
public class GameOfLifeTest {

  @Test
  public void testToString() throws Exception {
    String field =  "....\n" +
                    "....\n" +
                    ".**.\n" +
                    ".*.*\n";
    GameOfLife gameOfLife = new GameOfLife(field);
    assertEquals(field, gameOfLife.toString());
  }

  @Test
  public void testRuleOne() throws Exception {
    String field =  "*...\n" +
                    "....\n" +
                    ".**.\n" +
                    "....\n";

    String expected =  "....\n" +
                    ".*..\n" +
                    "....\n" +
                    "....\n";

    GameOfLife gol = new GameOfLife(field);
    gol.next();
    assertEquals(expected, gol.toString());
  }

  @Test
  public void testRuleOneAndTwoAndThreeAndFour() throws Exception {
    String field =  "*...\n" +
                    "***.\n" +
                    ".***\n" +
                    "....\n";

    String expected =  "*...\n" +
                       "*..*\n" +
                       "*..*\n" +
                       "..*.\n";

    GameOfLife gol = new GameOfLife(field);
    gol.next();
    assertEquals(expected, gol.toString());
  }

}
