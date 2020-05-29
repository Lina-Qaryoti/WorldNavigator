package com.worldNavigator.mapBuilder;

public class Timer extends Thread {

    private long durationOfGame; //in milli seconds

    public Timer(long durationOfGame){
        this.durationOfGame=durationOfGame;
    }

    public void run(){
        try {
            Thread.sleep(durationOfGame);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //game over
    }
}
