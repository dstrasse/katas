/**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * TODO[dst] javadoc
 */
public class WrapperTest {

  public static final String SIMPLE_STRING = "simple string";
  

  @Test
  public void testWrapSimple() throws Exception {
    assertThat(Wrapper.wrap(SIMPLE_STRING, SIMPLE_STRING.length()), is(equalTo(SIMPLE_STRING)));
  }

  @Test
  public void testWrapTwoWords() throws Exception {
    assertThat(Wrapper.wrap(SIMPLE_STRING, 6), is(equalTo("simple\nstring")));
  }

  @Test
  public void testLongerString() throws Exception {
    String longerString = "An apple a day keeps the doctor away";
    assertThat(Wrapper.wrap(longerString, 6), is(equalTo("An\napple\na day\nkeeps\nthe\ndoctor\naway")));
  }
  
}
