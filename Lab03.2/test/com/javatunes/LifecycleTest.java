package com.javatunes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifecycleTest {

  @Before
  public void beforeTest() throws Exception {
    System.out.println("beforeTest");
  }

  @After
  public void afterTest() throws Exception {
    System.out.println("afterTest");
  }

  @BeforeClass
  public static void beforeTestRun() throws Exception {
    System.out.println("beforeTestRun");
  }

  @AfterClass
  public static void afterTestRun() throws Exception {
    System.out.println("afterTestRun");
  }

  @Test
  public void testSomething() {
    System.out.println("testSomething");
  }

  @Test
  public void testSomethingElse() {
    System.out.println("testSomethingElse");
  }
}
