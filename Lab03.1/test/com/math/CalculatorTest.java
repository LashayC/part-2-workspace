/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest { //NOTE Tests below may not always run in order their written. Doesn't matter.


  @Test
  public void add() {//NOTE The name was originally 'testADD' but IntelliJ only recognizes a class has a test on it if the name is exactly the same.
    System.out.println("Testing the add method"); //NOTE: This is just to see that your test ran in console.
    Calculator calc = new Calculator(); //NOTE: you have to invoke a method before testing it.
    assertEquals(5, calc.add(1, 4));  //NOTE: 5 is expected, (1,4) is actual //NOTE: if the assertEquals evaluates to true it'll return green, if not it'll return red.
  }

  @Test
  public void divide() {
    Calculator calc = new Calculator(); //NOTE each method test has its own instance of the class
    assertEquals(2.5, calc.divide(5, 2), 0.00000001); //NOTE assertEquals is deprecated (it compares double against double types and nothing else. Alot of nums can't be represented by a double and conversion loses precision)
     //NOTE: whenever checking floating point values you need to set you're tolerance. The third argument is saying that the other two args are that many decimal points within each other.
  }

  @Test
  public void isEven() {
    Calculator calc = new Calculator();
    assertTrue(calc.isEven(6)); //Note, this tests for boolean. You can also use assertEquals
  }
}