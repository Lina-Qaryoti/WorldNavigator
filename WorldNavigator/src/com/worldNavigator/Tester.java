package com.worldNavigator;


public class Tester {
    public static void main(String[] args) {
        boolean flag= true;
        while (flag) {
            Game newGame = new Game();
            flag = newGame.homePage();
        }
    }
}
