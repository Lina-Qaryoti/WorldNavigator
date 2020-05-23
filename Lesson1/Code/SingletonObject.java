
public class SingletonObject {

    private static SingletonObject soloInstance = new SingletonObject();

    private SingletonObject(){

    }

    public static SingletonObject getInstance(){
        return soloInstance;
    }

}

