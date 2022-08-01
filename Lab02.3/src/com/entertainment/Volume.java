/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public interface Volume {
  public void setVolume(int volume);
  public int getVolume();

  public boolean isMuted();
  void setMuted (boolean muted);
void setOldVolume(int volume);
public int getOldVolume();
  default void mute(){
    if (!isMuted()) {           // not currently muted
      setOldVolume(getVolume()); // store current volume in oldVolume
      setVolume(0);             // set volume to zero
    }
    else {                      // currently muted
      setVolume(getOldVolume());     // restore volume from oldVolume value
    }
    setMuted(!isMuted());         // toggle muted flag
  }

  default public void silence() {
    setVolume(0);
  }

  static void silenceAll(Volume... vols){
    for(Volume vol : vols){
      vol.silence();
    }
  }


}