package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  public static final int INITIAL_VOLUME = 50;

  //NOTE Intllelij won't generate tests for constructor but you can still write them.

  private Television television;

  @Before
  public void setUp() throws Exception {
    television = new Television("Sony", INITIAL_VOLUME, DisplayType.OLED);
  }

  @Test
  public void getBrand() {
    fail("Not yet implemented"); //NOTE a good practice to ensure that empty tests fail instead of passing by default.
  }

  @Test
  public void setBrand() {
  }

  @Test
  public void getVolume() {
    assertEquals(INITIAL_VOLUME, television.getVolume());
  }

  @Test
  public void setVolume_valid() {//NOTE you'd also change this to have valid to be clear what both tests do
    television.setVolume(Television.MIN_VOLUME + 1);
  }
  @Test(expected = IllegalArgumentException.class)//NOTE tells Junit to expect an exception. If it doesn't it'll say test is failed.
  public void setVolumeInvalid() {//NOTE you can add tests like this to test for additional things.
    television.setVolume(Television.MIN_VOLUME - 1);
    assertEquals(Television.MIN_VOLUME +1, television.getVolume());//NOTE: Use getters to test the setters. Once you use the setter, you can use the getter to make sure something was actually changed.
  }

  @Test
  public void getCurrentChannel() {
  }

  @Test
  public void changeChannel() {
  }

  @Test
  public void getDisplay() {
  }

  @Test
  public void setDisplay() {
  }

  @Test
  public void compareTo() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testEquals() {
  }
}