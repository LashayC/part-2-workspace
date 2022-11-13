/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

// DONE: extend the Thread class
public class MessagePrinter extends Thread {

  private final String message;
  private final long sleepInterval;

  public MessagePrinter(String message, long sleepInterval) {
    // DONE: set the thread name [important when debugging]
    super("Thread: "
        + message); //NOTE this names the thread. The superclass constructor sets the name
    this.message = message;
    this.sleepInterval = sleepInterval;
  }

  /**
   * TODO: implement run() as follows:
   * It should loop 10 times, printing the 'message' field to stdout,
   * then pausing for some interval (in millis) that you choose.
   * <p>
   * Use a try/catch to call Thread.sleep(interval) for the pause.
   * The sleep() method throws InterruptedException, which you need to catch.
   * You can either leave the catch block empty, or print the exception to stdout.
   */
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println(message);
        Thread.sleep(sleepInterval); //NOTE better to use the Timer class then using time, not sleep.
      } catch (InterruptedException ignored) {
        // Get on with your life; this is not a serious problem, and doesn't prevent us from continuing.
      }
    }
  }

}