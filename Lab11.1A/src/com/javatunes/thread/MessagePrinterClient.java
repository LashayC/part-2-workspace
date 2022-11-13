/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    // TODO: create two instances of your thread subclass and start them up
    Thread lightSleeper = new MessagePrinter("Taking a cat nap", 250);
    lightSleeper.start();

    new MessagePrinter("Sleeping soundly", 1000).start(); //NOTE you don't have to store thread in a variable. You can also just instantiate and start it right away.


  }
}