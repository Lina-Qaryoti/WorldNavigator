package com.worldNavigator;

public class Tester {

  public static void main(String[] args) {
    boolean flag = true;
    while (flag) {
      Game newGame = new Game();
      flag = newGame.homePage();
    }
    System.out.println("Thank you for Playing");
    System.exit(0);
  }
}
