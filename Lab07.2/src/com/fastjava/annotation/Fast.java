/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.fastjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares a class or method to be "fast."
 * If declared at the type level, all methods will execute faster by the <b>"boost factor"</b> <code>value</code>.
 * If declared att the individual method level, that particular method will be faster.
 * If declared at both levels, any method-level declaration will override the type-level declaration.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) //NOTE This tel.... To make our annotations inspectable at runtime. //Source would mean its in the bytecode but the compiler would see it and strip it out. //Class loader loads things into memory from bytecode. Its something part of the build process that looks at they bytecode after its compiled  and does some build step as a result, ie Javadocs is an example.
//@Inherited
public @interface Fast {
  /**
   * Performance boost, expressed as a decimal, ranging from 0.0 (no boost) to 1.0 (100% faster).
   * Required attribute.
   */
    double boost(); //no default option bc it implies that its optional
  
  /**
   * Whether or not to log extra information about the performance boost (optional).
   * Includes real-time performance metrics data, in nanoseconds.
   */

  boolean log() default false; //NOTE: The naming convention is arbitary
  
  /**
   * Description (optional).
   */

  String description() default "";

}