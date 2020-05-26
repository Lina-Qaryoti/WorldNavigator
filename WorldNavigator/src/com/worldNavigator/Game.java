package com.worldNavigator;

import com.worldNavigator.mapBuilder.*;
import com.worldNavigator.mapObjects.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);

    public void startGame(){
        Player newPlayer = Map1Builder.getInstance().buildLevel();
        System.out.println("Welcome to map1");
        while(true){
            commandTranslator(newPlayer);
        }
    }

    private boolean isValidCommand(String command){
        try{
            Player.class.getDeclaredMethod(command);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private void commandTranslator(Player player){
        String command= scan.next();
        if(isValidCommand(command)){
            try{
                Method m =Player.class.getMethod(command);
                m.invoke(player,command);
            }
            catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            }

        }
        else{
            System.out.println("Invalid command");
        }
    }

    public void homePage(){
        System.out.println("Welcome to World Navigator");
        int mapNum;
        while (true){
            System.out.println("Enter map number");
            mapNum= scan.nextInt();
            String mapName="Map"+mapNum+"Builder";
            String className= "com.worldNavigator.mapBuilder."+mapName;
            try {
                Class.forName(className);
                System.out.println("success");
                startGame();
            }
            catch (ClassNotFoundException e){
                System.out.println("No such map exists");
            }
        }
    }

}
