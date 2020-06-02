package com.worldNavigator.Items;

public class Lock {
    private Key key;
    private boolean locked;

    public Lock(Key key){
        this.key=key;
        locked =true;
    }

    public boolean isLocked(){
        return locked;
    }

    public void lock(){
        locked = true;
    }

    public void unlock(){
        locked = false;
    }

    public Key getKey(){
        return key;
    }

    public boolean useKey(Key userKey){
        if(userKey.equals(key)){
            if(isLocked()){
                unlock();
            }
            else{
                lock();
            }
            return true;
        }
        return false;
    }
}
