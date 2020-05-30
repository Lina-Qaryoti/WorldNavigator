package com.worldNavigator;

import com.worldNavigator.Exceptions.LosingException;
import com.worldNavigator.Exceptions.WinningException;
import com.worldNavigator.mapBuilder.*;
import com.worldNavigator.mapObjects.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);

    public void startMap1(){
        Player newPlayer = Map1Builder.getInstance().buildLevel();
        System.out.println("Welcome to map1");
        while(commandTranslator(newPlayer));

    }

    private void winGame(){
        System.out.println("Congrats you won!!!");
    }

    private void loseGame(){
        System.out.println("You lost");
    }

    private boolean restartGame(){
        System.out.println("Would you like to restart game?");
        System.out.println("Enter Yes | No ?");
        String confirm= scan.next();
        if(confirm.equals("Yes")){
            return true;
        }
        else
            return false;
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

    private boolean commandTranslator(Player player){
        String command= scan.next();
        if(command.equals("quit") || command.equals("restart")) {
            loseGame();
            return false;
        }
        if(isValidCommand(command)){
            try{
                Method m =Player.class.getMethod(command);
                m.invoke(player);
            }
            catch (NoSuchMethodException | IllegalAccessException e){
                System.out.println("Invalid command");
            }
            catch (InvocationTargetException e){ //catches custom excpetions
                if(e.getTargetException().getClass().equals(WinningException.class)) {
                    winGame();
                    return false;
                }

                if(e.getTargetException().getClass().equals(LosingException.class)){
                    loseGame();
                    return false;
                }
            }
        }
        else{
            System.out.println("Invalid command");
        }

        return true;
    }

    public boolean homePage(){
        System.out.println("Welcome to World Navigator");
        int mapNum;
        while (true){
            System.out.println("Enter map number");
            mapNum= scan.nextInt();
            String mapName="Map"+mapNum+"Builder";
            String className= "com.worldNavigator.mapBuilder."+mapName;
            try {
                Class.forName(className);
                if(mapNum==1)
                    startMap1();

                return restartGame();
            }
            catch (ClassNotFoundException e){
                System.out.println("No such map exists");
            }
        }
    }

}
