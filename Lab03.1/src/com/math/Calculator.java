/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

public class Calculator {
  
  public int add(int a, int b) {
    return a + b;
  }
  
  public double divide(int a, int b) {//NOTE to quickly generate tetst methods, click on name > opt+return > generate missed test methods
    //return 1.0 * a / b;  // convert to double, otherwise int / int -> int, e.g., 7/3 = 2
    return (double) a / b; //NOTE this double cast happens at compile time so that it treats a and b as a double before dividing.
  }
  
  public boolean isEven(int x) {
    return x % 2 == 0;
  }
}