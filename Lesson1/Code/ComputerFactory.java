
public class ComputerFactory {

    public Computer createComputer(String computerType){
        if(computerType.equalsIgnoreCase("Laptop"))
            return new Laptop();
        else if(computerType.equalsIgnoreCase("PC"))
            return new PC();
        else if(computerType.equalsIgnoreCase("Tablet"))
            return new Tablet();
        return null;
    }

}
