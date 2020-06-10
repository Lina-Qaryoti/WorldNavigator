package com.worldNavigator;

import com.worldNavigator.Exceptions.LosingException;
import com.worldNavigator.Game;

public class Timer extends Thread {

  private long durationOfGame; // in milli seconds
  private Game game;

  public Timer(long durationOfGame, Game game) {
    this.durationOfGame = durationOfGame;
    this.game = game;
  }

  public void run() {
    try {
      Thread.sleep(durationOfGame);
      game.endTimer();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
