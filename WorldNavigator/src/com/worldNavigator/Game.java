package com.worldNavigator;

import com.worldNavigator.Exceptions.*;
import com.worldNavigator.mapBuilder.*;
import com.worldNavigator.mapObjects.Player;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

  Scanner scan = new Scanner(System.in);
  ArrayList<MapCreationTemplate> maps = new ArrayList<>();
  boolean timerDone = false;

  Game() {
    maps.add(Map1Builder.getInstance());
    maps.add(Map2Builder.getInstance());
  }

  public void startMap(int index) {
    Player player = maps.get(index - 1).buildLevel();
    System.out.println("Welcome to map #" + index);
    Timer timer = new Timer(maps.get(index - 1).getDurationOfGame(), this);
    timer.start();
    while (commandTranslator(player)) {}
  }

  private void winGame() {
    System.out.println("Congrats you won!!!");
  }

  private void loseGame() {
    System.out.println("You lost");
  }

  private boolean restartGame() {
    System.out.println("Would you like to restart game?");
    System.out.println("Enter Yes | No ?");
    String confirm = scan.next();
    return confirm.equals("Yes");
  }

  private boolean isValidCommand(String command) {
    try {
      Player.class.getDeclaredMethod(command);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private boolean commandTranslator(Player player) {
    if (timerDone) {
      loseGame();
      return false;
    }
    String command = scan.next();
    if (command.equals("quit") || command.equals("restart")) {
      loseGame();
      return false;
    }
    if (isValidCommand(command)) {
      try {

        Method m = Player.class.getMethod(command);
        m.invoke(player);

      } catch (NoSuchMethodException | IllegalAccessException e) {
        System.out.println("Invalid command");
      } catch (InvocationTargetException e) {
        if (e.getTargetException().getClass().equals(WinningException.class)) {
          winGame();
          return false;
        }
      }
    } else {
      System.out.println("Invalid command");
    }

    return true;
  }

  public boolean homePage() {
    System.out.println("Welcome to World Navigator");
    int mapNum;
    while (true) {
      System.out.println("Enter map number");
      mapNum = scan.nextInt();
      if (mapNum > 0 && mapNum <= maps.size()) {
        startMap(mapNum);
        return restartGame();
      } else {
        System.out.println("No such map exists");
      }
    }
  }

  public void endTimer() {
    timerDone = true;
  }
}
